SET MODE MySQL;
SET IGNORECASE = TRUE;

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
    `level`    INT NOT NULL,
    `privacy`  BOOLEAN NOT NULL,
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
