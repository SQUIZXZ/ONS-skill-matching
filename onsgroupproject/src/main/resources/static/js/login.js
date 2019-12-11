$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

function saveNewUser(){
   var email = document.getElementById("register_email").value;
   var username = document.getElementById("register_username").value;
   var password = document.getElementById("register_password").value;
   var confirmPassword = document.getElementById("register_matching_password").value;
   var data = {email:email, username:username, password:password, confirmPassword:confirmPassword};
   $.ajax({
      type: "POST",
      url: "/registerUser",
      data:JSON.stringify(data),
      processData: false,
      contentType: "application/json",
      success: function (data) {
         window.location.href = "/login";
      },
      error: function (response) {
         var messages = response.responseText.toString().split(", ");
         $('.error').remove();
         for (i = 0; i < messages.length; i++) {
            switch (messages[i]) {
               case "email":
                  $('#register_email').after('<span class="error">' + 'Must be a valid email' + '</span>' + '<br class="error">');
                  break;
               case "username":
                  $('#register_username').after('<span class="error">' + 'Must be between 2 and 100 characters' + '</span>' + '<br class="error">');
                  break;
               case "password":
                  $('#register_password').after('<span class="error">' + 'Password must be at least 6 characters long' + '</span>' + '<br class="error">');
                  break;
               case "confirm_password":
                  $('#register_matching_password').after('<span class="error">' + 'Password must be at least 6 characters long' + '</span>' + '<br class="error">');
                  break;
            }
         }
      }
   });
}
