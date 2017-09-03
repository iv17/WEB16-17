(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('CreateSnippetSidebarController', ['$scope', '$state', '_', 'LanguageResource', 'AccessResource',
      'VisibilityResource', '$log',
			function($scope, $state, _, LanguageResource, AccessResource, VisibilityResource, $log) {

				LanguageResource.getLanguages()
        .then(function(items) {
						$scope.languages = items;
				});
        AccessResource.getAccesses()
        .then(function(items) {
						$scope.accesses = items;
				});
        VisibilityResource.getVisibilities()
        .then(function(items) {
						$scope.visibilities = items;
				});

			}
		]);
})();
