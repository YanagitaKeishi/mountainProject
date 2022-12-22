package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.MountainDao;
import domain.Mountain;

/**
 * Servlet implementation class MountainListServlet
 */
@WebServlet("/mountainList")
public class MountainListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String erea = request.getParameter("erea");
		String elevation = request.getParameter("elevation");
			
		try {
			MountainDao mountainDao = DaoFactory.createMountainDao();
			List<Mountain> mountainList = null;
			
			if(erea == null || erea.equals("全エリア")){
				request.setAttribute("selectErea", "全エリア(エリアを選択できます)");
				if( elevation == null|| elevation.equals("erea") ) {
					mountainList = mountainDao.findAll();
				}else {
					mountainList = mountainDao.sortAll(elevation);
				}
			}else {
				// エリアが選択されている場合
				mountainList = mountainDao.findByErea(erea,elevation);
				request.setAttribute("selectErea", erea);
			}
			
			if(elevation == null || elevation.equals("erea")) {
				request.setAttribute("erea",true);
			}else if(elevation.equals("high")) {
				request.setAttribute("high", true);
			}else if(elevation.equals("low")) {
				request.setAttribute("low", true);
			}
			request.setAttribute("mountainList", mountainList);
			request.getRequestDispatcher("/WEB-INF/view/mountainList.jsp")
			.forward(request, response);
		}catch(Exception e){
			throw new ServletException(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
		
		


}
