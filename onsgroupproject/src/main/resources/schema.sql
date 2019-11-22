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
    `parentID`  INT UNSIGNED NOT NULL,
    `childID`   INT UNSIGNED NOT NULL,

    CONSTRAINT
        FOREIGN KEY (`fk_parent`)
        REFERENCES `skill`(`id`),
    CONSTRAINT
        FOREIGN KEY (`fk_child`)
        REFERENCES `skill`(`id`)

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

