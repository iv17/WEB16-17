(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('LanguagesController', ['$scope', '$rootScope', '$state', '_', 'LanguageResource', '$stateParams', '$log', '$window','toastr',
			function($scope, $rootScope, $state, _, LanguageResource, $stateParams, $log, $window, toastr) {


				$scope.setActive = function(menuItem) {
					$scope.activeMenu = menuItem;
				}

	  		LanguageResource.getLanguages().then(function(items) {
        	$scope.languages = items;
					var languages = items;
					var languagesNames = [];
					for(var i=0; i< languages.length; i++) {
							languagesNames.push(languages[i].name);
					}
					$scope.languagesNames = languagesNames;

        });

			}
		]);
})();
