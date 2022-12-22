package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DaoFactory;
import dao.MountainDao;
import domain.Mountain;

/**
 * Servlet implementation class ApiServlet
 */
@WebServlet("/api")
public class ApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 山の名前を取得
		String name = request.getParameter("name");
		
		// 山名からエリア名と標高を取得
		try{
			MountainDao mountainDao = DaoFactory.createMountainDao();
			Mountain mountain = mountainDao.findByName(name);
			
			//JSONデータを使用
			response.setContentType("application/json");
			
			//javaオブジェクトをjsonオブジェクトに変換
			ObjectMapper objectMapper = new ObjectMapper();
			String json = objectMapper.writeValueAsString(mountain); 
			
			response.getWriter().println(json);
			
		}catch(Exception e) {
			throw new ServletException(e);
		}
		
		
	}

}
