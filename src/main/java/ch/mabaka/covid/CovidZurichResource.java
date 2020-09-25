package ch.mabaka.covid;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;


@Path("/zurich")
public class CovidZurichResource {

	private static final Logger LOGGER = Logger.getLogger(CovidZurichResource.class);

	@ConfigProperty(name = "covid.csv.url", defaultValue = "https://raw.githubusercontent.com/openZH/covid_19/master/fallzahlen_kanton_total_csv_v2/COVID19_Fallzahlen_Kanton_ZH_total.csv")
	String covidCsvUrl;

	@GET
	@Path("/averageInfectionsPer100000Past14Days")
	@Produces(MediaType.APPLICATION_JSON)
	public Response averageInfectionsPer10000Past14Days() {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(covidCsvUrl)).build();
		HttpResponse<String> response;
		try {
			response = client.send(request, BodyHandlers.ofString());
			if (response.statusCode() >= 200 && response.statusCode() < 300) {
				String content = response.body();
				String[] lines = content.split("\n");
				List<CovidStatEntry> statEntries = new ArrayList<>();
				// ignore header line
				boolean isFirstLine = true;
				for (String line : lines) {
					List<String> values = CSVUtils.parseLine(line);
					if (!isFirstLine) {
						statEntries.add(new CovidStatEntry(values));
					}
					isFirstLine = false;
				}
				if (statEntries.size() >= 14) {
					CovidStatEntry lastEntry = statEntries.get(statEntries.size() - 1);
					CovidStatEntry entryBefore14Days = statEntries.get(statEntries.size() - 15);
					LOGGER.info(lastEntry);
					LOGGER.info(entryBefore14Days);
					int numberOfNewInfectionsIn14Days = lastEntry.getInfectionCount() - entryBefore14Days.getInfectionCount();
					CovidStatSummary summary = new CovidStatSummary(entryBefore14Days.getDateTime(), lastEntry.getDateTime(), numberOfNewInfectionsIn14Days, (int)(numberOfNewInfectionsIn14Days / 15.1f));
					return Response.ok(summary).build();
				} else {
					return Response.ok("To view data").build();
				}
			} else {
				LOGGER.error("Could not load data got response code " + response.statusCode());
				return Response.status(500).build();
			}
		} catch (Exception e) {
			LOGGER.error("Could not load data", e);
			return Response.status(500).build();
		}
	}
	
}