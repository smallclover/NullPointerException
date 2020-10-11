DROP TABLE IF EXISTS user;
CREATE TABLE `user`(
                          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
                          `email` varchar(50) NOT NULL COMMENT '邮箱',
                          `password` varchar(50) NOT NULL COMMENT '密码',
                          `username` varchar(50) NOT NULL COMMENT '用户名',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4