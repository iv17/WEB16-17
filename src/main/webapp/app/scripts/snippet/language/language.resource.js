(function() {
	angular
		.module('bsepApp')
		.factory('LanguageResource', ['Restangular', '_', '$log',
			function(Restangular, _, $log) {
			'use strict';

			var retVal = {};	//JSON objekat koji prosledjujemo controller-u

			retVal.addLanguage = function(language)	{
				return Restangular.all("languages/add").post(language).then(function(response) {
					return response;
				});
			};

			retVal.getLanguages = function() {
				return Restangular.all("languages").getList().then(function(responses) {
					return responses;
				});
			};

			retVal.getLanguage = function(id) {
				return Restangular.one("languages", id).get().then(function(response) {
					return response;
				});
			};

			return retVal;
		}]);

})(); //odmah se izvrsava
