(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('RequestToChangePasswordController', ['$scope', '$rootScope', '$state', '_', 'UserResource', '$stateParams', '$log', '$window','toastr',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window, toastr) {

				var email = $stateParams.email;

				var user = {
					email: email
				 };

				UserResource.request_to_change_password(user)
				.then(function(item) {
					$scope.user = item;

					$window.location.href = '/#/proverite_mail';
					toastr.info('Proverite mail!');
				})
				.catch(function(error){
						toastr.error("Greska!\nPokusajte ponovo!");
				});

			}
		]);
})();
