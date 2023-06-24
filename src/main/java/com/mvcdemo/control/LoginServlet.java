package com.mvcdemo.control;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mvcdemo.model.User;
import com.mvcdemo.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		LoginService loginService = new LoginService();
		
		boolean result = loginService.authenticate(userId, password);
		
		if(result) {
			User user = loginService.getUserDetails(userId);
			request.setAttribute("user", user);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
			
			dispatcher.forward(request, response);
			
			return;
		}
		else {
			response.sendRedirect("login.jsp");
			return;
		}
	}

}
