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
        data: JSON.stringify({firstName: firstName, surname: surname,department: department,skill: skill,description: description,furl: furl}),
        processData: false,
        contentType: "application/json",
        success: function (furl) {
            console.log(furl);
            window.location.href = "/skillRequest/"+furl;
        },
        error: function (e) {
            console.log(e);
            console.log("fail");

        }
    });
}
