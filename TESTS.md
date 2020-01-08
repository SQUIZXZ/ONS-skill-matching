# GROUP-5-PROJECT-ONS-SKILLS-TESTING

<h1>Tests for my script walkthroughs</h1>
<br>
<h2>Script walkthrough 1</h2>
<p>To succesfully test this feature it should do the following<p>
<p>User should be able to Change and existing skill in the database, the following should be able to change</p>

* The Skills name
* The Skills description
* The Parent skills of the skill
* Validation should prevent you
  - Changing a skill's name to one already used by another skill
  - Adding the same parent skill twice
  - Adding a parent skill that the skill in question is a parent of
  - that a skill cannot be its own parent
  - That all parent skills must exist within the database

To test this we will do the following<br>
Before you start testing make sure the apllication.proporties file has "spring.profiles.active = development" in the version you are running this is the default if you compile without making any changes

1. Start the program and go to localhost:8080 in a supported browser, I reccomend google chrome for this
2. You will need to log in due to spring security
  *The default username is "fin"
  *The default password is "password"
3. After logging in navigate to "http://localhost:8080/skill/editSkill/1"
4. To test the validation attempt the following:
  1. Attempt to change the the input field under Skill Name to "Go" (as it already exists withing the database)
  2. Press save skill and red text should inform you there is already a skill with that name
  3. return the skills name to "Language"
  4. Press the "Add a new parent" button twice and change the two textboxes that appear to read "c"
  5. Press save skill and red text should inform you thay you cannot be the parent of a skill twice
  6. Press the lower "delete parent" button
  7. change the text in the remaining parent skill form section to read "java" (the name of a child skill of language by default)
  8. Press save skill and red text should inform you that a skill cannot be both a parent and a child of another skill
  9. Change the text in the parent skill form section to read "language"
  10. Press save skill and red text should inform you that a skill cannot be its own parent
  11. change the text in the parent skill form section to read "Banana" (not the name of a skill in the database by default)
  12. Press save skill and red text should inform you that one of your parent skills does not exist
5. Change the input field under Skill Name to read "Programming Languages"
6. Change the input field under description to read "Programming Languages Description"
7. Change the field under parent skills to read "c"
8. Press the save skills button
9. You should be taken to "http://localhost:8080/skill/1"
10. On that page there should be text saying "Programming Languages", "Programming Languages Description" and "c"
11. This should show that the skill editing page is working

<h2>Script walkthrough 2</h2>
<p>This feature is tested by my automated testing under web/SkillRequestPageTests</p>