<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-euqiv="Content-Type" content="text/html; charset="UTF-8">
<title>SAMPLE 목록</title>
</head>
<body>
<center>
<h1>sample목록</h1>
<table border="1" cellpadding="0" cellspacing="0" width="800">
<tr>
	<th bgcolor="orange" width="60">ID</th>
	<th bgcolor="orange" width="240">TITLE</th>
	<th bgcolor="orange" width="40">Writer</th>
	<th bgcolor="orange" width="60">Date</th>
</tr>

<c:forEach var="sample" items="${sampleList }">
<tr>
	<td align="center"><a href="selectSample.do?id=${sample.id }">${sample.id}</a></td>
	<td>${sample.title}</td>
	<td align="center">${sample.regUser}</td>
	<td align="center">${sample.regDate}</td>
</tr>
</c:forEach>

</table>
<br>
<a href="insertSample.do">sample register</a>
</body>
</html>