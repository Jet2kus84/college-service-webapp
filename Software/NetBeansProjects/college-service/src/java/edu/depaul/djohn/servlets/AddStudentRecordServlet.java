package edu.depaul.djohn.servlets;

import edu.depaul.djohn.sessionbeans.SessionBeanDAOFactory;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.depaul.djohn.sessionbeans.studentbean.StudentSessionBeanDao;
import edu.depaul.djohn.sessionbeans.studentbean.StudentSessionBeanImpl;


/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudent")
public class AddStudentRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final SessionBeanDAOFactory studentDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentRecordServlet() {
        super();
       studentDao = new SessionBeanDAOFactory();
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
		
        //studentSessionBean = (StudentSessionBean) request.getSession().getAttribute("StudentSessionBean");
		
        //if(studentSessionBean == null){
        //	studentSessionBean = new StudentSessionBean();
          //request.getSession().setAttribute("StudentSessionBean", studentSessionBean);
        //}	
		
        //add student to session list
        if(studentDao.getStudentSessionBeanDao().add(
                request.getParameter("first_name"),
                request.getParameter("last_name"),
                request.getParameter("middle_initial"),
                request.getParameter("date_of_birth"),
                request.getParameter("academic_year"))) {
            System.out.println("\n Student added successfully");
        }
        
        //update session list
        //request.getSession().setAttribute("StudentSessionBean", studentSessionBean);
        
        //send a response
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
