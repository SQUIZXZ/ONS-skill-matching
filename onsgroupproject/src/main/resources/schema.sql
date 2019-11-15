SET MODE MySQL;
SET IGNORECASE = TRUE;

CREATE TABLE IF NOT EXISTS `skillRequests`
(
    `id`           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `first_name`   VARCHAR(50)  NOT NULL,
    `surname_name` VARCHAR(50) NOT NULL,
    `department`   VARCHAR(20) NOT NULL,
    `skill`        VARCHAR(20) NULL,
    `desc`         VARCHAR(100)  NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;
