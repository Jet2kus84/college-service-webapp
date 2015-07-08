<%@page import="edu.depaul.djohn.sessionbeans.ICourseSessionBean"%>
<%@page import="edu.depaul.djohn.sessionbeans.CourseSessionBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- import classes -->
<%@ page import="edu.depaul.djohn.entity.Course" %>
<%@ page import="edu.depaul.djohn.service.Crud" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="collegeService.css">
<title>Show Catalog</title>
</head>
<body> <!--id="addRemove"-->
    
    <h2 align="center">Available Courses</h2>
        <table border="1"><!--begin table-->
             <tr>
                 <th>Course Number</th> 
                 <th>Course name</th>
                 <th>Course Category</th>
                 <th>Course Description</th>
                 <th># Of Students</th>
             </tr>
 
	<%
	String previousPage = request.getParameter("page");
        
        ICourseSessionBean bean = new CourseSessionBean();
        for(Course c : bean.findAll(Course.class, "tbCourse")) {
            out.println( 
                    "<tr align=\"center\"><td>" + c.getCourseNumber() + "</td>" +
                    "<td>" + c.getCourseName() + "</td>" +
                    "<td>" + c.getCourseCategory() + "</td>" +
                    "<td align=\"left\">" + c.getCourseDescription() + "</td>" +
                    "<td>" + c.getNumberOfStudentsEnrolled() + "</td>"
            );
        }
	%>
        </table> <!--end table-->
        
	<form action=<%=previousPage%> >
		<input type="submit" value="previous" 
		style="background-color:#c00; color:#fff;">
	</form>
</body>
</html>