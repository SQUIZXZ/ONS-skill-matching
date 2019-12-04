insert into skill (id,skill_name,skill_desc) values (1,'language','Look at my description!');
insert into skill (id,skill_name,skill_desc) values (2,'java','Look at my description!');
insert into skill (id,skill_name,skill_desc) values (3,'python','Look at my description!');
insert into skill (id,skill_name,skill_desc) values (4,'css','Look at my description!');
insert into skill (skill_name,skill_desc) values ('html','Look at my description!');
insert into skill (skill_name,skill_desc) values ('c++','Look at my description!');
insert into skill (skill_name,skill_desc) values ('javascript','Look at my description!');
insert into skill (skill_name,skill_desc) values ('boot strap','Look at my description!');
insert into skill (skill_name,skill_desc) values ('c','Look at my description!');
insert into skill (skill_name,skill_desc) values ('c+','Look at my description!');
insert into skill (skill_name,skill_desc) values ('JavaFX Script','Look at my description!');
insert into skill (skill_name,skill_desc) values ('Go','Look at my description!');
insert into skill (skill_name) values ('Icon');

insert into skill_hierarchy (parent_id,child_id) values (1,2);
insert into skill_hierarchy (parent_id,child_id) values (1,3);
insert into skill_hierarchy (parent_id,child_id) values (1,4);

insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', 'python-help', 'operations', 'Python', 'Need help with python');

INSERT INTO user(username,password)
VALUES ('Fin','{bcrypt}$2a$10$B188I9BfwGLsWGU9eF4wPOV6O6z.MgEbNxcErNEKb8xwM.4ChBT7G');

INSERT INTO user_role(userid, role)
VALUES (001, 'ROLE_USER');

