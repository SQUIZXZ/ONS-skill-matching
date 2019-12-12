function submitSkillEdit(skillId) {
    var editName = document.getElementById("editSkillName").value;
    var editDesc = document.getElementById("editSkillDescription").value;
    var idToEdit = skillId;
    var parentSkills = $(".parentSkillSelector");
    var parentSkillValues = new Array();
    for(s = 0; s < parentSkills.length; s++){
        parentSkillValues[s] = parentSkills[s].value;
    }
    var data = {id:idToEdit,skillName:editName,skillDescription:editDesc,parentSkills:parentSkillValues};

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
                  case "parentSkillDoesNotExist":
                      $('#allParentSkills').after('<span class=error>' + 'One of your parent skills does not exist' + '</span>');
                      break;
                  case "skillCannotBeOwnParent":
                      $('#allParentSkills').after('<span class=error>' + 'A skill cannot be its own parent' + '</span>');
                      break;
                  case "skillCannotBeParentTwice":
                      $('#allParentSkills').after('<span class=error>' + 'A skill cannot be a parent of another skill more than once' + '</span>');
                      break;
                  case "skillCannotBeParentAndChild":
                      $('#allParentSkills').after('<span class=error>' + 'A skill cannot both the parent and the child of a skill' + '</span>');
                      break;

              }
          }
        }
        })
}

function AddParent() {
    $("#allParentSkills").append('<div id="parentSkills"><input type="text" list="listOfSkills" class="parentSkillSelector search__input"> <button onclick="deleteParent(this)" type="button" class="btn btn btn--secondary">' + 'Delete Parent' + '</button> </div>')

}

function deleteParent(button) {
    button.closest( "div" ).remove();
}