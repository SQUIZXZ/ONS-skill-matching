function deleteSkill(button) {
    button.closest("div").remove();
}

function AddUserSkill() {
    $("#AllUserSkills").append('<div id="userSkill"> <label>Skill Name:  </label><input type="text" list="listOfSkills" class="skillSelector"> <label>Skill level:  </label><input type="text" class = "skillLevels"/> <label>Skill Privacy:  </label><input type="checkbox" class = "userSkillPrivacy" /> <button onclick="deleteSkill(this)" type="button" class="btn btn-outline-success my-2 my-sm-0">' + ' Delete Skill' + '</button> </div>')
}

function saveCurrentSkills() {
    var skillNames = new Array();
    var skillNameInputs = $(".skillSelector");
    var skillLevels = new Array();
    var skillLevelInputs = $(".skillLevels");
    var skillPrivacy = new Array();
    var skillPrivacyList = $(".userSkillPrivacy");

    for (s = 0; s < skillNameInputs.length; s++) {
        skillNames[s] = skillNameInputs[s].value;
        console.log(skillNames)
    }

    for (x = 0; x < skillLevelInputs.length; x++) {
        skillLevels[x] = skillLevelInputs[x].value;
        console.log(skillLevels)
    }

    for (y = 0; y < skillPrivacyList.length; y++) {
        skillPrivacy[y] = skillPrivacyList[y].value;
        console.log(skillPrivacy)
    }

    var data = {skillNames: skillNames, skillLevels: skillLevels, skillPrivacy: skillPrivacy};
    console.log(data);
    $.ajax({
        type: "POST",
        url: "/saveUserSkills",
        data: JSON.stringify(data),
        processData: false,
        contentType: "application/JSON",
        success: function (data) {
            window.location.href = "/user";
        }

    })
}