package com.spice.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class NightRadio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NightRadio() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false); 
		if(session != null) {
			session.invalidate();
			session = request.getSession();
		} else {
			session = request.getSession();
		}
		System.out.println("NightRadio Servlet Called........");	
		
			RequestDispatcher view = request.getRequestDispatcher("/nightRadio.jsp");
			view.forward(request, response);
		
	}
}

