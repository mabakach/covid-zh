package ch.mabaka.covid;

import java.time.LocalDateTime;

public class CovidStatSummary {

	
	
	public CovidStatSummary(LocalDateTime rangeBegin, LocalDateTime rangeEnd, int numberOfNewInfections,
			int numberOfNewInfectionsPer100000) {
		super();
		this.rangeBegin = rangeBegin;
		this.rangeEnd = rangeEnd;
		this.numberOfNewInfections = numberOfNewInfections;
		this.numberOfNewInfectionsPer100000 = numberOfNewInfectionsPer100000;
	}

	LocalDateTime rangeBegin;
	
	LocalDateTime rangeEnd;
	
	int numberOfNewInfections;
	
	int numberOfNewInfectionsPer100000;

	public LocalDateTime getRangeBegin() {
		return rangeBegin;
	}

	public void setRangeBegin(LocalDateTime rangeBegin) {
		this.rangeBegin = rangeBegin;
	}

	public LocalDateTime getRangeEnd() {
		return rangeEnd;
	}

	public void setRangeEnd(LocalDateTime rangeEnd) {
		this.rangeEnd = rangeEnd;
	}

	public int getNumberOfNewInfections() {
		return numberOfNewInfections;
	}

	public void setNumberOfNewInfections(int numberOfNewInfections) {
		this.numberOfNewInfections = numberOfNewInfections;
	}

	public int getNumberOfNewInfectionsPer100000() {
		return numberOfNewInfectionsPer100000;
	}

	public void setNumberOfNewInfectionsPer100000(int numnerOfNewInfectionsPer100000) {
		this.numberOfNewInfectionsPer100000 = numnerOfNewInfectionsPer100000;
	}
}
