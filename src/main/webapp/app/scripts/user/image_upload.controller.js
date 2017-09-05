(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('ImageUploadController', ['$scope', '$rootScope', '$state', '_', 'UserResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var f = $stateParams.file;
				$log.log(f);

				var file = {
					file: f
				};

				UserResource.image_upload(file)
				.then(function(item) {
          $rootScope.loggedUser = item;
					toastr.success('');
				})
				.catch(function(error){
						toastr.error("Greska!");
				});

			}
		]);
})();
