CREATE TABLE `t_order` (
`id` varchar(255) NOT NULL,
`address_id` varchar(255) DEFAULT NULL,
`account_id` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`),
KEY (`address_id`),
KEY (`account_id`),
FOREIGN KEY (`account_id`) REFERENCES `t_account` (`id`),
FOREIGN KEY (`address_id`) REFERENCES `t_address` (`id`)
);