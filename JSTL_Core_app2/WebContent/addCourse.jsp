<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Enter Employee Details</h1>

<form action="CourseServlet?op=1" method="post">
<table>
  <tr><td>Course ID</td><td><input type="text" name="id"/></td></tr>
  <tr><td>Course Name</td><td><input type="text" name="name"/></td></tr>
  <tr><td>Course duration</td><td><input type="text" name="dur"/></td></tr>
  <tr><td colspan="2"><input type="submit" value="Ok"/></td></tr>
</table>
</form>

</body>
</html>