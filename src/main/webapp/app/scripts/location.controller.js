(function () {
    'use strict';

    angular
        .module('bsepApp')
        .controller('LocationController', LocationController);

    LocationController.$inject = ['$scope', '$rootScope', '$state', '_', 'UserResource',
		 '$stateParams', '$log', '$window','toastr',  '$localStorage', '$timeout', '$document'];

    function LocationController($scope, $rootScope, $state, _, UserResource,
		 $stateParams, $log, $window,toastr,  $localStorage, $timeout, $document) {

				var lat = $rootScope.loggedUser.locationDTO.lat;
				var lng = $rootScope.loggedUser.locationDTO.lng;

            var position = {
                lat: lat,
                lng: lng
            };
            $scope.position = position;
						$log.log(position);

            var mapProp= {
        				center:new google.maps.LatLng($scope.position.lat, $scope.position.long),
        				zoom:5,
        		};
        		var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
            $log.log(map);
            $scope.map = map;

            function myMap() {
              var mapProp= {
                  center:new google.maps.LatLng($scope.position.lat, $scope.position.long),
                  zoom:5,
              };
              var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
              

            }

    }
})();
