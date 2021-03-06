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
        success: function (data) {
            console.log(data);
            window.location.href = "/skillRequest/"+data.split(",")[1]+"/"+data.split(",")[0];
        },
        error: function (response) {
            console.log(response.responseText.toString());
            var messages = response.responseText.toString().split(", ");
            $('.error').remove();
            for(i = 0; i < messages.length; i++){
                switch(messages[i]){
                    case "firstName":
                        $('#firstName').after('<span class="error">' + 'Name cannot be empty and must be between 2 and 200 characters' + '</span>'+'<br class="error">');
                        break;
                    case "surname":
                        $('#surname').after('<span class="error">' + 'Surname cannot be empty and must be between 2 and 200 characters' + '</span>'+'<br class="error">');
                        break;
                    case "department":
                        $('#department').after('<span class="error">' + 'Department cannot be empty and must be between 1 and 200 characters' + '</span>'+'<br class="error">');
                        break;
                    case "skill":
                        $('#skill').after('<span class="error">' + 'Skill cannot be empty and must be between 2 and 200 characters' + '</span>'+'<br class="error">');
                        break;
                    case "skillExists":
                        $('#skill').after('<span class="error">' + 'Skill has to exist' + '</span>'+'<br class="error">');
                        break;
                    case "taskDescription":
                        $('#description').after('<span class="error">' + 'Description cannot be empty and must be between 2 and 300 characters' + '</span>'+'<br class="error">');
                        break;
                    case "furlEmpty":
                        $('#furl').after('<span class="error">' + 'Furl cannot be empty' + '</span>'+'<br class="error">');
                        break;
                    case "furlToLong":
                        $('#furl').after('<span class="error">' + 'Furl is too Long' + '</span>'+'<br class="error">');
                        break;
                    case "furlBadChar":
                        $('#furl').after('<span class="error">' + 'Furl cannot contain special characters' + '</span>'+'<brclass="error">');
                        break;
                    case "furlExists":
                        $('#furl').after('<span class="error">' + 'Furl already in use' + '</span>'+'<brclass="error">'+'<brclass="error">');
                        break;

                }
            }

        }
    });

}
function saveNewSkill(){
    var skill = document.getElementById("skill").value;
    var parent = document.getElementById("parent").value;
    var description = document.getElementById("skillDescription").value;
    var data = {skill:skill, parent:parent, description:description};
    console.log(data);
    $.ajax({
        type: "POST",
        url: "/saveNewSkill",
        data:JSON.stringify(data),
        processData: false,
        contentType: "application/json",
        success: function (data) {
            $('#skill').after('<span class="span" style="font-size: 16px">' + 'Skill added refresh to use' + '</span>' + '<br>');
        },
        error: function (e) {
            $('.error').remove();
            var messages = e.responseText.toString().split(", ");
            for(i = 0; i < messages.length; i++) {
                switch (messages[i]) {
                    case "skillEmpty":
                        $('#skill').after('<span class="error">' + 'Skill cannot be empty' + '</span>' + '<br class="error">');
                        break;
                    case "skillSize":
                        $('#skill').after('<span class="error">' + 'Skill must be between 2 and 200 characters' + '</span>' + '<br class="error">');
                        break;
                    case "skillChildExist":
                        $('#skill').after('<span class="error">' + 'Skill must be unique' + '</span>' + '<br class="error">');
                        break;
                    case "skillParentExist":
                        $('#parent').after('<span class="error">' + 'Parent skill must already exist' + '</span>' + '<br class="error">');
                        break;
                    case "descriptionSize":
                        $('#skillDescription').after('<span class="error">' + 'Skill description is too long, it should be less than 200 characters' + '</span>' + '<br class="error">');
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

// function saveNewSkill(){
//     var skill = document.getElementById("skill").value;
//     var parent = document.getElementById("parent").value;
//
//     $.ajax({
//         type: "POST",
//         url: "/saveNewSkill",
//         data:JSON.stringify({
//             skill: skill,
//             description:description,
//             parent:parent
//         }),
//         processData: false,
//         contentType: "application/json",
//         success: function (data) {
//             console.log(data);
//             window.location.href = "/createSkillRequest";
//         },
//         error: function (e) {
//             console.log(e);
//         }
//     });
// }
