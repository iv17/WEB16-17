(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('CreateCommentController', ['$scope', '$rootScope', '$state', '_', 'CommentResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, CommentResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var snippetId = $stateParams.snippetId;
				var commentText = $stateParams.commentText;

				$log.log(snippetId);
				$log.log(commentText);
				var createCommentRequest = {   // I NA SPRINGU OVAKAV OBJEKAT ZA PREUZIMANJE PARAMETARA
          snippetId: snippetId,
					text: commentText
				};

				CommentResource.create(createCommentRequest)
				.then(function(items) {
          $scope.snippet = items.snippet;
					$log.log($scope.snippet);
					$scope.comments = items.comments;
					$log.log($scope.comments);
					toastr.success('Dodali ste novi komentar!');
				})
				.catch(function(error){
						toastr.error("Greska!");
				});

			}
		]);
})();
