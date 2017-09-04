(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('SearchSnippetsByLanguageController', ['$scope', '$rootScope', '$state', '_', 'SnippetResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, SnippetResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var languageName = $stateParams.selectedLanguage;
				$log.log(languageName);

				var language = {
					name: languageName
				};

				SnippetResource.search_language(language)
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
