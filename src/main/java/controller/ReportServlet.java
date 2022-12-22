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
import dao.MountainDao;
import dao.ReportDao;
import domain.Mountain;
import domain.Report;
import domain.User;

/**
 * Servlet implementation class RecordServlet
 */
@WebServlet("/report")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		Integer id = null;
		if(strId != null) {
			id = Integer.parseInt(strId);
			try {
				MountainDao mountainDao = DaoFactory.createMountainDao();
				 Mountain mountain = mountainDao.findById(id);
				 request.setAttribute("mountain", mountain);
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}
		request.getRequestDispatcher("/WEB-INF/view/report.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String name =request.getParameter("name");
		String erea = request.getParameter("erea");
		Integer elevation = Integer.parseInt(request.getParameter("elevation"));
		String note = request.getParameter("note");
		String strDate =request.getParameter("date");
		
//		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = Date.valueOf(strDate);
		
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String reportId = (String) user.getLoginId();
		
		Report report = new Report();
		report.setName(name);
		report.setErea(erea);
		report.setElevation(elevation);
		report.setNote(note);
		report.setDate(date);
		report.setReportId(reportId);
		
		ReportDao reportDao = DaoFactory.createReportDao();
		reportDao.insert(report);
		
		response.sendRedirect("myReport");
		
		}catch(Exception e) {
			throw new ServletException (e);
		}
		
		
		
	}

}
