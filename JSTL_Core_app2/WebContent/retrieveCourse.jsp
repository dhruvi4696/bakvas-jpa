<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="/header.jsp">
		<c:param name="company" value="iGATE" />
	</c:import>

	<hr />


	<!-- illustrates c:set tag-->
	<c:set value="Course Information" var="cInfo" />
	<h3>
		<c:out value="${cInfo}" />
	</h3>


	<br />
	<c:choose>
		<c:when test="${!empty course}">
			<table border="1">
				<tr>
					<th><c:out value="CourseId" /></th>
					<th><c:out value="CourseName" /></th>
					<th><c:out value="CourseDuration" /></th>
				</tr>

				<tr>
					<td><c:out value="${course.courseId}" /></td>
					<td><c:out value="${course.courseName}" /></td>
					<td><c:out value="${course.courseDuration}" /></td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<h1>Oops...Course Not Found</h1>
		</c:otherwise>
	</c:choose>
	<hr />
	<a href="index.jsp">Go to Home page</a>
</body>
</html>