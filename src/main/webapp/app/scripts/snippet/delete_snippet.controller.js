(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('DeleteSnippetController', ['$scope', '$rootScope', '$state', '_', 'SnippetResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, SnippetResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var id = $stateParams.snippetId;

        var snippet = {
          id: id
        };

				SnippetResource.deleteSnippet(snippet)
				.then(function(items) {
					$scope.snippets = items;
          $window.location.href = '/#/home';
					toastr.success('Obrisali ste snippet!');
				})
				.catch(function(error){
          $window.location.href = '/#/home';
						toastr.error("Greska!");
				});

			}
		]);
})();
