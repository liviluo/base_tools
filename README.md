#### 介绍
版本：spring boot 2.6.2  
java 11+  
默认使用war包，可以部署到tomcat运行，也可以直接使用java -jar直接运行  
一个功能模块独立一个分支，方便查看某一项功能的代码，结构和配置  


#### 分支说明
分支：master  
包括基础的web，内置tomcat，单元测试，热部署等。其他所有分支都继承此分支  


#### 操作
1. 引入依赖
```
<!-- cas client -->
<dependency>
<groupId>net.unicon.cas</groupId>
<artifactId>cas-client-autoconfig-support</artifactId>
<version>2.1.0-GA</version>
</dependency>
```

2. 配置cas客户端地址和cas服务端地址
```
cas.client-host-url = 
#cas认证中心地址
cas.server-url-prefix = 
#cas认证中心登录地址
cas.server-login-url = 

cas.use-session = true
cas.validation-type = cas
```

3. 开启注解
```
@EnableCasClient
```

#### 其他说明
- 配置过滤器
```
@Configuration
public class CasConfiguration extends CasClientConfigurerAdapter {
	@Override
	public void configureAuthenticationFilter(FilterRegistrationBean authenticationFilter) {
		super.configureAuthenticationFilter(authenticationFilter);
		// 配置地址，这里还可以配置很多，例如cas重定向策略等。
		authenticationFilter.getInitParameters().put("ignorePattern", "/ignore|/logout.html");
	}
}
```
- 获取用户信息
```
	@RequestMapping(value = "user")
	public String user(HttpServletRequest request) throws Exception {
		AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
		String username = principal.getName();
		return "login user: " + username;
	}
```
- logout操作
```
        @RequestMapping(value = "logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(clientLogoutUrl);
	}
```
