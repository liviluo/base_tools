#### springboot整合mybatis
配合mybatis代码生成工具，生成实体mapper等文件。参考[mybatis_generator](https://gitee.com/liviluo/mybatis_generator)


#### 步骤
- 引入依赖pom.xml
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>

		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>2.1.3</version>
		</dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
```

- 配置数据库连接信息application.properties
```
spring.datasource.url = jdbc:mysql://localhost:3306/shop-demo?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC
spring.datasource.username = livi
spring.datasource.password = 123456
spring.datasource.driver-class-name: com.mysql.cj.jdbc.Driver
mybatis.mapper-locations = classpath:mybatis/mapper/*.xml

```

- 添加@Mapper注解

- 使用@Autowired注入调用


#### 其他说明
- 返回自增字段

```
useGeneratedKeys： 是否自动生成主键，默认false
keyProperty:  返回的主键值赋给哪个属性
keyColumn： 数据库中的自增主键的列名，默认是数据库表的第一列，当主键列不是表中的第一列的时候需要设置
<insert id="insert" useGeneratedKeys="true" keyProperty="id"
keyColumn="id" parameterType="tools.model.user.User">
</insert>
```

