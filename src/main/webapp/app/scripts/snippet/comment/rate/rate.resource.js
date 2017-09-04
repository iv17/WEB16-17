(function() {
	angular
		.module('bsepApp')
		.factory('RateResource', ['Restangular', '_', '$log',
			function(Restangular, _, $log) {
			'use strict';

			var retVal = {};	//JSON objekat koji prosledjujemo controller-u

			retVal.createRatePlus = function(comment)	{
				return Restangular.all("ratings/add_plus").post(comment).then(function(response) {
					return response;
				});
			};

			retVal.createRateMinus = function(comment)	{
				return Restangular.all("ratings/add_minus").post(comment).then(function(response) {
					return response;
				});
			};
			return retVal;
		}]);

})(); //odmah se izvrsava
