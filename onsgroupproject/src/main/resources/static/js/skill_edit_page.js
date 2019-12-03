function submitSkillEdit(skillId) {
    var editName = document.getElementById("editSkillName").value;
    var editDesc = document.getElementById("editSkillDescription").value;
    var idToEdit = skillId;
    var data = {id:idToEdit,skillName:editName,skillDescription:editDesc};

    $.ajax({
        type:"POST",
        url:"/saveSkillEdit",
        data:JSON.stringify(data),
        processData:false,
        contentType:"application/JSON",
        success: function(data){
            console.log(data);
            window.location.href="/skill/" + skillId;
        },
        error:function(response){
          console.log(response.responseText.toString())
          var messages = response.responseText.toString().split(", ");
          $('.error').remove();
          for(i = 0; i < messages.length; i++){
              switch (messages[i]) {
                  case "skillEditEmpty":
                      $('#editSkillName').after('<span class=error>' + 'Skill must have a name' + '</span>');
                      break;

                  case "skillNameTaken":
                      $('#editSkillName').after('<span class=error>' + 'There is already a skill with that name' + '</span>');
                      break;

                  case "skillNameTooLong":
                      $('#editSkillName').after('<span class=error>' + 'Skill name too long, skill name must be 100 characters or less' + '</span>');
                      break;

                  case "skillDescriptionTooLong":
                      $('#editSkillDescription').after('<span class=error>' + 'Skill description too long, skill name must be 200 characters or less' + '</span>');
                      break;
              }
          }
        }
        })
}