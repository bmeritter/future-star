CREATE TABLE `t_address` (
`id` varchar(255) NOT NULL,
`address_detail` varchar(255) DEFAULT NULL,
`account_id` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY (`account_id`) REFERENCES `t_account` (`id`)
);