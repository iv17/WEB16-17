(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('SearchUserByUsernameController', ['$scope', '$rootScope', '$state', '_', 'UserResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var username = $stateParams.username;

				var user = {
					username: username
				};

				UserResource.search_username(user)
				.then(function(items) {
          $scope.users = items;
					toastr.success('');
				})
				.catch(function(error){
						toastr.error("Greska!");
				});

			}
		]);
})();
