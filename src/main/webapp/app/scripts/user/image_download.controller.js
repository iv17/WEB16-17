(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('ImageDownloadController', ['$scope', '$rootScope', '$state', '_', 'UserResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var file = $stateParams.file;

				$log.log(file);

				UserResource.image_download(file)
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
