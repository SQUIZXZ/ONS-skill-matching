DROP SCHEMA IF EXISTS ons_database;

CREATE SCHEMA IF NOT EXISTS ons_database;

USE ons_database;

CREATE TABLE IF NOT EXISTS `skill`
(
    `id`           INT NOT NULL AUTO_INCREMENT,
    `skill_name`   VARCHAR(100)  NOT NULL,
    `skill_desc`    VARCHAR(200),

    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `skill_hierarchy`
(
    `parent_id`  INT NOT NULL,
    `child_id`   INT NOT NULL,
    FOREIGN KEY (`parent_id`) REFERENCES `skill`(`id`),
    FOREIGN KEY (`child_id`) REFERENCES `skill`(`id`)

)
    ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `skill_requests`
(
    `id`           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `first_name`   VARCHAR(100)  NOT NULL,
    `last_name`    VARCHAR(100) NOT NULL,
    `furl`         VARCHAR(50) NOT NULL,
    `department`   VARCHAR(100) NOT NULL,
    `skill`        VARCHAR(100) NULL,
    `info`         VARCHAR(300)  NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;

CREATE TABLE if not exists `user`
(
    `id`        INT(11)      NOT NULL AUTO_INCREMENT,
    `username`  VARCHAR(45)  NOT NULL,
    `password`  VARCHAR(100) NOT NULL,
    `first_name`VARCHAR(100),
    `surname`   VARCHAR(100),
    `email`     VARCHAR(100),
    PRIMARY KEY (`id`)
--     FOREIGN KEY (`skill_id`) REFERENCES `user_skill`(`skill_id`)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `user_skill`
(
    `user_id`  INT NOT NULL,
    `skill_id` INT NOT NULL,
    `level`    INT,
    `privacy`  BOOLEAN,
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`),
    PRIMARY KEY (`user_id`,`skill_id`)
)
    ENGINE = InnoDB;

CREATE TABLE if not exists `user_role`
(
    `id`     INT(11)     NOT NULL AUTO_INCREMENT,
    `userid` INT(11)     NOT NULL,
    `role`   varchar(45) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`userid`) REFERENCES `user`(`id`)
)

    ENGINE = InnoDB;

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
insert into skill_hierarchy (parent_id,child_id) values (5,4);

INSERT INTO user(username,email, password)
VALUES ('Fin','fin@gmail.com', '{bcrypt}$2a$10$B188I9BfwGLsWGU9eF4wPOV6O6z.MgEbNxcErNEKb8xwM.4ChBT7G');

insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', 'python-help', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '1', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '2', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '3', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '4', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '5', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '6', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '7', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '8', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '9', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '10', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '11', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '12', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '13', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '14', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '15', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '16', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '17', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '18', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '19', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '20', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '21', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '22', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '23', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '24', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '25', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '26', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '27', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '28', 'operations', 'Python', 'Need help with python');
insert into skill_requests (id, first_name, last_name, furl, department, skill, info) values (null, 'Daniel', 'Fulop', '29', 'operations', 'Python', 'Need help with python');
INSERT INTO user_role(userid, role)
VALUES (001, 'ROLE_USER');

insert into user_skill (user_id, skill_id, level ,privacy) values (1,1,12,true);
insert into user_skill (user_id, skill_id, level ,privacy) values (1,2,12,false);
insert into user_skill (user_id, skill_id, level ,privacy) values (1,3,12,true) ;
insert into user_skill (user_id, skill_id, level ,privacy) values (1,4,12,true);
insert into user_skill (user_id, skill_id, level ,privacy) values (1,5,12,false);







