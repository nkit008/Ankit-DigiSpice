package com.spice.servlet;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.spice.bean.NightRadioBean;
import com.spice.bean.ShayariBean;


public class HomeShayariServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeShayariServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Home Shayari Servlet Called ...............");
		HttpSession session = request.getSession(false);

		if (session == null) {
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			view.forward(request, response);
		}
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		String service = request.getParameter("service");
		System.out.println("service===" + service);
		System.out.println("sdate===" + sdate);
		System.out.println("edate===" + edate);
		session.setAttribute("mapdata", null);
		System.out.println("service is :"+service);
		if (service.equalsIgnoreCase("shayari")) {
			 ShayariBean sBean = new ShayariBean();
			try {
				session.setAttribute("result", "a");
				Map[] resultMap = sBean.GetData(sdate, edate);
				System.out.println("Length of Result Map is ... " + resultMap.length);
				if (resultMap.length > 0) {
					RequestDispatcher view = request.getRequestDispatcher("/shayari.jsp");
					session.setAttribute("mapdata", resultMap);
					
					session.setAttribute("mapdataLength", resultMap.length+2);
					view.forward(request, response);
				} else {
					RequestDispatcher view = request.getRequestDispatcher("/shayari.jsp");
					view.forward(request, response);
				}
			} catch (Exception e) {
				System.out.println("Exception in getting Map value in Home Servlet.." + e);
				e.printStackTrace();
				RequestDispatcher view = request.getRequestDispatcher("/shayari.jsp");
				view.forward(request, response);
			}
		}
	}
}
