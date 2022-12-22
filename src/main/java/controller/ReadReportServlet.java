package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.ReportDao;
import domain.Report;

/**
 * Servlet implementation class ReadReportServlet
 */
@WebServlet("/readReport")
public class ReadReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Report> reportList = new ArrayList<>();
		try {
			ReportDao reportDao = DaoFactory.createReportDao();
			reportList = reportDao.findAll();
		} catch (Exception e) {
			throw new ServletException(e);
		}

		request.setAttribute("reportList", reportList);
		request.getRequestDispatcher("/WEB-INF/view/readReport.jsp").forward(request, response);

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
