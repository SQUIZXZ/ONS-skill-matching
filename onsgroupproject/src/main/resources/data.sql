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

insert into skill_hierarchy (parent_id,child_id) values (1,2);
insert into skill_hierarchy (parent_id,child_id) values (1,3);
insert into skill_hierarchy (parent_id,child_id) values (1,4);

insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', 'python-help', 'operations', 'Python', 'Need help with python');


