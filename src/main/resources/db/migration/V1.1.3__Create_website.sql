DROP TABLE IF EXISTS website;
CREATE TABLE `website`(
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` varchar(20) NOT NULL COMMENT '网站名称',
    `desc` text NOT NULL COMMENT  '网站描述',
    `logo` varchar(50) NOT NULL COMMENT 'logo图片存储路径',
    `icon` varchar(50) NOT NULL COMMENT 'icon图片存储路径',
    `about` text NOT NULL COMMENT '关于',
    `icp` varchar(50) NOT NULL COMMENT '备案信息',
    `copy_right` varchar(50) NOT NULL COMMENT 'copy_right',
    `powered_by` varchar(30) NOT NULL COMMENT 'powered_by',
    `powered_by_url` varchar(50) NOT NULL COMMENT 'powered_by_url',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4