[![Build Status](https://travis-ci.org/HankXV/Recorder.svg?branch=master)](https://travis-ci.org/HankXV/Recorder)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/8558598883684247a0e568b7ad30bf4d)](https://www.codacy.com/app/104381832/Recorder?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=HankXV/Recorder&amp;utm_campaign=Badge_Grade)
# 什么是Recorder？
move to https://gitee.com/HankXV/Recorder<br>
![](/recorder-thumb.png)
## 环境要求
Jdk8 or above<br>
mysql-connector-java-5.x
# 快速开始
建立一个日志的Bean

```java
	public class UserLog extends TimeBasedLog {
		@Col(type = SQLType.VARCHAR, size = 255, comment = "user name")
		public String name;
		@Col(comment = "user age")
		public int age;
		@Col(type = SQLType.VARCHAR, size = 255, comment = "user address")
		public String address;
	
		@Override
		public RollType rollType() {
			return RollType.DAY_ROLL;
		}
	}
```
初始化日志代理，并执行写入任务，完成！

```java

	UserLog userLog = new UserLog();
	userLog.name="HankXV";
	userLog.age=101;
	userLog.address="home";
	new RecorderProxy
	.RecorderProxyBuilder()
	.dataSource(yourDatasource)
	.build()
	.startServer()
	.execute(userLog);
		
```
# 更新日志
## v2.0-release
	1.表检查器支持多表同Bean的检查(垂直分表)，表名逗号隔开
## v2.0-alpha
	此版本为pre-release版本
	1.减少了很多复杂的命名
	2.日志Bean的字段从私有变为公有，操作更方便
	3.增加查询日志的API
	4.简化SQLType的名称
