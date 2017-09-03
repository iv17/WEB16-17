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
      'lodash',
      'ngStorage'
    ])
    .config(['$stateProvider', '$urlRouterProvider', '$locationProvider', 'RestangularProvider',

      function($stateProvider, $urlRouterProvider, $locationProvider, RestangularProvider) {
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
            templateUrl: 'app/home.html',
            controller: 'HomeController'
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
        url: "/register/:name/:lastname/:email/:username/:password/:repeated_password",
        views: {
          'content@': {
            controller: 'RegistrationController'
          }
        }
      })
      .state('forgot_password', {
        url: "/forgot_password",
        views: {
          'content@': {
            templateUrl: 'app/views/request_to_change_password.html'
          }
        }
      })
      .state('request_to_change_password', {
        url: "/request_to_change_password/:email",
        views: {
          'content@': {
            controller: 'RequestToChangePasswordController'
          }
        }
      })
      .state('proverite_mail', {
        url: "/proverite_mail",
        views: {
          'content@': {
            templateUrl: 'app/views/check_mail.html'
          }
        }
      })
      .state('start_change_password', {
        url: "/start_change_password/:email",
        views: {
          'content@': {
              templateUrl: 'app/views/change_password.html',
              controller: 'StartChangePasswordController'
          }
        }
      })
      .state('change_password', {
        url: "/change_password/:new_password/:new_password2",
        views: {
          'content@': {
            controller: 'ChangePasswordController'
          }
        }
      })
      .state('block_user', {
        url: "/block_user/:userId",
        views: {
          'content@': {

            controller: 'BlockUserController'
          }
        }
      });

    }])
      // run se izvrsava pre svega ostalog
    .run(['Restangular', '$log', '$localStorage',
    function(Restangular, $log, $localStorage) {
      Restangular.setBaseUrl("api");
    //  $log.log($window.localStorage.token);

      Restangular.addFullRequestInterceptor(
        function (element, operation, route, url, headers, params, httpConfig) {

            headers = {'X-Auth-Token':  $localStorage.token };

            return {
                element: element,
                params: params,
                headers: headers,
                httpConfig: httpConfig
            };

        });
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
