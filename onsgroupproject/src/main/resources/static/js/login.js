$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

function saveNewUser(){
   console.log("rllo");
   var email = document.getElementById("register_email").value;
   var username = document.getElementById("register_username").value;
   var password = document.getElementById("register_password").value;
   var confirmPassword = document.getElementById("register_matching_password").value;
   var data = {email:email, username:username, password:password, confirmPassword:confirmPassword};
   console.log(data);
   $.ajax({
      type: "POST",
      url: "/registerUser",
      data:JSON.stringify(data),
      processData: false,
      contentType: "application/json",
      success: function (data) {
         console.log(data);

      }
   });
}
