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
            templateUrl: 'app/views/user/login.html'
          }
        }
      })
      .state('start_register', {
        url: "/start_register",
        views: {
          'content@': {
            templateUrl: 'app/views/user/sign_in.html'
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
      .state('logout', {
          url: "/logout",
          views: {
            'content@': {
              controller: 'LogoutController'
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
            templateUrl: 'app/views/user/request_to_change_password.html'
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
            templateUrl: 'app/views/user/check_mail.html'
          }
        }
      })
      .state('start_change_password', {
        url: "/start_change_password/:email",
        views: {
          'content@': {
              templateUrl: 'app/views/user/change_password.html',
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
      .state('home', {
        url: "/home",
        views: {
          'navbar@': {
            templateUrl: 'app/views/navbar.html',
            controller: 'HomeController'
          },
          'sidebar@': {
            templateUrl: 'app/views/snippet/sidebar.html',
            controller: 'LanguagesController'
          },
          'content@': {
            templateUrl: 'app/views/snippet/snippets.html',
            controller: 'SnippetsController'   //PRVO SE PRIKAZU SNIPPET-I DRUGIH KORISNIKA
          }
        }
      })
      .state('user_snippets', {
        url: "/user_snippets",
        views: {
          'navbar@': {
            templateUrl: 'app/views/navbar.html',
            controller: 'HomeController'
          },
          'sidebar@': {
            templateUrl: 'app/views/snippet/sidebar.html',
            controller: 'LanguagesController'
          },
          'content@': {
            templateUrl: 'app/views/snippet/snippets.html',
            controller: 'UserSnippetsController'
          }
        }
      })
      .state('not_user_snippets', {
        url: "/not_user_snippets",
        views: {
          'navbar@': {
            templateUrl: 'app/views/navbar.html',
            controller: 'HomeController'
          },
          'sidebar@': {
            templateUrl: 'app/views/snippet/sidebar.html',
            controller: 'LanguagesController'
          },
          'content@': {
            templateUrl: 'app/views/snippet/snippets.html',
            controller: 'NotUserSnippetsController'
          }
        }
      })
      .state('start_create_snippet', {
        url: "/start_create_snippet",
        views: {
          'navbar@': {
            templateUrl: 'app/views/navbar.html',
            controller: 'HomeController'
          },
          'content@': {
            templateUrl: 'app/views/snippet/create_snippet.html',
            controller: 'StartCreateSnippetController'
          }
        }
      })
      .state('create_snippet', {
        url: "/create_snippet/:selectedLanguage/:selectedAccess/:selectedVisibility/:description/:code/:duration",
        views: {
          'navbar@': {
            templateUrl: 'app/views/navbar.html',
            controller: 'HomeController'
          },
          'sidebar@': {
            templateUrl: 'app/views/snippet/sidebar.html',
            controller: 'LanguagesController'
          },
          'content@': {
            templateUrl: 'app/views/snippet/snippets.html',
            controller: 'CreateSnippetController'  //new snippets
          }
        }
      })
      .state('snippet', {
        url: "/snippet/:snippetId",
        views: {
          'navbar@': {
            templateUrl: 'app/views/navbar.html',
            controller: 'HomeController'
          },
          'content@': {
            templateUrl: 'app/views/snippet/snippet.html',
            controller: 'SnippetController'
          }
        }
      })
      .state('create_comment', {
        url: "/create_comment/:commentText/:snippetId",
        views: {
          'navbar@': {
            templateUrl: 'app/views/navbar.html',
            controller: 'HomeController'
          },
          'content@': {
            templateUrl: 'app/views/snippet/snippet.html',
            controller: 'CreateCommentController'
          }
        }
      })
      .state('user_profile', {
        url: "/user_profile",
        views: {
          'content@': {
            templateUrl: 'app/views/user/user_profile.html'
            //controller: 'UserProfileController'
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
