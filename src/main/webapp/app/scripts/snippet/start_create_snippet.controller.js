(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('StartCreateSnippetController', ['$scope', '$state', '_', 'LanguageResource', 'AccessResource',
      'VisibilityResource', '$log',
			function($scope, $state, _, LanguageResource, AccessResource, VisibilityResource, $log) {


				LanguageResource.getLanguages()
        .then(function(items) {
						var languages = items;
						//$scope.languages = items;
						var languagesNames = [];
						for(var i=0; i< languages.length; i++) {
        				languagesNames.push(languages[i].name);

    					}
						$scope.languagesNames = languagesNames;

				});
        AccessResource.getAccesses()
        .then(function(items) {
						$scope.accesses = items;
				});
        VisibilityResource.getVisibilities()
        .then(function(items) {
						$scope.visibilities = items;
				});
				$scope.getIndexFromValue = function(value) {
				    for(var i=0; i<$scope.languagesNames.length; i++) {
        				if($scope.languagesNames[i] === value)
             				return i;
    					}
				};

			}
		]);
})();
