(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('StartChangePasswordController', ['$scope', '$rootScope', '$state', '_', 'UserResource', '$stateParams', '$log', '$window','toastr',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window, toastr) {

				$rootScope.email = $stateParams.email;

			}
		]);
})();
