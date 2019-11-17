function saveSkillRequest() {
    var firstName = document.getElementById("firstName").value;
    var surname = document.getElementById("surname").value;
    var department = document.getElementById("department").value;
    var skill = document.getElementById("skill").value;
    var description = document.getElementById("description").value;
    var furl = document.getElementById("furl").value;
    $.ajax({
        type: "POST",
        url: "/saveSkillRequest",
        data: {
            firstName: firstName,
            surname: surname,
            department: department,
            skill: skill,
            description: description,
            furl: furl,
        },
        success: function (furl) {
            window.location.href = "/skillRequest/"+furl;
        },
        error: function (e) {
            console.log(e);
        }
    });


}
