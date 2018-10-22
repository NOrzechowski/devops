package com.neilo.aithre.dto;

import java.util.ArrayList;
import java.util.List;

public class ChartDataDto {

	List<String> legends = new ArrayList<>();
	List<Integer> values = new ArrayList<>();

	public ChartDataDto() {
	}

	public ChartDataDto(List<String> legends, List<Integer> values) {
		this.legends = legends;
		this.values = values;
	}

	public List<String> getLegends() {
		return legends;
	}

	public void setLegends(List<String> legends) {
		this.legends = legends;
	}

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}

}
