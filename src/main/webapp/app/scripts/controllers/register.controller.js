(function(){

  angular.module("bsep").controller('RegisterController', RegisterController);

  RegisterController.$inject = ['userService','$window', 'toastr']; //window sluzi za redirekciju

  function RegisterController(userService, $window, toastr) {
    var regCtrl = this;
    //this je ovaj kontroler
    regCtrl.user = {};
    regCtrl.user.username = ""; //"" string da bude prazno na htmlu
    regCtrl.user.password = "";
    regCtrl.user.email = "";
    regCtrl.user.phone = "";

    regCtrl.register = register;

    function register() {
      //ovo dole je login iz servisa
      userService.register(regCtrl.user)

      .then(function(){
        $window.location.href = '/#/home';
      })
      .catch(function(error){
          toastr.error("greska");
      });
    }
  }
})();
