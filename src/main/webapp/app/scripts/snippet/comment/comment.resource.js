(function() {
	angular
		.module('bsepApp')
		.factory('CommentResource', ['Restangular', '_', '$log',
			function(Restangular, _, $log) {
			'use strict';

			var retVal = {};	//JSON objekat koji prosledjujemo controller-u

    
			return retVal;
		}]);

})(); //odmah se izvrsava
