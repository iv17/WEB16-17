(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('LoadAdminsController', ['$scope', '$state', '_', 'UserResource', '$log',
			function($scope, $state, _, RealEstateResource, $log) {

				UserResource.getAdmins().then(function(items) {
						$scope.admins = items;
				});

			}
		]);
})();
