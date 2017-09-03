(function() {
	angular
		.module('bsepApp')
		.factory('AccessResource', ['Restangular', '_', '$log',
			function(Restangular, _, $log) {
			'use strict';

			var retVal = {};	//JSON objekat koji prosledjujemo controller-u

			retVal.getAccesses = function() {
				return Restangular.all("accesses").getList().then(function(responses) {
					return responses;
				});
			};

			retVal.getAccess = function(id) {
				return Restangular.one("accesses", id).get().then(function(response) {
					return response;
				});
			};

			return retVal;
		}]);

})(); //odmah se izvrsava
