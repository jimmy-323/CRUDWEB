<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

<a href="add">add</a>
<table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Last Name</th>
                <th>Salary</th>
                
            </tr>
            <c:forEach var="emp" items="${list}">
                <tr>
                    <td><c:out value="${emp.id}" /></td>
                    <td><c:out value="${emp.name}" /></td>
                    <td><c:out value="${emp.last}" /></td>
                    <td><c:out value="${emp.salary}" /></td>
                    <td>
                        <a href="edit?id=<c:out value='${emp.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${emp.id}'/>">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>