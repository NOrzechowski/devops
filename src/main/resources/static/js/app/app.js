'use strict'

var devopsDemoApp = angular.module('devopsDemo', [ 'ui.bootstrap', 'devopsDemo.controllers', 'devopsDemo.services','chart.js' ,'ngTable']);
devopsDemoApp.constant("CONSTANTS", {
	getEmployeeByIdUrl : "/employee/getEmployee/",
	getAllEmployees : "/employee/getAllEmployees",
	saveEmployee : "/employee/saveEmployee",
	getCircleChartData : "/data/getCircleChartData"
});