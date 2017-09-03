(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('LoginController', ['$scope', '$rootScope', '$state', '_', 'UserResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				$localStorage.removeItem("token");
        $rootScope.loggedUser = null;
        $window.location.href = '/#/start_login';

			}
		]);
})();
