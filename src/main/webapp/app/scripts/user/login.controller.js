(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('LoginController', ['$scope', '$rootScope', '$state', '_', 'UserResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var username = $stateParams.username;
				var password = $stateParams.password;

				var user = {
					email: username,
					username: username,
					password: password
				};

				//var user = $stateParams.user; //{"username":"iv17","password":"nikola99","email":"iv17"}
				//$log.log(user);
				//var u;
				//for (u in user) {
					//$log.log(user[u]);
				//}
				//var json = JSON.parse(user);
				//$log.log(json);
				//var json2 = angular.fromJson(user);
				//$log.log(json2);

				UserResource.login(user)
				.then(function(item) {
					$rootScope.loggedUser = item.user;
					//==========================================
					$localStorage.token = item.token;
					//==========================================

					$log.log($rootScope.loggedUser.roleDTO.name);

					$window.location.href = '/#/home';
					toastr.success('Ulogovali ste se kao: ' + item.user.username);
				})
				.catch(function(error){
						$window.location.href = '/#/start_login';
						toastr.error("Greska!");
				});

			}
		]);
})();
