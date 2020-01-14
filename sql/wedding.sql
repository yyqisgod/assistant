CREATE TABLE `barrage` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `color` varchar(20) DEFAULT NULL,
                         `img` varchar(255) DEFAULT NULL,
                         `href` varchar(255) DEFAULT NULL,
                         `speed` varchar(20) DEFAULT NULL,
                         `info` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `luck_draw` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `user_id` varchar(30) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;