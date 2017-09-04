(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('SearchSnippetsByDateController', ['$scope', '$rootScope', '$state', '_', 'SnippetResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, SnippetResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var date = $stateParams.date;
				$log.log(date);

				var snippet = {
					dateString: date
				};

				SnippetResource.search_date(snippet)
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
