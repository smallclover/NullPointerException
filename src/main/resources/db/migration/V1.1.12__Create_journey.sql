DROP TABLE IF EXISTS journey;
CREATE TABLE `journey`(
                          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                          `title` varchar(50) NOT NULL COMMENT '标题',
                          `desc` varchar(50) NOT NULL COMMENT '描述',
                          `pic_path` varchar(50) NOT NULL COMMENT '存储路径',
                          `make_time` varchar(50)  NOT NULL COMMENT '拍摄时间',
                          `longitude` varchar(50) NOT NULL COMMENT '纬度',
                          `latitude` varchar(50) NOT NULL COMMENT '经度',
                          `delete_flag` boolean NOT NULL COMMENT '删除标志',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4