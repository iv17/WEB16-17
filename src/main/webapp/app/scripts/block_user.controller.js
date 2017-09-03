(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('BlockUserController', ['$scope', '$rootScope', '$state', '_', 'UserResource', '$stateParams', '$log', '$window','toastr',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window, toastr) {

				var userId = $stateParams.userId;

				var user = {
					id: userId
				};

				UserResource.block_user(user)
				.then(function(item) {
					//vraca sve user-e
					$log.log(item);
					$scope.users = item;

					$window.location.href = '/#/home';
					toastr.success('Uspesno ste blokirali korisnika!');
				})
				.catch(function(error){
						//$window.location.href = '/#/home';
						toastr.error("Greska!");
				});
				/*UserResource.block_user(loggedAdminId, user)
				.then(function(item) {
          //vraca sve user-e
					$scope.users = item;

					$window.location.href = '/#/home';
					toastr.success('Uspesno ste blokirali korisnika!');
				})
				.catch(function(error){
						//$window.location.href = '/#/home';
						toastr.error("Greska!");
				});*/

			}
		]);
})();
