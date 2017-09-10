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

			retVal.getSnippet = function(id) {
				return Restangular.one("snippets", id).get().then(function(response) {
					return response;
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

			retVal.create_not_reg = function(snippet)	{
				return Restangular.all("snippets/create_not_reg").post(snippet).then(function(responses) {
					return responses;
				});
			};

			retVal.getSnippetComments = function(id) {
				return Restangular.one("snippets", id).getList("comments").then(function(responses) {
					return responses;
				});
			};

			retVal.search_description = function(snippet)	{
				return Restangular.all("snippets/search_description").post(snippet).then(function(responses) {
					return responses;
				});
			};

			retVal.search_language = function(language)	{
				return Restangular.all("snippets/search_language").post(language).then(function(responses) {
					return responses;
				});
			};

			retVal.search_date = function(snippet)	{
				return Restangular.all("snippets/search_date").post(snippet).then(function(responses) {
					return responses;
				});
			};

			retVal.deleteSnippet = function(snippet) {
				return Restangular.all("snippets/delete").post(snippet).then(function(response) {
					return response;
				});
			};

			retVal.blockSnippet = function(snippet) {
				return Restangular.all("snippets/block_snippet").post(snippet).then(function(response) {
					return response;
				});
			};

			retVal.unblockSnippet = function(snippet) {
				return Restangular.all("snippets/unblock_snippet").post(snippet).then(function(response) {
					return response;
				});
			};
			return retVal;
		}]);

})(); //odmah se izvrsava
