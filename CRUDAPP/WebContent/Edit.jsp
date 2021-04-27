<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Data</title>
</head>
<body>
<c:out value='${emp}'></c:out>
<h1>Update Data</h1>
<table>
<form action="updatemp" method="post">
<tr>

<td>
ID :<input type="number" name="id" value="<c:out value='${emp.id}'></c:out>">
</td>
</tr>
<tr>
<td>
Name :<input type="text" name="name" value="<c:out value='${emp.name}'></c:out>" >
</td>
</tr>
<tr>
<td>
Last Name:<input type="text" name="last" value="<c:out value='${emp.last}'></c:out>">
</td>
</tr>
<tr>
<td>
Salary :<input type="number" name="salary" value="<c:out value='${emp.salary}'></c:out>">
</td>
</tr>
<tr>
<td>
<input type="submit">
</td>
</tr>
</table>
</form>
</body>
</html>