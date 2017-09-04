(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('CreateSnippetController', ['$scope', '$rootScope', '$state', '_', 'SnippetResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage',
			function($scope, $rootScope, $state, _, SnippetResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var selectedLanguage = $stateParams.selectedLanguage;
				$log.log(selectedLanguage);
				if($stateParams.selectedLanguage == null) {
					for (var i = 0; i < $scope.languagesNames.length; i++) {
						if($scope.languagesNames[i] === "UNDEFINED") {
							$log.log($scope.languagesNames[i]);
							selectedLanguage = $scope.languagesNames[i];
						}
					}
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

				SnippetResource.create(snippet)
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
