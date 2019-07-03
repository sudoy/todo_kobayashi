<%@ page language="java" contentType="text/html; charset=UTF-8"%>


<jsp:include page="header.jsp" />

<jsp:include page="body.jsp" />

	<h4>更新フォーム</h4>
	<hr>

	<form class="form-horizontal" action="update.html" method="post">

		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">題名</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="title" value="${form.title}" id="inputEmail3"
					placeholder="題名" value="">
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">詳細</label>
			<div class="col-sm-10">
				<textarea class="form-control" rows="2" name="detail" placeholder="詳細">${form.detail}</textarea>
			</div>
		</div>

		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">重要度</label>
			<div class="radio col-sm-10">
				<div class="radio">
					<label><input type="radio" name="priority" value="${form.priority}"
						checked>★★★</label><br> <label><input type="radio"
						name="priority" value="${form.priority}">★★</label><br> <label><input
						type="radio" name="priority" value="${form.priority}">★</label><br>
				</div>
				<!--radio-->
			</div>
		</div>

		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">期限</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="deadline" placeholder="期限"
					value="${form.deadline}">
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<a href="index.html" class="btn btn-default">キャンセル</a>
			    <input class="btn btn-info" type="submit" name="button" value="更新">

				<div class="col-sm-offset-11 col-sm-5">
					<a href="index.html" class="btn btn-danger">削 除</a>
				</div>
			</div>
		</div>



	</form>



<jsp:include page="footer.jsp" />