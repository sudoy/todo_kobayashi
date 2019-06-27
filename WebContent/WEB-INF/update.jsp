<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<jsp:include page="header.jsp"/>

<nav class="navbar navbar-default">
	 <div class="container">
		<h1>Todoリスト</h1>
    <div class="navbar-header">

     </div><!--container -->
    </div><!--navbar-header -->
	</nav>

	<div class="container">

	<div class="alert alert-success alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>完了しました！</strong>
  	<ul>
  		<li>N0.27のTodoを更新しました。</li>

  	</ul>
	</div><!--Alert1-->

		<div class="alert alert-danger alert-dismissible" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <strong>エラーが発生しました！</strong>
  	<ul>
  		<li>題名は必須入力です。</li>
  		<li>題名は100文字以内にして下さい。</li>
  		<li>起源は「YYYY/MM/DD」形式で入力してください。</li>

  	</ul>
	</div><!--Alert2-->

	<h4>更新フォーム</h4>
	<hr>

	<form class="form-horizontal">

	  <div class="form-group">
	    <label for="inputEmail3" class="col-sm-2 control-label">題名</label>
	    <div class="col-sm-10">
	      <input type="email" class="form-control" id="inputEmail3" placeholder="題名" value="テストテスト">
	    </div>
	  </div>

	  <div class="form-group">
	    <label  class="col-sm-2 control-label">詳細</label>
	        <div class="col-sm-10">
      <textarea class="form-control" rows="2" placeholder="詳細">SQLの確認テストの採点と報告書を作成する。</textarea>
    </div>
	  </div>

	  <div class="form-group">
	  <label for="inputEmail3" class="col-sm-2 control-label">重要度</label>
	    <div class="radio col-sm-10">
	      <div class="radio">
		   	<label><input type="radio" name="imporatant" value="★★★" checked>★★★</label><br>
		   	<label><input type="radio" name="imporatant" value="★★">★★</label><br>
			 <label><input type="radio" name="imporatant" value="★">★</label><br>
	      </div><!--radio-->
	    </div>
	  </div>

	    <div class="form-group">
	    <label for="inputEmail3" class="col-sm-2 control-label">期限</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control"  placeholder="期限" value="2015/06/15">
	    </div>
	  </div>


	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
		     <a href="index.html" class="btn btn-default">キャンセル</a>
		     <a href="index.html" class="btn btn-info">更 新</a>

			<div class="col-sm-offset-11 col-sm-5">
    			 <a href="index.html" class="btn btn-danger">削 除</a>
    		</div>
    	</div>
 	</div>



	</form>

	</div><!-- container-->


<jsp:include page="footer.jsp"/>