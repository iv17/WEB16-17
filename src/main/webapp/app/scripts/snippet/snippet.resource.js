(function() {
	angular
		.module('bsepApp')
		.factory('SnippetResource', ['Restangular', '_', '$log',
			function(Restangular, _, $log) {
			'use strict';

			var retVal = {};	//JSON objekat koji prosledjujemo controller-u

			retVal.getSnippets = function() {
				return Restangular.all("snippets").getList().then(function(responses) {
					return responses;
				});
			};

			return retVal;
		}]);

})(); //odmah se izvrsava
