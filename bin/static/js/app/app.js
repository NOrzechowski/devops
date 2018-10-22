'use strict'

var devopsDemoApp = angular.module('devopsDemo', [ 'ui.bootstrap', 'devopsDemo.controllers', 'devopsDemo.services','chart.js' ,'ngTable']);
devopsDemoApp.constant("CONSTANTS", {
	getUserByIdUrl : "/user/getUser/",
	getAllUsers : "/user/getAllUsers",
	saveUser : "/user/saveUser",
	getCircleChartData : "/data/getCircleChartData"
});