(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('HomeController', ['$scope', '$rootScope', '$state', '_', 'UserResource', '$stateParams', '$log', '$window','toastr',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window, toastr) {

	  		UserResource.getNotBlockedUsers().then(function(items) {
        	$scope.notBlockedUsers = items;
        });

			}
		]);
})();
