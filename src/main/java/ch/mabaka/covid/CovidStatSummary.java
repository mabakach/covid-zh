package ch.mabaka.covid;

import java.time.LocalDateTime;

public class CovidStatSummary {

	
	
	public CovidStatSummary(LocalDateTime rangeBegin, LocalDateTime rangeEnd, int numberOfNewInfections,
			int numnerOfNewInfectionsPer100000) {
		super();
		this.rangeBegin = rangeBegin;
		this.rangeEnd = rangeEnd;
		this.numberOfNewInfections = numberOfNewInfections;
		this.numnerOfNewInfectionsPer100000 = numnerOfNewInfectionsPer100000;
	}

	LocalDateTime rangeBegin;
	
	LocalDateTime rangeEnd;
	
	int numberOfNewInfections;
	
	int numnerOfNewInfectionsPer100000;

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

	public int getNumnerOfNewInfectionsPer100000() {
		return numnerOfNewInfectionsPer100000;
	}

	public void setNumnerOfNewInfectionsPer100000(int numnerOfNewInfectionsPer100000) {
		this.numnerOfNewInfectionsPer100000 = numnerOfNewInfectionsPer100000;
	}
}
