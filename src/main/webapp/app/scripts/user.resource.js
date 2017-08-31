(function() {
	angular
		.module('bsepApp')
		.factory('UserResource', ['Restangular', '_', '$log',
			function(Restangular, _, $log) {
			'use strict';

			var retVal = {};	//JSON objekat koji prosledjujemo controller-u

			retVal.login = function(user)	{
				return Restangular.all("users/login").post(user).then(function(response) {
					return response;
				});
			};

			retVal.register = function(user)	{
				return Restangular.all("users/registration").post(user).then(function(response) {
					return response;
				});
			};

			retVal.users = function() {
				return Restangular.all("users").getList().then(function(responses) {
					return responses;
				});
			};

			retVal.getUser = function(email) {
				return Restangular.one("users", email).get().then(function(response) {
					return response;
				});
			};

			retVal.request_to_change_password = function(user)	{
				return Restangular.all("users/request_to_change_password").post(user).then(function(response) {
					return response;
				});
			};

			retVal.change_password = function(user)	{
				return Restangular.all("users/change_password").post(user).then(function(response) {
					return response;
				});
			};

			return retVal;
		}]);

})(); //odmah se izvrsava
