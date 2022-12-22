package controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ReadReportServlet
 */
@WebServlet("/myReport")
public class MyReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String change = request.getParameter("change");
		String strId = request.getParameter("id");
		Integer id = null;

		if (strId != null) {
			id = Integer.parseInt(strId);
			if (change.equals("1")) {
				try {
					ReportDao reportDao = DaoFactory.createReportDao();
					reportDao.delete(id);
				} catch (Exception e) {
					throw new ServletException(e);
				}
				
				response.sendRedirect("myReport");
				return;

			}else if(change.equals("0")) {
				Report report = null;
				try {
					ReportDao reportDao = DaoFactory.createReportDao();
					report = reportDao.findById(id);
					request.setAttribute("report", report);
					request.getRequestDispatcher("/WEB-INF/view/changeReport.jsp")
							.forward(request, response);
				} catch (Exception e) {
					throw new ServletException(e);
				}
				
				return;
			}

		}

		try {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			String reportId = user.getLoginId();

			List<Report> reportList = null;
			ReportDao reportDao = DaoFactory.createReportDao();
			reportList = reportDao.findByReportId(reportId);

			request.setAttribute("reportList", reportList);
			request.getRequestDispatcher("/WEB-INF/view/myReport.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
