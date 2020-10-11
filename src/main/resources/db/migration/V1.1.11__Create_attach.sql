DROP TABLE IF EXISTS attach;
CREATE TABLE `attach`(
                          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                          `name` varchar(50) NOT NULL COMMENT '名称',
                          `desc` varchar(50) NOT NULL COMMENT '描述',
                          `file_type` varchar(50) NOT NULL COMMENT '文件类型',
                          `storage_path` varchar(50) NOT NULL COMMENT '存储路径',
                          `upload_time` timestamp NOT NULL COMMENT '上传时间',
                          `delete_flag` boolean NOT NULL COMMENT '删除标志',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4