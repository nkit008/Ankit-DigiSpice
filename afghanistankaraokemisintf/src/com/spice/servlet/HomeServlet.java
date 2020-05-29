package com.spice.servlet;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.spice.bean.AwccMisBean;
import com.spice.bean.KaraokeMisBean;
import com.spice.bean.UssdInfoBean;
import com.spice.bean.UssdIslamicBean;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Home Servlet Called ...............");
		HttpSession session = request.getSession(false);

		if (session == null) {
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
			view.forward(request, response);
		}
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		String service = request.getParameter("accessService");
		System.out.println("service===" + service);
		System.out.println("sdate===" + sdate);
		System.out.println("edate===" + edate);
		session.setAttribute("mapdata", null);
		System.out.println("service is :"+service);
		if (service.equalsIgnoreCase("awcc")) {
			AwccMisBean rmb = new AwccMisBean();
			try {
				session.setAttribute("result", "a");
				Map[] resultMap = rmb.GetData(sdate, edate);
				System.out.println("Length of Result Map is ... " + resultMap.length);
				if (resultMap.length > 0) {
					RequestDispatcher view = request.getRequestDispatcher("/homeAwcc.jsp");
					session.setAttribute("mapdata", resultMap);
					view.forward(request, response);
				} else {
					RequestDispatcher view = request.getRequestDispatcher("/homeAwcc.jsp");
					view.forward(request, response);
				}
			} catch (Exception e) {
				System.out.println("Exception in getting Map value in Home Servlet.." + e);
				e.printStackTrace();
				RequestDispatcher view = request.getRequestDispatcher("/homeAwcc.jsp");
				view.forward(request, response);
			}
		}
		else if (service.equalsIgnoreCase("Karaoke") || service.equalsIgnoreCase("KAR")) {
			KaraokeMisBean rmb = new KaraokeMisBean();
			try {
				Map[] resultMap = rmb.GetData(sdate, edate);
				System.out.println("Length of Result Map is ... " + resultMap.length);
				if (resultMap.length > 0) {

					RequestDispatcher view = request.getRequestDispatcher("/homeKaraoke.jsp");
					session.setAttribute("mapdata", resultMap);
					view.forward(request, response);

				} else {
					RequestDispatcher view = request.getRequestDispatcher("/homeKaraoke.jsp");
					view.forward(request, response);
				}

			} catch (Exception e) {
				System.out.println("Exception in getting Map value in Home Servlet.." + e);
				e.printStackTrace();
				RequestDispatcher view = request.getRequestDispatcher("/homeKaraoke.jsp");
				view.forward(request, response);
			}
		}
		else if (service.equalsIgnoreCase("islamic") || service.equalsIgnoreCase("USSD_ISLAMIC")) {
			UssdIslamicBean rmb = new UssdIslamicBean();
			try {
				session.setAttribute("result", "a");
				Map[] resultMap = rmb.GetData(sdate, edate);
				System.out.println("Length of Result Map is ... " + resultMap.length);
				if (resultMap.length > 0) {
					RequestDispatcher view = request.getRequestDispatcher("/homeIslamic.jsp");
					session.setAttribute("mapdata", resultMap);
					view.forward(request, response);
				} else {
					RequestDispatcher view = request.getRequestDispatcher("/homeIslamic.jsp");
					view.forward(request, response);
				}
			} catch (Exception e) {
				System.out.println("Exception in getting Map value in Home Servlet.." + e);
				e.printStackTrace();
				RequestDispatcher view = request.getRequestDispatcher("/homeIslamic.jsp");
				view.forward(request, response);
			}
		}
		else if (service.equalsIgnoreCase("info") || service.equalsIgnoreCase("USSD_INFO")) {
			UssdInfoBean rmb = new UssdInfoBean();
			try {
				Map[] resultMap = rmb.GetData(sdate, edate);
				System.out.println("Length of Result Map is ... " + resultMap.length);
				if (resultMap.length > 0) {
					RequestDispatcher view = request.getRequestDispatcher("/homeInfo.jsp");
					session.setAttribute("mapdata", resultMap);
					view.forward(request, response);
				} else {
					RequestDispatcher view = request.getRequestDispatcher("/homeInfo.jsp");
					view.forward(request, response);
				}
			} catch (Exception e) {
				System.out.println("Exception in getting Map value in Home Servlet.." + e);
				e.printStackTrace();
				RequestDispatcher view = request.getRequestDispatcher("/homeInfo.jsp");
				view.forward(request, response);
			}
		}
	}
}
