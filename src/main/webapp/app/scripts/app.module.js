(function() {
  'use strict';

  angular
    .module('bsepApp', [
      'toastr',
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
      .state('start_login', {
        url: "/",
        views: {
          'content@': {
            templateUrl: 'app/views/login.html'
          }
        }
      })
      .state('start_register', {
        url: "/start_register",
        views: {
          'content@': {
            templateUrl: 'app/views/sign_in.html'
          }
        }
      })
      .state('home', {
        url: "/home",
        views: {
          'content@': {
            templateUrl: 'app/home.html'
          }
        }
      })
      .state('login', {
        url: "/login/:username/:password",
        views: {
          'content@': {
            controller: 'LoginController'
          }
        }
      })
      .state('register', {
        url: "/register/:name/:lastname/:email/:username/:password/:password_confirmation",
        views: {
          'content@': {
            controller: 'RegistrationController'
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
