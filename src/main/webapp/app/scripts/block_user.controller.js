(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('BlockUserController', ['$scope', '$rootScope', '$state', '_', 'UserResource', '$stateParams', '$log', '$window','toastr',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window, toastr) {

				var loggedAdminId = $rootScope.loggedUser.id;
				var userId = $stateParams.userId;

				var user = {
					id: userId
				};

				$log.log(loggedAdminId);
				$log.log(user);

				UserResource.block_user(loggedAdminId, user)
				.then(function(item) {
          //vraca sve user-e
					$scope.users = item;

					$log.log($scope.users);
					$window.location.href = '/#/home';
					toastr.success('Uspesno ste blokirali korisnika!');
				})
				.catch(function(error){
						//$window.location.href = '/#/home';
						toastr.error("Greska!\nPokusajte ponovo!");
				});

			}
		]);
})();
