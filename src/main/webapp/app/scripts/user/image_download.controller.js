(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('ImageDownloadController', ['$scope', '$rootScope', '$state', '_', 'UserResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var name = $stateParams.file;

				$log.log(name);

				UserResource.image_download(name)
				.then(function(item) {
          $log.log(item);
					toastr.success('');
				})
				.catch(function(error){
						toastr.error("Greska!");
				});

			}
		]);
})();
