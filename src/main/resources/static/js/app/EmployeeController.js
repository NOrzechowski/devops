'use strict'

var module = angular.module('devopsDemo.controllers', []);
module.controller("EmployeeController", [ "$scope", "DataService", "NgTableParams",
		function($scope, EmployeeService, NgTableParams) {

			$scope.employeeDto = {
				employeeId : null,
				employeeName : null,
				skillDtos : []
			};
			$scope.skills = [];
			
			$scope.labels = [];
			$scope.circleChartData = [];
			
			$scope.loadCircleData = function() {
				EmployeeService.getCircleData().then(function(value){
					if(value.data){
						$scope.labels = value.data.legends;
						$scope.circleChartData = value.data.values;
					}
				});
			}
					
			$scope.tableParams = new NgTableParams({}, { dataset: $scope.allEmployees});
					
			$scope.loadEmployees = function() {
				EmployeeService.getAllEmployees().then(function(value) {
					$scope.allEmployees = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}

			$scope.saveEmployee = function() {
				$scope.employeeDto.skillDtos = $scope.skills.map(skill => {
					return {skillId: null, skillName: skill};
				});
				EmployeeService.saveEmployee($scope.employeeDto).then(function() {
				
					$scope.loadEmployees ();
					$scope.loadCircleData();
					$scope.skills = [];
					$scope.employeeDto = {
						employeeId : null,
						employeeName : null,
						skillDtos : []
					};
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}
			
			
			$scope.loadEmployees();
			$scope.loadCircleData();
		} ]);