(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('RegistrationController', ['$scope', '$state', '_', 'UserResource', '$stateParams', '$log', '$window','toastr',
			function($scope, $state, _, UserResource, $stateParams, $log, $window, toastr) {

				var name = $stateParams.name;
				var lastname = $stateParams.lastName;
				var email = $stateParams.email;
				var username = $stateParams.username;
				var password = $stateParams.password;
				var repeated_password = $stateParams.repeated_password;

				var user = {
					name: name,
					lastname: lastname,
					email: email,
					username: username,
					password: password,
					repeated_password: repeated_password
				 };

				UserResource.register(user)
				.then(function(item) {
					$scope.registratedUser = item;

					$window.location.href = '/#/start_login';
					toastr.success('Uspesno ste se registrovali! Molimo Vas da se sada prijavite!');
				})
				.catch(function(error){
						$window.location.href = '/#/start_register';
						toastr.error("Greska!");
				});

			}
		]);
})();
