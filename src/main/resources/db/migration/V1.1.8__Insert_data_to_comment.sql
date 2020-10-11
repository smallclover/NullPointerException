INSERT INTO comment(content, article_id, pass_audit,user_id, nickname, email, comment_parent_id, reply_user_id, reply_user_nickname, create_time, delete_flag)
VALUES (
        '评论测试1',
        1,
        true,
        1,
        '梦梦',
        'test@npe.com',
        NULL,
        NULL,
        NULL,
        '2020-01-13 23:52:26',
        false
       );
INSERT INTO comment(content, article_id, pass_audit,user_id, nickname, email, comment_parent_id, reply_user_id, reply_user_nickname, create_time, delete_flag)
VALUES (
           '评论测试2',
           2,
           true,
           1,
           '梦梦',
           'test@npe.com',
           NULL,
           2,
           '叶叶',
           '2020-01-13 23:52:26',
           false
       );
INSERT INTO comment(content, article_id, pass_audit,user_id, nickname, email, comment_parent_id, reply_user_id, reply_user_nickname, create_time, delete_flag)
VALUES (
           '评论测试3',
           2,
           true,
           2,
           '叶叶',
           'test@npe.com',
           1,
           3,
           '叶子',
           '2020-01-13 23:52:26',
           false
       );
INSERT INTO comment(content, article_id, pass_audit,user_id, nickname, email, comment_parent_id, reply_user_id, reply_user_nickname, create_time, delete_flag)
VALUES (
           '评论测试4',
           2,
           true,
           3,
           '叶子',
           'test@npe.com',
           1,
           4,
           '灵梦',
           '2020-01-13 23:52:26',
           false
       );
INSERT INTO comment(content, article_id, pass_audit,user_id, nickname, email, comment_parent_id, reply_user_id, reply_user_nickname, create_time, delete_flag)
VALUES (
           '评论测试5',
           2,
           true,
           4,
           '灵梦',
           'test@npe.com',
           1,
           NULL,
           NULL,
           '2020-01-13 23:52:26',
           false
       );
INSERT INTO comment(content, article_id, pass_audit,user_id, nickname, email, comment_parent_id, reply_user_id, reply_user_nickname, create_time, delete_flag)
VALUES (
           '评论测试6',
           2,
           false,
           5,
           '叶子',
           'test@npe.com',
           1,
           NULL,
           NULL,
           '2020-01-13 23:52:26',
           false
       );