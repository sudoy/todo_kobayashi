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

	<c:forEach items="${number}" var="n" varStatus="s">

		<tr class="">
			<td>${number[s.index]}</td>
			<td class="test"><a href="update.html">${title[s.index]}</a></td>
			<td>${priority[s.index]}</td>
			<td>${deadline[s.index]}</td>
		</tr>
	</c:forEach>


</table>

<a href="entry.html" class="btn btn-info">追 加</a>



<jsp:include page="footer.jsp" />

