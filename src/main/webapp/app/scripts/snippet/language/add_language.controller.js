(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('AddLanguageController', ['$scope', '$rootScope', '$state', '_', 'LanguageResource', '$stateParams', '$log', '$window','toastr',
			function($scope, $rootScope, $state, _, LanguageResource, $stateParams, $log, $window, toastr) {

        var name = $stateParams.name;

        var language = {
          name: name
        };

	  		LanguageResource.addLanguage(language).then(function(items) {
        	$scope.languages = items;

			});

		}
		]);
})();
