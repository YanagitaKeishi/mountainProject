package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.ReportDao;
import domain.Report;
import domain.User;

/**
 * Servlet implementation class ChangeReportServlet
 */
@WebServlet("/changeReport")
public class ChangeReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String strId = request.getParameter("id");
			Integer id = Integer.parseInt(strId);
			String name =request.getParameter("name");
			String erea = request.getParameter("erea");
			Integer elevation = Integer.parseInt(request.getParameter("elevation"));
			String note = request.getParameter("note");
			String strDate =request.getParameter("date");
			
//			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = Date.valueOf(strDate);
			
			
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			String reportId = (String) user.getLoginId();
			
			Report report = new Report();
			report.setId(id);
			report.setName(name);
			report.setErea(erea);
			report.setElevation(elevation);
			report.setNote(note);
			report.setDate(date);
			report.setReportId(reportId);
			
			ReportDao reportDao = DaoFactory.createReportDao();
			reportDao.update(report);
			
			response.sendRedirect("myReport");
			
			}catch(Exception e) {
				throw new ServletException (e);
			}
	}

}
