DROP TABLE IF EXISTS comment;
CREATE TABLE `comment`
(
    `id`                  bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `content`             varchar(50) NOT NULL COMMENT '评论内容',
    `article_id`          bigint(20)  NOT NULL COMMENT '评论的文章id',
    `pass_audit`          boolean     NOT NULL COMMENT '是否通过审核',
    `user_id`             varchar(50)  NOT NULL COMMENT '评论的用户id',
    `nickname`            varchar(50) NOT NULL COMMENT '评论者昵称',
    `email`               varchar(25) NOT NULL COMMENT '邮箱',
    `comment_parent_id`   varchar(50) COMMENT '评论所属的一级评论id',
    `reply_user_id`       varchar(50) COMMENT '回复人id',
    `reply_user_nickname` varchar(20) COMMENT '回复人昵称',
    `create_time`         timestamp   NOT NULL COMMENT '创建时间',
    `delete_flag`         boolean     NOT NULL COMMENT '删除flag',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4