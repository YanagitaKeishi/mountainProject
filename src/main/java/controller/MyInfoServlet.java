package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class MyInfoServlet
 */
@WebServlet("/myInfo")
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/view/myInfo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userLoginId = (User) session.getAttribute("user");
		boolean isError  = false;
		String strId = request.getParameter("id");
		User user = new User();
		
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		if(name.isEmpty()) {
			request.setAttribute("nameError", "名前が未入力です");
			isError = true;
		}
		
		String loginId = request.getParameter("login_id");// 既にIdが使われている場合、IdとPassは半角英数字かどうか
		request.setAttribute("loginId", loginId);
		if (loginId == null || loginId.isEmpty()) {
			request.setAttribute("idError", "IDが入力されていません");
			isError = true;
		} else {
			Pattern pattern = Pattern.compile("^[0-9a-zA-Z]*$");
			Matcher matcher = pattern.matcher(loginId);
			if (!matcher.matches()) {
				request.setAttribute("idError", "半角英数字で入力されていません");
				isError = true;
			} else if(!loginId.equals( userLoginId.getLoginId())) {
				try {
					UserDao userDao = DaoFactory.createUserDao();
					User userId = userDao.findByLoginId(loginId);
					if (userId != null) {
						request.setAttribute("loginId", loginId);
						request.setAttribute("idError", "このIDは既に使用されています。");
						isError = true;
					}
				} catch(Exception e) {
					throw new ServletException(e);
					}
				}
			}
		if(isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/myInfo.jsp")
					.forward(request, response);
			return;
		}
		
		
		try {
			Integer id = Integer.parseInt(strId);
			user.setId(id);
			user.setName(name);
			user.setLoginId(loginId);
			UserDao userDao = DaoFactory.createUserDao();
			userDao.update(user);
			session.removeAttribute("user");
			user = userDao.findById(id);
			session.setAttribute("user", user);
			
		}catch(Exception e) {
			throw new ServletException (e);
		}
		
		request.setAttribute("info", true);
		request.getRequestDispatcher("/WEB-INF/view/myInfo.jsp")
			.forward(request, response);
	}

}
