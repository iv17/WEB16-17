(function() {
	'use strict';

	angular
		.module('bsepApp')
		.controller('LocationController', ['$scope', '$rootScope', '$state', '_', 'UserResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage', 
			function($scope, $rootScope, $state, _, UserResource, $stateParams, $log, $window,
				toastr, $localStorage) {

				var latt = $rootScope.loggedUser.locationDTO.lat;
				$log.log(latt);
				var lngg = $rootScope.loggedUser.locationDTO.lng;
				$log.log(lngg);

				 $scope.map = { center: { latitude: latt, longitude: lngg }, zoom: 8 };
			}
		]);


})();
