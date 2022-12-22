 package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import dao.DaoFactory;
import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/signUp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isError = false;

		String name = request.getParameter("name");
		request.setAttribute("name", name);
		if (name.isEmpty() || name == null) {
			request.setAttribute("nameError", "名前が入力されていません");
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
			} else {
				try {
					UserDao userDao = DaoFactory.createUserDao();
					User user = userDao.findByLoginId(loginId);
					if (user != null) {
						request.setAttribute("idError", "このIDは既に使用されています。");
						isError = true;
					}
				} catch (Exception e) {
					throw new ServletException(e);
				}
			}
		}
		String loginPass = null;
		String strloginPass = request.getParameter("login_pass");
		Pattern pattern = Pattern.compile("^[A-Za-z0-9]+$");
		Matcher matcher = pattern.matcher(strloginPass);
		if (!matcher.matches()) {
			request.setAttribute("passError", "半角英数字で入力されていません");
			isError = true;
		} else {
			loginPass = BCrypt.hashpw(strloginPass, BCrypt.gensalt());
		}

		if (isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/signUp.jsp").forward(request, response);
			return;
		}

		User user = new User();
		user.setName(name);
		user.setLoginId(loginId);
		user.setLoginPass(loginPass);

		try {
			UserDao userDao = DaoFactory.createUserDao();
			userDao.insert(user);

			request.getRequestDispatcher("/WEB-INF/view/signUpDone.jsp")
					.forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
