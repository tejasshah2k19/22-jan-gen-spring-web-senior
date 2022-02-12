package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//you can not access any url without login
public class LoginCheckFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) (request)).getSession();
		if (session.getAttribute("userId") == null) {
			((HttpServletResponse) (response)).sendRedirect("login");
		} else {
			chain.doFilter(request, response);
		}

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
