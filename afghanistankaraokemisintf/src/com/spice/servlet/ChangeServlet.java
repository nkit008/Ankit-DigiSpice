package com.spice.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String page = request.getParameter("accesspage");
		System.out.println("Showing MIS page of USSD"+page);
		RequestDispatcher rd= null;
		session.setAttribute("mapdata", null);
		if(page.equalsIgnoreCase("awcc"))
		 rd = request.getRequestDispatcher("/homeAwcc.jsp");
		else if(page.equalsIgnoreCase("KAR"))
			rd = request.getRequestDispatcher("/homeKaraoke.jsp");
		else if(page.equalsIgnoreCase("islamic"))
			rd = request.getRequestDispatcher("/homeIslamic.jsp");
		else
			rd = request.getRequestDispatcher("/homeInfo.jsp");
		
		rd.forward(request, response);
		
	}

}
