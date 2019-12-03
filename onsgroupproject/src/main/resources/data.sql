insert into skill (id,skill_name) values (1,'language');
insert into skill (id,skill_name) values (2,'java');
insert into skill (id,skill_name) values (3,'python');
insert into skill (id,skill_name) values (4,'css');
insert into skill (skill_name) values ('html');
insert into skill (skill_name) values ('c++');
insert into skill (skill_name) values ('javascript');
insert into skill (skill_name) values ('boot strap');
insert into skill (skill_name) values ('c');
insert into skill (skill_name) values ('c+');
insert into skill (skill_name) values ('JavaFX Script');
insert into skill (skill_name) values ('Go');
insert into skill (skill_name) values ('Icon');
insert into user_skill (user_id, skill_id, level ,privacy) values (1,1,12,true);
insert into user_skill (user_id, skill_id, level ,privacy) values (1,2,12,false);
insert into user_skill (user_id, skill_id, level ,privacy) values (1,3,12,true) ;
insert into user_skill (user_id, skill_id, level ,privacy) values (1,4,12,true);
insert into user_skill (user_id, skill_id, level ,privacy) values (1,5,12,false);
insert into users (first_name , surname ,email, skill_id)values ('Ghada', 'abu ', 'ghada@gmail.com', 2);
insert into users (first_name , surname ,email, skill_id)values ('luke', 'm ', 'luke@gmail.com', 2);
insert into skill_hierarchy (parent_id,child_id) values (1,2);
insert into skill_hierarchy (parent_id,child_id) values (1,3);
insert into skill_hierarchy (parent_id,child_id) values (1,4);

insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', 'python-help', 'operations', 'Python', 'Need help with python');


