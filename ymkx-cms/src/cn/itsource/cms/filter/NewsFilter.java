package cn.itsource.cms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import cn.itsource.cms.model.User;

/**
 * Servlet Filter implementation class NewsFilter
 */
@WebFilter("/newsFilter")
public class NewsFilter implements Filter {
	Logger log = Logger.getLogger(NewsFilter.class);

	public NewsFilter() {
	}

	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("***进入登录拦截器***");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		// 获取请求的地址
		String uri = httpRequest.getRequestURI();
		System.out.println("uri = " + uri);
		// 如果地址中有login、register、wellcome、details等直接放行，静态文件也是直接放行css、png、jpg等
		if (StringUtils.isEmpty(uri) || uri.contains("login") || uri.endsWith(".css") || uri.endsWith(".png")
				|| uri.endsWith(".jpg") || uri.endsWith("ymkx-cms/") || uri.endsWith("ymkx-cms")
				|| uri.contains("wellcome") || uri.contains("wellcome")) {
			chain.doFilter(request, response);
		} else {
			User user = (User) httpRequest.getSession().getAttribute("user");
			// 判断登录对象是否为null
			if (null == user) {
				httpResponse.sendRedirect("login.jsp");
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}