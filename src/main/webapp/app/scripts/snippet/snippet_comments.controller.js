(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('SnippetCommentsController', ['$scope', '$state', '_', 'CommentResource', '$stateParams', '$log',
			function($scope, $state, _, CommentResource, $stateParams, $log) {

				var id = $stateParams.snippetId;

				CommentResource.getSnippetComments(id)
        .then(function(item) {
						$scope.snippet_comments = item;
				});

			}
		]);
})();
