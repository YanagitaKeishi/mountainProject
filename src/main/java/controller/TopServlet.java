package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TopServlet
 */
@WebServlet("/top")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		User user = new User();
//		try {
//			HttpSession session = request.getSession();
//			String loginId = (String) session.getAttribute("loginId");
//			if (loginId != null) {
//				UserDao userDao = DaoFactory.createUserDao();
//				user = userDao.findByLoginId(loginId);
//				if (user != null) {
//					request.setAttribute("name", user.getName());
//				}
//			} else {
//				request.setAttribute("name", null);
//			}
			request.getRequestDispatcher("/WEB-INF/view/top.jsp").forward(request, response);
//		} catch (Exception e) {
//			throw new ServletException(e);
//		}
		
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
