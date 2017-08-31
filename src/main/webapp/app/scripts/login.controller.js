(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('LoginController', ['$scope', '$rootScope', '$state', '_', 'UserResource', '$log', '$stateParams', '$window','toastr',
			function($scope, $rootScope, $state, _, UserResource, $log, $stateParams, $window, toastr) {

				var username = $stateParams.username;
				var password = $stateParams.password;

				var user = {
					email: username,
					username: username,
					password: password
				 };

				UserResource.login(user)
				.then(function(item) {
					$rootScope.loggedUser = item;

					$window.location.href = '/#/home';
					toastr.success('Ulogovali ste se kao: ' + $rootScope.loggedUser.username);
				})
				.catch(function(error){
						$window.location.href = '/#/login';
						toastr.error("Greska!\nPokusajte ponovo!");
				});

			}
		]);
})();
