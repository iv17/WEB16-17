(function(){

  angular.module("bsep").controller('LoginController', LoginController);

  LoginController.$inject = ['userService','$window', 'toastr']; //window sluzi za redirekciju

  function LoginController(userService, $window, toastr) {
    var loginCtrl = this;
    //this je ovaj kontroler
    loginCtrl.username = ""; //"" string da bude prazno na htmlu
    loginCtrl.password = "";

    loginCtrl.login = login;

    function login() {
      //ovo dole je login iz servisa
      userService.login(loginCtrl.username, loginCtrl.password)

      .then(function(){
        $window.location.href = '/#/home';
      })
      .catch(function(error){
          toastr.error("greska");
      });
    }
  }
})();
