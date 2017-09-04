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

			return retVal;
		}]);

})(); //odmah se izvrsava
