CREATE TABLE `t_shopping_cart` (
`id` varchar(255) NOT NULL,
`account_id` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`),
KEY (`account_id`),
FOREIGN KEY (`account_id`) REFERENCES `t_account` (`id`)
);