DROP TABLE IF EXISTS category;
CREATE TABLE `category`(
                      `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                      `category_name` varchar(50) NOT NULL COMMENT '名称',
                      `update_time` timestamp NOT NULL COMMENT '更新时间',
                      `create_time` timestamp NOT NULL COMMENT '创建时间',
                      `delete_flag` boolean NOT NULL COMMENT '删除标志',
                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4