<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/studentAppmanagement/URL/css/my-style-sheet.css">
</head>
<body>
<h1 align="center">student management</h1>
<div align="center" >

<form action="addStudentPage">
  <input type="Submit" value="ADD" >
</form>
<table border="1">
<thead>
<tr>
<td>id</td>
<td>name</td>
<td>mobile</td>
<td>country</td>
</tr>
</thead>

<c:forEach var="Student"  items="${Students}">
<tr>
				<td>${Student.id}</td>
				<td>${Student.name}</td>
				<td>${Student.mobile}</td>
				<td>${Student.country}</td>
				<td><a href="/studentAppmanagement/updateStudent?userid=${Student.id}">UPDATE</a></td>
				<td><a href="/studentAppmanagement/deleteStudent?userid=${Student.id}" onclick= "if(!(confirm('Are you sure to Delete?'))) return false">DELETE</a></td>
</tr>


</c:forEach>

</table>
</div>
</body>
</html>