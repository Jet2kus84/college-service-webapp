package edu.depaul.djohn.servlets;

import edu.depaul.djohn.entity.Course;
import edu.depaul.djohn.sessionbeans.SessionBeanDAOFactory;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveCourseServlet
 */
@WebServlet("/RemoveCourse")
public class RemoveCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionBeanDAOFactory courseDao;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCourseServlet() {
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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//get user response
		String id = request.getParameter("course_id");
		
                //get the current session
		//course = (CourseSessionBean) request.getSession().getAttribute("CourseSessionBean");
		
		//hold course category string
		String s = null;
		
		//get string length to count indexes
		int length = id.length();
		
		//hold course number
		int value = 0;
		
		/**
		 * 	Search the id string for course number
		 * 	use course number to find course in database
		 * 	use course category and number to find course
		 * 	in session list
		 */
		
		for(int i = 0; i < length; i++) {
			try {
				if(Integer.parseInt(id.substring(i)) >= 0) {
					
					//retrieve course number from string
					value = Integer.parseInt(id.substring(i, length));
					
					//retrieve course category from string
					s = id.substring(0, i);
					break;
				}
			} catch(NumberFormatException e) { continue; }
		}
	
		try {
			//remove from database
			courseDao.getCourseSessionBeanDao()
                                .remove(Course.class, String.valueOf(value));
			
			//send response to user
			out.println(
					"<!DOCTYPE html>" +
	                "<html>\n" +
	                "<head><title>" + "Course remove" + "</title>"
	                		+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"collegeService.css\">"
	                		+ "</head>\n" +
	                "<body id=\"successPage\">\n" +
	                "<h1 align=\"center\">" + "Course removed" + "</h1>\n" +
	                "<p>Course has been successfully removed: </p>" +
	                "Identifier String: " + s + "<br>" +
	                "Identifier Number: " + value + "<br>" +
	                "Actual Identifier: " + s+value + "<br>" +
	                "Course Has Been Removed<br>" + 
	                "<form action=\"admin_add_remove.html\">" +
	                "<input type=\"submit\" value=\"Back\"" + 
	                "style=\"background-color:#c00; color:#fff;\">" +
	                "</form>");
			
		} catch(NullPointerException e) {
			//send error response
			out.println(
					"<!DOCTYPE html>" +
	                "<html>\n" +
	                "<head><title>" + "404 - Error" + "</title>"
	                		+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"collegeService.css\">"
	                		+ "</head>\n" +
	                "<body id=\"errorPage\">\n" +
	                "<h1 align=\"center\">" + "ERROR" + "</h1>\n" +
	                "<p><label>Message:</label> Course " + s+value + " does not exist" +
	                "</p><br>" +
	                "<form action=\"admin_add_remove.html\">" +
	                "<input type=\"submit\" value=\"Back\"" + 
	                "style=\"background-color:#c00; color:#fff;\">" +
	                "</form>");
		}

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
