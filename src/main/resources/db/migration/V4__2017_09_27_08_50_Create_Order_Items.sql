CREATE TABLE `t_order_items` (
`order_id` varchar(255) NOT NULL,
`item_id` varchar(255) NOT NULL,
KEY (`item_id`),
KEY (`order_id`),
FOREIGN KEY (`item_id`) REFERENCES `t_item` (`id`),
FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`)
);