(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('BlockSnippetController', ['$scope', '$rootScope', '$state', '_', 'SnippetResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, SnippetResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var id = $stateParams.snippetId;

        var snippet = {
          id: id
        };

				SnippetResource.blockSnippet(snippet)
				.then(function(items) {
					$scope.snippets = items;
          $window.location.href = '/#/home';
					toastr.success('Blokirali ste snippet!');
				})
				.catch(function(error){
          $window.location.href = '/#/home';
						toastr.error("Greska!");
				});

			}
		]);
})();
