(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('SnippetsController', ['$scope', '$state', '_', 'SnippetResource', '$stateParams', '$log',
			function($scope, $state, _, SnippetResource, $stateParams, $log) {

				SnippetResource.getSnippets()
        .then(function(items) {
						$scope.snippets = items;
				});

			}
		]);
})();
