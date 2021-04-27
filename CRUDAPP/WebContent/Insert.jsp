<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Data</title>
</head>
<body>
<h1>Insert data</h1>
<table>
<form action="addemp" method="post">
<tr>

<td>
ID :<input type="number" name="id">
</td>
</tr>
<tr>
<td>
Name :<input type="text" name="name">
</td>
</tr>
<tr>
<td>
Last Name:<input type="text" name="last">
</td>
</tr>
<tr>
<td>
Salary :<input type="number" name="salary">
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