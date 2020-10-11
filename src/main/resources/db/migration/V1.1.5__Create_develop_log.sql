DROP TABLE IF EXISTS develop_log;
CREATE TABLE `develop_log`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `content` text NOT NULL COMMENT '修复内容',
    `bug_type` varchar(20) NOT NULL COMMENT 'bug类型',
    `author` varchar(20) NOT NULL COMMENT '修复者',
    `create_time` varchar(20) NOT NULL COMMENT '问题修复时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4