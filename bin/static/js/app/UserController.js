'use strict'

var module = angular.module('devopsDemo.controllers', []);
module.controller("UserController", [ "$scope", "UserService", "NgTableParams",
		function($scope, UserService, NgTableParams) {

			$scope.userDto = {
				userId : null,
				userName : null,
				skillDtos : []
			};
			$scope.skills = [];
			
			$scope.labels = [];
			$scope.circleChartData = [];
			
			$scope.loadCircleData = function() {
				UserService.getCircleData().then(function(value){
					if(value.data){
						$scope.labels = value.data.legends;
						$scope.circleChartData = value.data.values;
					}
				});
			}
					
			$scope.tableParams = new NgTableParams({}, { dataset: $scope.allUsers});
					
			$scope.loadUsers = function() {
				UserService.getAllUsers().then(function(value) {
					$scope.allUsers = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}

			$scope.saveUser = function() {
				$scope.userDto.skillDtos = $scope.skills.map(skill => {
					return {skillId: null, skillName: skill};
				});
				UserService.saveUser($scope.userDto).then(function() {
				
					$scope.loadUsers ();
					$scope.loadCircleData();
					$scope.skills = [];
					$scope.userDto = {
						userId : null,
						userName : null,
						skillDtos : []
					};
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}
			
			
			$scope.loadUsers();
			$scope.loadCircleData();
		} ]);