(function(){
  var app = angular.module("bsep");

  app.config(['$routeProvider', '$locationProvider',function ($routeProvider, $locationProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'app/views/login.html',
        controller: 'LoginController',
        controllerAs: 'loginCtrl'
      })
      .when('/register', {
        templateUrl: 'app/views/register.html',
        controller: 'RegisterController',
        controllerAs: 'regCtrl'
      })
      .when('/home', {
        templateUrl: 'app/views/home.html'
      })
      .otherwise({
        redirectTo: '/'
      });
      $locationProvider.hashPrefix('');
  }] );
})();
