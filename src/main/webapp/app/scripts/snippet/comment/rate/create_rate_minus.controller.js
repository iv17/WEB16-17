(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('CreateRateMinusController', ['$scope', '$rootScope', '$state', '_', 'RateResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, RateResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var commentId = $stateParams.commentId;
				var snippetId = $stateParams.snippetId;

				var comment = {
          id: commentId
				};

				RateResource.createRateMinus(comment)
				.then(function(items) {
					$scope.snippet = items.snippet;
					$scope.comments = items.comments;

					$window.location.href = '/#/snippet/' + snippetId;
					toastr.success('Dodali ste novu ocenu!');
				})
				.catch(function(error){
					$window.location.href = '/#/snippet/' + snippetId;
					toastr.error("Greska!");
				});

			}
		]);
})();
