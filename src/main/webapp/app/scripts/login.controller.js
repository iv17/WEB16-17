(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('LoginController', ['$scope', '$state', '_', 'UserResource', '$log', '$stateParams', '$window','toastr',
			function($scope, $state, _, UserResource, $log, $stateParams, $window, toastr) {

				var username = $stateParams.username;
				var password = $stateParams.password;

				var user = {
					username: username,
					password: password
				 };

				UserResource.login(user)
				.then(function(item) {
					$scope.loggedUser = item;
					
					$window.location.href = '/#/home';
					toastr.success('Uspesno ste se ulogovali!');
				})
				.catch(function(error){
						$window.location.href = '/#/login';
						toastr.error("Pogresni kredencijali!");

				});

			}
		]);
})();
