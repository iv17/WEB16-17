(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('SnippetsController', ['$scope', '$state', '_', 'SnippetResource', '$log',
			function($scope, $state, _, SnippetResource, $log) {

				SnippetResource.getSnippets()
        .then(function(items) {
						$scope.snippets = items;
				});

			}
		]);
})();
