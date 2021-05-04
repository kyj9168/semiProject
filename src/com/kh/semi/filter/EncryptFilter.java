package com.kh.semi.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.kh.semi.wrapper.LoginWrapper;

@WebFilter("*.user")
public class EncryptFilter implements Filter {

    public EncryptFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println("암호화 필터 들어왔음");

		HttpServletRequest hRequest = (HttpServletRequest) request;

		LoginWrapper lw = new LoginWrapper(hRequest);

		// pass the request along the filter chain
		chain.doFilter(lw, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
