(function() {
	angular
		.module('bsepApp')
		.factory('CommentResource', ['Restangular', '_', '$log',
			function(Restangular, _, $log) {
			'use strict';

			var retVal = {};	//JSON objekat koji prosledjujemo controller-u

			retVal.create = function(createCommentRequest)	{
				return Restangular.all("comments/create").post(createCommentRequest).then(function(response) {
					return response;
				});
			};

			retVal.create_not_reg = function(createCommentRequest)	{
				return Restangular.all("comments/create_not_reg").post(createCommentRequest).then(function(response) {
					return response;
				});
			};

			retVal.deleteComment = function(comment)	{
				return Restangular.all("comments/delete").post(comment).then(function(response) {
					return response;
				});
			};



			return retVal;
		}]);

})(); //odmah se izvrsava
