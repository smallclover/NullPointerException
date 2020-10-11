# NullPointerException
www.nullpointerexception.cf

## 目标
目前暂时先以搭建一个完整的博客为主

## 关于配置
+ 在resources的根目录下创建application-global.yml文件然后根据
```yaml

    application.yaml 
    application-dev.yml 
    application-prod.yml

```
的配置的变量创建相关的变量即可。 

+ 手动在User表里追加后台登录的用户

## 技术选型
+ JDK：AdoptOpenJDK 11.07
+ 框架：SpringBoot及其它Spring框架
+ 数据库迁移工具：Flyway
+ 模板引擎：Thymeleaf
+ Json：Jackson
+ 数据库：MySQL
+ 缓存：Redis
+ 项目管理工具：Gradle
+ 数据库持久层：MyBaits
+ 其他：lombok
+ 服务器系统：CentOS
+ 服务器：Nginx
+ Servlet容器：Tomcat
## 结构

现在整体分为两个模块，前台的**博客模块**和后台的**管理模块**

### 博客模块
博客模块包含一下几个模块：
+ 首页
+ 文章列表
+ 文章详情
+ 归档
+ 标签云
+ 旅行日志
+ 开发日志

### 管理模块
管理模块包含一下几个模块：
+ 仪表盘
+ 文章管理
+ 添加文章
+ 标签管理模块
+ 评论管理
+ 开发日志管理
+ 添加开发日志
+ 上传文件管理
+ 日历

### 项目截图

#### 博客

##### 首页

![首页](/doc/img/blog/home.png)

##### 文章列表

![文章列表](/doc/img/blog/articles.png)

##### 归档

![归档](/doc/img/blog/archive.png)

##### 标签云

![标签云](/doc/img/blog/tag-cloud.png)

##### 关于

![关于](/doc/img/blog/about.png)

##### 旅行

![旅行](/doc/img/blog/travel.png)

##### 日志

![日志](/doc/img/blog/log.png)

#### 管理

##### 首页

![首页](/doc/img/admin/home.png)

##### 发布文章

![发布文章](/doc/img/admin/publish-article.png)

##### 文章管理

![文章管理](/doc/img/admin/article-manager.png)

##### 标签分类管理

![标签分类管理](/doc/img/admin/tag-category-manager.png)

##### 评论管理

![评论管理](/doc/img/admin/comment-manager.png)

##### 开发日志管理

![开发日志管理](/doc/img/admin/develop-log.png)

##### 添加开发日志

![添加开发日志](/doc/img/admin/add-develop-log.png)

##### 日历

![日历](/doc/img/admin/calendar.png)

##### 附件管理

![附件管理](/doc/img/admin/attach.png)

##### 系统设置

![系统设置](/doc/img/admin/setting.png)

# NullPointerException
