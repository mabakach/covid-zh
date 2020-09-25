package ch.mabaka.covid;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CovidStatEntry {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	private LocalDateTime dateTime;
	
	private int infectionCount;
	
	
	
	public CovidStatEntry(List<String> values) {
		if (values.size() >= 5) {
			String dateTimeString = String.format("%s %s", values.get(0), values.get(1));
			this.dateTime = LocalDateTime.parse(dateTimeString, formatter);
			this.infectionCount = Integer.valueOf(values.get(4));
		}
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public int getInfectionCount() {
		return infectionCount;
	}

	@Override
	public String toString() {
		return "Date / time:" + dateTime + " infection count: " + infectionCount;
	}
}
