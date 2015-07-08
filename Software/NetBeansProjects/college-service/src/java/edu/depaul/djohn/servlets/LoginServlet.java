package edu.depaul.djohn.servlets;

import edu.depaul.djohn.sessionbeans.SessionBeanDAOFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        private SessionBeanDAOFactory passwordDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        passwordDao = new SessionBeanDAOFactory();
    }

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doGet(HttpServletRequest request, 
                HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, 
                HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
