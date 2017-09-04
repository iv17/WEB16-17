(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('UsersController', ['$scope', '$state', '_', 'UserResource', '$log',
			function($scope, $state, _, UserResource, $log) {

				UserResource.getUsers()
				.then(function(items) {
						$scope.users = items;
				});

			}
		]);
})();
