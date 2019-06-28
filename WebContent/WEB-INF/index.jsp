<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />

<jsp:include page="body.jsp" />


<table class="table">

	<tr>
		<th>#</th>
		<th>題名</th>
		<th>重要度</th>
		<th>期限</th>
	</tr>

	<c:forEach items="${form}" var="f" varStatus="s">

		<tr class="">
			<td>${f.number}</td>
			<td class="test"><a href="update.html">${f.title}</a></td>
			<td>${f.priority}</td>
			<td>${f.deadline}</td>
		</tr>
	</c:forEach>


</table>

<a href="entry.html" class="btn btn-info">追 加</a>



<jsp:include page="footer.jsp" />

