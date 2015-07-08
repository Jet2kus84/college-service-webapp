package edu.depaul.djohn.servlets;

import edu.depaul.djohn.sessionbeans.SessionBeanDAOFactory;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddStudentServlet
 */
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final SessionBeanDAOFactory courseDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseServlet() {
        super();
        courseDao = new SessionBeanDAOFactory();
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
		
            PrintWriter out = response.getWriter();
	
            //start a session for remember input
            //HttpSession session = request.getSession();
            //courses = (CourseSessionBean) request.getSession().getAttribute("CourseSessionBean");
		
            /*if(courses == null){
        	courses = new CourseSessionBean();
        	request.getSession().setAttribute("CourseSessionBean", courses);
        	System.out.println("Session Bean Created!");
            }*/
        
            //add course to session list
            if(courseDao.getCourseSessionBeanDao().add(
                    request.getParameter("courseName"),
                    request.getParameter("courseNumber"),
                    request.getParameter("courseCategory"),
                    request.getParameter("courseDescription")
                    )) 
                System.out.println("Course added successfully");
                  
        //update session list
        //request.getSession().setAttribute("CourseSessionBean", courses);
  		
            //send response to user
            out.println(
                "<!DOCTYPE html>" +
                "<html>\n" +
                "<head><title>" + "Course added" + "</title>"
                		+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"collegeService.css\">"
                		+ "</head>\n" +
                "<body id=\"successPage\">\n" +
                "<h1 align=\"center\">" + "Course added" + "</h1>\n" +
                "<p>Course has been successfully added: </p>" +
                "Course Has Been added<br>" + 
                "<form action=\"admin_add_remove.html\">" +
                "<input type=\"submit\" value=\"Back\"" + 
                "style=\"background-color:#c00; color:#fff;\">" +
                "</form>" +
                "</body>" +
                "</html>");
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
