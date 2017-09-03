(function() {
	angular
		.module('bsepApp')
		.factory('VisibilityResource', ['Restangular', '_', '$log',
			function(Restangular, _, $log) {
			'use strict';

			var retVal = {};	//JSON objekat koji prosledjujemo controller-u

			retVal.getVisibilities = function() {
				return Restangular.all("visibilities").getList().then(function(responses) {
					return responses;
				});
			};

			retVal.getVisibility = function(id) {
				return Restangular.one("visibilities", id).get().then(function(response) {
					return response;
				});
			};

			return retVal;
		}]);

})(); //odmah se izvrsava
