(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('SearchSnippetsByDescriptionController', ['$scope', '$rootScope', '$state', '_', 'SnippetResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, SnippetResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var description = $stateParams.description;

				var snippet = {
					description: description
				};

				SnippetResource.search_description(snippet)
				.then(function(items) {
          $scope.snippets = items;
					toastr.success('');
				})
				.catch(function(error){
						toastr.error("Greska!");
				});

			}
		]);
})();
