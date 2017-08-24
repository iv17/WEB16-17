(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('UserController', ['$scope', '$state', '_', 'UserResource', '$log', '$stateParams',
			function($scope, $state, _, UserResource, $log, $stateParams) {

				var username = $stateParams.username;
				var password = $stateParams.password;

				var user = {
					username: username,
					password: password
				 };

				UserResource.login(user).then(function(item) {
					$scope.loggedUser = item;
					$log.log($scope.loggedUser);
				});

			}
		]);
})();
