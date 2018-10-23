'use strict'

angular.module('devopsDemo.services', []).factory('DataService', 
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getEmployeeById = function(employeeId) {
				var url = CONSTANTS.getEmployeeByIdUrl + employeeId;
				return $http.get(url);
			}
			service.getAllEmployees = function() {
				return $http.get(CONSTANTS.getAllEmployees);
			}
			service.getCircleData = function() {
				return $http.get(CONSTANTS.getCircleChartData);
			}
			service.saveEmployee = function(employeeDto) {
				return $http.post(CONSTANTS.saveEmployee, employeeDto);
			}
			return service;
		} ]);