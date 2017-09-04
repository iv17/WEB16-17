(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('UserSnippetsController', ['$scope', '$state', '_', 'SnippetResource', '$log',
			function($scope, $state, _, SnippetResource, $log) {

				SnippetResource.getUserSnippets()
        .then(function(items) {
						$scope.snippets = items;
				});

			}
		]);
})();
