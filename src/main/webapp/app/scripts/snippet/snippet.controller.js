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

				SnippetResource.getSnippetComments(id)
				.then(function(items) {
						$scope.comments = items;

				});


			}
		])
		<!-- //justinklemm.com/angularjs-filter-ordering-objects-ngrepeat/-->
		.filter('orderObjectBy', function() {
  	return function(items, field, reverse) {
    var filtered = [];
    angular.forEach(items, function(item) {
      filtered.push(item);
    });
    filtered.sort(function (a, b) {
      return (a[field] < b[field] ? 1 : -1);
    });
    if(reverse) filtered.reverse();
    return filtered;
  };
});

})();
