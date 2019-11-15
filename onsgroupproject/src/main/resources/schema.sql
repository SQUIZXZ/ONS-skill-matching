SET MODE MySQL;
SET IGNORECASE = TRUE;

CREATE TABLE IF NOT EXISTS `skillRequests`
(
    `id`           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `first_name`   VARCHAR(100)  NOT NULL,
    `surname_name` VARCHAR(100) NOT NULL,
    `furl`         VARCHAR(20) NOT NULL,
    `department`   VARCHAR(100) NOT NULL,
    `skill`        VARCHAR(100) NULL,
    `desc`         VARCHAR(300)  NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;
