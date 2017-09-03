(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('CreateSnippetController', ['$scope', '$rootScope', '$state', '_', 'SnippetResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, SnippetResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var selectedLanguage = $stateParams.selectedLanguage;
				$log.log('selectedLanguage: ' + selectedLanguage);
				var selectedAccess = $stateParams.selectedAccess;
				$log.log('selectedAccess: ' + selectedAccess);
				var selectedVisibility = $stateParams.selectedVisibility;
				$log.log('selectedVisibility: ' + selectedVisibility);
				var description = $stateParams.description;
				$log.log(description);
				var data = $stateParams.code;
				$log.log(data);
				var duration = $stateParams.duration;
				$log.log(duration);

				var snippet = {
					description: description,
					data: data,
					duration: duration,
					languageName: selectedLanguage,
					accessName: selectedAccess,
					visibilityName: selectedVisibility
				};

				SnippetResource.create(snippet)
				.then(function(items) {
					$scope.snippets = items;

					toastr.success('Dodali ste novi snippet!');
				})
				.catch(function(error){
						toastr.error("Greska!");
				});

			}
		]);
})();
