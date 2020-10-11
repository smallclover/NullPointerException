# 网站设置
DROP TABLE IF EXISTS setting;
CREATE TABLE setting
(
    `id`          bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `site_name`   varchar(50) COMMENT '站点名称',
    `site_desc`   varchar(50) COMMENT '站点描述',
    `app_version` varchar(50) COMMENT '程序版本',
    `github`      varchar(50) COMMENT 'github',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4