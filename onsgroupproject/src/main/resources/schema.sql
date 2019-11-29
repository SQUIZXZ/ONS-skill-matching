SET MODE MySQL;
SET IGNORECASE = TRUE;

CREATE TABLE IF NOT EXISTS `skill`
(
    `id`           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `skill_name`   VARCHAR(100)  NOT NULL,

    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `skill_hierarchy`
(
    `parent_id`  INT UNSIGNED NOT NULL,
    `child_id`   INT UNSIGNED NOT NULL,
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

CREATE TABLE IF NOT EXISTS `user_skill`
(
    `user_id`    INT NOT NULL,
    `skill_id`    INT NOT NULL,
    `level`   INT NOT NULL,
    PRIMARY KEY (user_id,skill_id)
--    FOREIGN KEY (user_id) REFERENCES `users`(id),
--    FOREIGN KEY (skill_id) REFERENCES `skill`(id)
)
    ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `users`
(
    `id`           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `first_name`   VARCHAR(100)  NOT NULL,
    `surname`    VARCHAR(100) NOT NULL,
    `email`        VARCHAR(100) NULL,
    `privacy`      BOOLEAN NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;

