#### 介绍
允许跨域配置，只要后端配置允许跨域并在response headers设置Access-Control-Allow-Origin即可。前端无需再做跨域配置就可以直接实现跨域访问


#### 配置
1. 添加跨域配置
```
@Configuration
public class CrosConfig implements WebMvcConfigurer {

	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						// .allowedOrigins("http://yyy.com", "http://xxx.com") //
						// 允许跨域的域名
						.allowedOriginPatterns("*") // 允许所有域
						.allowedMethods("*") // 允许任何方法（GET, HEAD, POST, PUT, DELETE, OPTIONS, PATCH）
						.allowedHeaders("*") // 允许任何请求头
						.allowCredentials(true) // 允许证书、cookie
						.exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); // maxAge(3600)表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
			}
		};
	}

}
```
2. 配置过滤器在response headers设置Access-Control-Allow-Origin
```
@Component
@WebFilter(urlPatterns = "/*", filterName = "CorsFilter")
public class CorsFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest reqs = (HttpServletRequest) req;
		String curOrigin = reqs.getHeader("Origin");
		response.setHeader("Access-Control-Allow-Origin", curOrigin == null ? "true" : curOrigin);
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, PUT");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		chain.doFilter(req, res);
	}

}
```
