(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('DeleteCommentController', ['$scope', '$rootScope', '$state', '_', 'CommentResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, CommentResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var snippetId = $stateParams.snippetId;
	      var commentId = $stateParams.snippetId;

        var comment = {
          id: commentId
        };

				CommentResource.deleteComment(comment)
				.then(function(items) {
          $scope.snippet = items.snippet;
					$scope.comments = items.comments;

          $window.location.href = '/#/snippet/' + snippetId;
					toastr.success('Obrisali ste komentar!');
				})
				.catch(function(error){
          $window.location.href = '/#/snippet/' + snippetId;
						toastr.error("Greska!");
				});

			}
		]);
})();
