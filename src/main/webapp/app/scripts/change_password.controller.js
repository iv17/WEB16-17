(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('ChangePasswordController', ['$scope', '$rootScope', '$state', '_', 'UserResource', '$stateParams', '$log', '$window','toastr',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window, toastr) {

				var new_password = $stateParams.new_password;
				var new_password2 = $stateParams.new_password2;

				var user = {
					password = new_password;
					repeated_password = new_password2;
				}
				UserResource.forgot_password(user)
				.then(function(item) {

					$window.location.href = '/#/start_login';
					toastr.success('Uspesno ste promenili lozinku');
				})
				.catch(function(error){

				});

			}
		]);
})();
