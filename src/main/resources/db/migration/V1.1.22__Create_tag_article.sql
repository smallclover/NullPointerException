DROP TABLE IF EXISTS tag_article;
CREATE TABLE `tag_article`(
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                   `tag_id` bigint NOT NULL COMMENT '分类Id',
                                   `article_id` bigint NOT NULL COMMENT '文章Id',
                                   `create_time` timestamp NOT NULL COMMENT '创建时间',
                                   `delete_flag` boolean NOT NULL COMMENT '删除标志',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4