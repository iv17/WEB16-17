(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('CreateSnippetNotRegController', ['$scope', '$rootScope', '$state', '_', 'SnippetResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, SnippetResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var selectedLanguage = $stateParams.selectedLanguage;
				if($stateParams.selectedLanguage.value == null) {
					selectedLanguage = "UNDEFINED";
				}
				var selectedAccess = $stateParams.selectedAccess;
				var selectedVisibility = $stateParams.selectedVisibility;
				var description = $stateParams.description;
				var data = $stateParams.code;
				var duration = $stateParams.duration;

				var snippet = {
					description: description,
					data: data,
					duration: duration,
					languageName: selectedLanguage,
					accessName: selectedAccess,
					visibilityName: selectedVisibility
				};

				SnippetResource.create_not_reg(snippet)
				.then(function(items) {
					$scope.snippets = items;
					$window.location.href = '/#/home';
					toastr.success('Dodali ste novi snippet!');
				})
				.catch(function(error){
						$window.location.href = '/#/home';
						toastr.error("Greska!");
				});

			}
		]);
})();
