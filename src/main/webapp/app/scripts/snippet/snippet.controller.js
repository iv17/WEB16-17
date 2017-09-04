(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('SnippetController', ['$scope', '$state', '_', 'SnippetResource', '$stateParams', '$log',
			function($scope, $state, _, SnippetResource, $stateParams, $log) {

				var id = $stateParams.snippetId;

				SnippetResource.getSnippet(id)
        .then(function(item) {
						$scope.snippet = item;
				});

			}
		]);
})();
