CREATE TABLE `t_item` (
`id` varchar(255) NOT NULL,
`name` varchar(255) DEFAULT NULL,
`price` int(11) DEFAULT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY (`name`)
);