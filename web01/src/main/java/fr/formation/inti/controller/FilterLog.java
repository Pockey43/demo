package fr.formation.inti.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet Filter implementation class FilterLog
 */
@WebFilter("/*")
public class FilterLog implements Filter {
	private static final Log log = LogFactory.getLog(FilterLog.class);
	private ServletContext context;
	
	
    /**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("RequestLoggingFilter initialized");
	}
	
	
	/**
     * Default constructor. 
     */
    public FilterLog() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Enumeration<String> params = req.getParameterNames();
		
		while (params.hasMoreElements()){
			String name = params.nextElement();
			String value = request.getParameter(name);
			this.context.log(req.getRemoteAddr() + " ::Request Params::("+name+"="+value+"}");
		}
		HttpSession session = req.getSession(false);
		String uri = req.getRequestURI();
		this.context.log("Requested Resource : " + uri);
		
		if(session == null && !(uri.endsWith("login") || uri.endsWith("index.jsp")) ) {
			this.context.log("Unauthorizes access request");
			resp.sendRedirect("index.jsp");
		}else {
			chain.doFilter(request, response);
		}
		this.context.log("after chain.doFilter");
		
		// pass the request along the filter chain
	}


}
