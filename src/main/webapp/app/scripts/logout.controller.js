(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('LogoutController', ['$scope', '$rootScope', '$state', '_', 'UserResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				$localStorage.token = null;
        $rootScope.loggedUser = null;
        $window.location.href = '/#/start_login';

			}
		]);
})();
