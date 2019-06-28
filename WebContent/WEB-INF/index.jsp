<%@ page language="java" contentType="text/html; charset=UTF-8"%>


<jsp:include page="header.jsp" />

<jsp:include page="body.jsp" />


	<table class="table">

		<tr>
			<th>#</th>
			<th>題名</th>
			<th>重要度</th>
			<th>期限</th>
		</tr>

		<tr class="">
			<td>1</td>
			<td class="test"><a href="update.html">テストテスト</a></td>
			<td>★★★</td>
			<td>2015/06/20</td>
		</tr>

		<tr class="">
			<td>2</td>
			<td class="test"><a href="update.html">テストテスト</a></td>
			<td>★</td>
			<td>2015/06/22</td>
		</tr>

		<tr class="">
			<td>3</td>
			<td class="test"><a href="update.html">テストテスト</a></td>
			<td>★★★</td>
			<td>2015/06/20</td>
		</tr>

		<tr class="">
			<td>4</td>
			<td class="test"><a href="update.html">テストテスト</a></td>
			<td>★★</td>
			<td></td>
		</tr>

	</table>

	<a href="entry.html" class="btn btn-info">追 加</a>



<jsp:include page="footer.jsp" />

