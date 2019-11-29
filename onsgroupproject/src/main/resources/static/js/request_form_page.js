function saveSkillRequest() {
    var firstName = document.getElementById("firstName").value;
    var surname = document.getElementById("surname").value;
    var department = document.getElementById("department").value;
    var skill = document.getElementById("skill").value;
    var description = document.getElementById("description").value;
    var furl = document.getElementById("furl").value;
    var data = {firstName: firstName, surname: surname, department: department, skill: skill, taskDescription: description, furl: furl};

    $.ajax({
        type: "POST",
        url: "/saveSkillRequest",
        data: JSON.stringify(data),
        processData: false,
        contentType: "application/json",
        success: function (furl) {
            console.log(furl);
            window.location.href = "/skillRequest/"+furl;
        },
        error: function (response) {
            console.log(response.responseText.toString());
            var messages = response.responseText.toString().split(", ");
            $('input').next('span').remove();
            for(i = 0; i < messages.length; i++){
                switch(messages[i]){
                    case "firstName":
                        $('#firstName').after('<span class="error">' + 'Name Error' + '</span>');
                        break;
                    case "surname":
                        $('#surname').after('<span class="error">' + 'Surname Error' + '</span>');
                        break;
                    case "department":
                        $('#department').after('<span class="error">' + 'Department Error' + '</span>');
                        break;
                    case "skill":
                        $('#skill').after('<span class="error">' + 'Skill Error' + '</span>');
                        break;
                    case "taskDescription":
                        $('#description').after('<span class="error">' + 'Description Error' + '</span>');
                        break;
                    case "furlToLong":
                        $('#furl').after('<span class="error">' + 'Furl is too Long' + '</span>');
                        break;
                    case "furlBadChar":
                        $('#furl').after('<span class="error">' + 'Furl cannot contain special characters' + '</span>');
                        break;

                }
            }

        }
    });

}
function hideOrShow(){
    var skills = document.getElementById("skillList").value;
    var skillList = skills.substring(1, skills.length - 1).split(", ");
    var skill = document.getElementById("skill").value;
    var createSkill = document.getElementsByClassName("createSkill");
    var isSkill = false;
    for (s = 0; s < skillList.length; s++) {
        if (skillList[s] === skill){
            isSkill = true;
            break;
        }
    }
    if(isSkill === true){
        Array.prototype.forEach.call(createSkill, function(s) {
            s.style.display = "none";
        });
    }else{
        Array.prototype.forEach.call(createSkill, function(s) {
            s.style.display = "block";
        });
    }

}
function saveNewSkill(){
    var skill = document.getElementById("skill").value;
    var parent = document.getElementById("parent").value;
    $.ajax({
        type: "POST",
        url: "/saveNewSkill",
        data:JSON.stringify({
            skill: skill,
            parent:parent
        }),
        processData: false,
        contentType: "application/json",
        success: function (data) {
            console.log(data);
            window.location.href = "/createSkillRequest";
        },
        error: function (e) {
            console.log(e);
        }
    });
}
