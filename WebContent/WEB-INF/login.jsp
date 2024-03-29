<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Todoリスト</title>

	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<style type="text/css">
	body { padding-top: 100px; }
	@media ( min-width: 768px ) {
		#banner {
			min-height: 300px;
			border-bottom: none;
		}
	}

	.bs-component {
		position: relative;
	}
	.bs-component .modal {
		position: relative;
		top: auto;
		right: auto;
		left: auto;
		bottom: auto;
		z-index: 1;
		display: block;
	}
	.bs-component .modal-dialog {
		width: 60%;
	}
	.btn-group{
	margin: 7px 0 0 940px

	}
	</style>

	<!--[if lt IE 9]>
		<script src="//oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="//oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<header>
		<div class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<a href="./index.html" class="navbar-brand">Todoリスト</a>
					<div class="btn-group">
					<button type="button" class="btn btn-info dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						ゲスト1 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="login.html">ログアウト</a></li>
					</ul>
				</div>
				</div>
			</div>

		</div>
	</header>

	<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<div class="bs-component">
				<div class="modal">
					<div class="modal-dialog">
						<div class="modal-content">
							<form class="form-horizontal" action="login.html" method="post">
								<div class="modal-header">
									<h4 class="modal-title">ログイン</h4>
								</div>
								<div class="modal-body">
									<div class="alert alert-dismissible alert-danger">
										<button type="button" class="close" data-dismiss="alert">×</button>
										<h4><strong>エラーが発生しました！</strong></h4>
										<ul>
											<li>メールアドレス、またはパスワードが間違っています。</li>
										</ul>
									</div>
									<div class="form-group">
										<label for="title" class="col-md-4 control-label">メールアドレス</label>
										<div class="col-md-7">
											<input type="text" class="form-control" name="email" placeholder="メールアドレス" value="">
										</div>
									</div>
									<div class="form-group">
										<label for="detail" class="col-md-4 control-label">パスワード</label>
										<div class="col-md-7">
											<input type="password" class="form-control" name="password" placeholder="パスワード" value="">
										</div>
									</div>


								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-off"></span> ログイン</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>


</body>
</html>