<%-- 
    Document   : processLogin
    Created on : Jun 9, 2015, 8:34:13 PM
    Author     : Deonte Johnson
--%>

<%@page import="edu.depaul.djohn.service.Crud"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="edu.depaul.djohn.sessionbeans.PasswordSessionBean" %>
<%@ page import="edu.depaul.djohn.entity.Password" %>
<%@ page import="edu.depaul.djohn.sessionbeans.ProfessorSessionBean" %>
<%@ page import="edu.depaul.djohn.sessionbeans.AdvisorSessionBean" %>
<%@ page import="edu.depaul.djohn.sessionbeans.StudentSessionBean" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="collegeService.css">
        
        <title>Process Login</title>
    </head>
    <body>
        
        <%
		PasswordSessionBean pwd;
		session = request.getSession();
	
		pwd = (PasswordSessionBean) 
                        session.getAttribute("PasswordSessionBean");
		
   	 	if(pwd == null) {
                    pwd = new PasswordSessionBean();
                    session.setAttribute("PasswordSessionBean", pwd);
                }
   	 	
                //get all available passwords from database
                //pwd.setTable(Crud.getInstance().
                  //      findAll(Password.class, "PASSWORD"));
                
   	 	//reset password check for each login
                for(Password p : pwd.findAll(Password.class, "PASSWORD"))
                    p.setPasswordExcepted(false);
   	 			
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		for(Password p : pwd.findAll(Password.class, "PASSWORD")) {
                    if(p.getUsername().equalsIgnoreCase(username) &&
                            p.getPassword().equalsIgnoreCase(password)) {
				p.setPasswordExcepted(true);
                                break;
                    }
                }
				
		//update session
                session.setAttribute("PasswordSessionBean", pwd);
               
		//redirect user
                for(Password p : pwd.findAll(Password.class, "PASSWORD")) {
                    if(p.getPasswordExcepted() && p.getType()
                            .equalsIgnoreCase("Professor")) {
			p.setActivePassword(username, password);
                    
                        //get the session attribute
                        ProfessorSessionBean professorBean = (ProfessorSessionBean) 
                                session.getAttribute("ProfessorSessionBean");
                        
                        if(professorBean == null) {
                            professorBean = new ProfessorSessionBean();
                            session.setAttribute
                                ("ProfessorSessionBean", professorBean);
                        }
                        //allow user to be redirected to professor page
                        response.sendRedirect("professor.html");
                        return; //prevent IllegalStateException
                    } 
                    else if(p.getPasswordExcepted() && p.getType()
                            .equalsIgnoreCase("Advisor")) {
                        p.setActivePassword(username, password);
                        
                        //get the session attribute
                        AdvisorSessionBean advisorBean = (AdvisorSessionBean) 
                                session.getAttribute("AdvisorSessionBean");
                        
                        if(advisorBean == null) {
                            advisorBean = new AdvisorSessionBean();
                            session.setAttribute
                                ("AdvisorSessionBean", advisorBean);
                        }
                        //allow user to be redirected to professor page
                        response.sendRedirect("admin_add_remove.html");
                        return;//prevent IllegalStateException
                    }
                    else if(p.getPasswordExcepted() && p.getType()
                            .equalsIgnoreCase("Student")) {
                        p.setActivePassword(username, password);
                        
                        //get the session attribute
                        StudentRosterSessionBean studentBean = (StudentRosterSessionBean) 
                                session.getAttribute("StudentRosterSessionBean");
                        
                        if(studentBean == null) {
                            studentBean = new StudentRosterSessionBean();
                            session.setAttribute
                                ("StudentRosterSessionBean", studentBean);
                        }
                        //allow user to be redirected to professor page
                        response.sendRedirect("student.html");
                        return;//prevent IllegalStateException
                    }
                    else {
                        continue;
                    }
                }
	%>
    </body>
</html>
