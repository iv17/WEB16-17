(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('RequestToChangePasswordController', ['$scope', '$rootScope', '$state', '_', 'UserResource', '$stateParams', '$log', '$window','toastr',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window, toastr) {

				var email = $stateParams.email;


				UserResource.request_to_change_password(email)
				.then(function(item) {

					$window.location.href = '/#/proverite_mail';
				})
				.catch(function(error){

				});

			}
		]);
})();
