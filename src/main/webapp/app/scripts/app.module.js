(function() {
  'use strict';

  angular
    .module('bsepApp', [
      'ui.router',
      'ngRoute',
      'ngResource',
      'restangular',
      'ui.bootstrap',
      'lodash'
    ])
    .config(['$stateProvider', '$urlRouterProvider', '$locationProvider',
      function($stateProvider, $urlRouterProvider, $locationProvider) {
      $locationProvider.hashPrefix('');
      $urlRouterProvider.otherwise('/');
      $stateProvider
      .state('home', {
        url: "/",
        views: {
          'content@': {
            templateUrl: 'app/views/login.html'

          }
        }
      })
      .state('login', {
        url: "/login/:username/:password",
        views: {
          'content@': {
            templateUrl: 'app/home.html',
            controller: 'UserController'
          }
        }
      });
    }])
      // run se izvrsava pre svega ostalog
    .run(['Restangular', '$log', function(Restangular, $log) {
      Restangular.setBaseUrl("api");
      $log.info("started");
      Restangular.setErrorInterceptor(function(response) {
        if (response.status === 500) {
          $log.info("internal server error");
          return true;
        }
        return true;
      });
    }]);
})();
