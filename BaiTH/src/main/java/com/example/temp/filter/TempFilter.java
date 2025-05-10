package com.example.temp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/convert")
public class TempFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String tempStr = request.getParameter("temperature");
        try {
            Double.parseDouble(tempStr);
            chain.doFilter(request, response);
        } catch (NumberFormatException | NullPointerException e) {
            request.setAttribute("error", "Giá trị nhiệt độ không hợp lệ!");
            request.getRequestDispatcher("/temp.jsp").forward(request, response);
        }
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}