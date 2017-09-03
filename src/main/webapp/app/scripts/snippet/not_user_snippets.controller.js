(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('NotUserSnippetsController', ['$scope', '$state', '_', 'SnippetResource', '$log',
			function($scope, $state, _, SnippetResource, $log) {

				SnippetResource.getNotUserSnippets()
        .then(function(items) {
						$scope.snippets = items;
				});

			}
		]);
})();
