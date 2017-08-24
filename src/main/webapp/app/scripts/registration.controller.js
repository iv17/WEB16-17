(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('RegistrationController', ['$scope', '$state', '_', 'UserResource', '$log', '$stateParams',
			function($scope, $state, _, UserResource, $log, $stateParams) {

				var name = $stateParams.name;
				var lastname = $stateParams.lastName;
				var email = $stateParams.email;
				var username = $stateParams.username;
				var password = $stateParams.password;
				var password_confirmation = $stateParams.password_confirmation;

				var user = {
					name: name,
					lastname: lastname,
					email: email,
					username: username,
					password: password,
					password_confirmation: password_confirmation
				 };

				UserResource.register(user).then(function(item) {
					$scope.registredUser = item;
					$log.log($scope.registredUser);
				});

			}
		]);
})();
