<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>影片编辑页面</title>
		<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${path }/css/update.css" />
	</head>
	<body>
		<div class="container">
			<div id="update">
				<form action="${path}/back/saveFilm" method="post"  class="form-horizontal" role="form">
					<fieldset>
						<legend>新增影片信息</legend>
						<div class="form-group">
							<label for="filmNum" class="col-md-3 control-label">影片编号</label>
							<div class="col-md-6">
								<input type="text" name="filmNum" value="${film.filmNum }" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for="filmName" class="col-md-3 control-label">片名</label>
							<div class="col-md-6">
								<input type="text" name="filmName" value="${film.filmName }" class="form-control">
							</div>
						</div>
						
						<div class="form-group">
							<label for="filmYear" class="col-md-3 control-label">年代</label>
							<div class="col-md-6">
								<input type="text" name="filmYear" value="${film.filmYear }" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for="filmCategory" class="col-md-3 control-label">类别</label>
							<div class="col-md-6">
								<input type="text" name="filmCategory" value="${film.filmCategory }" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for="language" class="col-md-3 control-label">语言</label>
							<div class="col-md-6">
								<input type="text" name="language" value="${film.language }" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for="word" class="col-md-3 control-label">字幕</label>
							<div class="col-md-6">
								<input type="text" name="word" value="${film.word }" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for="director" class="col-md-3 control-label">导演</label>
							<div class="col-md-6">
								<input type="text" name="director" value="${film.director }" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for="actor" class="col-md-3 control-label">演员</label>
							<div class="col-md-6">
								<input type="text" name="actor" value="${film.actor }" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for="releaseTime" class="col-md-3 control-label">上映时间</label>
							<div class="col-md-6">
								<input type="text" name="releaseTime" value="${film.releaseTime }" class="form-control" >
							</div>
						</div>
						<div class="form-group">
							<label for="movieHall" class="col-md-3 control-label">播放影厅</label>
							<div class="col-md-6">
								<input type="text" name="movieHall" value="${film.movieHall }" class="form-control">
							</div>
						</div>
								<div class="form-group">
							<label for="playTime" class="col-md-3 control-label">播放时间</label>
							<div class="col-md-6">
								<input type="text" name="playTime" value="${film.playTime }" class="form-control" id="datetimepicker">
							</div>
						</div>
						<div class="form-group">
							<div>
								<div class="form-group has-feedback">
									<label for="summary" class="col-md-3 control-label">简介</label>
									<div class="col-md-6">
										<textarea name="summary" cols="50" rows="3">${film.summary }</textarea>
									</div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-warning">保存</button>
								<button type="reset" class="btn btn-warning">重置</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
		
		<!--引入js-->
		<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript" src="${path }/dist/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${path }/js/moment.js" ></script>
		<script type="text/javascript" src="${path }/js/bootstrap-datetimepicker.min.js" ></script>
		<script type="text/javascript" src="${path }/js/update.js" ></script>
	</body>
</html>
