DROP TABLE IF EXISTS article;
CREATE TABLE `article`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `title` varchar(20) NOT NULL COMMENT '标题',
    `desc` text NOT NULL COMMENT '描述',
    `md_content` longtext NOT NULL COMMENT '文章内容(markdown)',
    `html_content` longtext NOT NULL COMMENT '文章内容(html)',
    `content_view` int(6) DEFAULT NULL COMMENT '点击量',
    `create_time` timestamp NOT NULL COMMENT '创建时间',
    `comment` boolean NOT NULL COMMENT '是否开启评论',
    `status` boolean NOT NULL COMMENT '是否是草稿',
    `publish` boolean NOT NULL COMMENT '是否发布',
    `delete_flag` boolean NOT NULL COMMENT '删除标志',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4