package com.neilo.aithre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neilo.aithre.dto.ChartDataDto;
import com.neilo.aithre.service.DataService;
import com.neilo.aithre.utils.Constants;

@RequestMapping("/data")
@RestController
public class DataController {

	@Autowired
	DataService dataService;

	@RequestMapping(Constants.GET_CIRCLE_CHART_DATA)
	public ChartDataDto getCircleChartData() {

		return dataService.getCircleChartData();
	}
}
