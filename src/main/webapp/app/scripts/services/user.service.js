(function(){

  angular.module("bsep").factory('userService', function($http) {

    return {
      //ovo je da controller moze da vidi login funkciju
      login: login,
      register: register
    };

    function login(username, password) {
      return $http({
        method: "POST",
        url: "http://localhost:8080/api/users/login",
        params: {
          //sa leve strane username iz springa sa desne iz htmla
          "username": username,
          "password": password
        }
      });

    }

    function register(user) {
      return $http({
        method: "POST",
        url: "http://localhost:8080/api/users/registration",
        data: user
      });

    }
  });

})();
