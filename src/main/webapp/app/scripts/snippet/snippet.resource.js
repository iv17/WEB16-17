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

			retVal.getUserSnippets = function() {
				return Restangular.all("snippets/user_snippets").getList().then(function(responses) {
					return responses;
				});
			};

			retVal.getNotUserSnippets = function() {
				return Restangular.all("snippets/not_user_snippets").getList().then(function(responses) {
					return responses;
				});
			};

			retVal.create = function(snippet)	{
				return Restangular.all("snippets/create").post(snippet).then(function(responses) {
					return responses;
				});
			};

			return retVal;
		}]);

})(); //odmah se izvrsava
