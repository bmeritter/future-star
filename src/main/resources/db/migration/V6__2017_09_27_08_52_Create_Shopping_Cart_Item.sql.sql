CREATE TABLE `t_shopping_cart_item` (
`shopping_cart_id` varchar(255) NOT NULL,
`item_id` varchar(255) NOT NULL,
PRIMARY KEY (`shopping_cart_id`,`item_id`),
KEY (`item_id`),
FOREIGN KEY (`shopping_cart_id`) REFERENCES `t_shopping_cart` (`id`),
FOREIGN KEY (`item_id`) REFERENCES `t_item` (`id`)
);