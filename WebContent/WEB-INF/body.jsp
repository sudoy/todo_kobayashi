<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<nav class="navbar navbar-default">
		<div class="container">
			<h1>Todoリスト</h1>
			<div class="navbar-header"></div>
			<!--container -->
		</div>
		<!--navbar-header -->
	</nav>

<div class="container">

	<div class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>完了しました！</strong>
		<ul>
			<li>N0.27のTodoを更新しました。</li>

		</ul>
	</div>
	<!--Alert1-->

	<c:if test="${error != null && !error.equals('')}">


	<div class="alert alert-danger alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>

		<strong>エラーが発生しました！</strong>

		<c:forEach var="e" items="${error}" varStatus="s" >
		<ul>
			<li>${e}</li>

		</ul>
		</c:forEach>



<!-- 		<p>題名は100文字以内にして下さい。</p>
			<p>期限は「YYYY/MM/DD」形式で入力してください。</p>
-->

	</div>
	</c:if>



	<!--Alert2-->