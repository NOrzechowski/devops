'use strict'

angular.module('devopsDemo.services', []).factory('UserService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getUserById = function(userId) {
				var url = CONSTANTS.getUserByIdUrl + userId;
				return $http.get(url);
			}
			service.getAllUsers = function() {
				return $http.get(CONSTANTS.getAllUsers);
			}
			service.getCircleData = function() {
				return $http.get(CONSTANTS.getCircleChartData);
			}
			service.saveUser = function(userDto) {
				return $http.post(CONSTANTS.saveUser, userDto);
			}
			return service;
		} ]);