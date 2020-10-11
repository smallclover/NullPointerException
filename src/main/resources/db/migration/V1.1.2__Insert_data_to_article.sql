INSERT INTO article (title, `desc`, md_content, html_content, content_view, create_time, comment, status,publish, delete_flag)
VALUES (
    'HelloWorld',
    'This is a HelloWorld',
    '# HelloWorld
```java
public class HelloWorld{
	public static void main(String[] args){
			System.out.println("HelloWorld");
	}
}
```',
    '<h1 id="h1-helloworld"><a name="HelloWorld" class="reference-link"></a><span class="header-link octicon octicon-link"></span>HelloWorld</h1><pre><code class="lang-java">public class HelloWorld{
    public static void main(String[] args){
            System.out.println(&quot;HelloWorld&quot;);
    }
}
</code></pre>',
    1000,
    '2019-12-12 11:11:11',
    true,
    false,
    true,
    false
);
INSERT INTO article (title, `desc`, md_content, html_content, content_view, create_time, comment, status,publish, delete_flag)
VALUES (
           '心',
           '蓦然回首，那人却在灯火阑珊处',
           '# 雕栏玉彻应犹在，只是朱颜改。
            # 问君能有几多愁，恰似一江春水向东流。',
           '<h2>雕栏玉彻应犹在，只是朱颜改</h1>
            <h2>问君能有几多愁，恰似一江春水向东流。</h2>',
           2333,
           '2020-01-01 11:11:11',
           true,
            false,
            true,
            false
       )
# 如果一个已经执行过的脚本被修改过，那么flyway在进行哈希校验的时候发现文件不匹配而报错
# 这里desc之所以打上两个反引号使用为desc在mysql里是排序的关键字