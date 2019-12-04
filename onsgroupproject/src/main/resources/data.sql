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


