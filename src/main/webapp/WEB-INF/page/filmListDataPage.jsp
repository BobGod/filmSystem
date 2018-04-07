<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>影片列表页</title>
		<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
	</head>
	<body>
		<!--列表主体开始-->
		
		<div class="container">
			<div class="table-responsive">
				<table class="table table-hover">
					<caption>全部影片信息</caption>
					<thead>
						<tr class="active">
							<th><input type="checkbox" onclick="checkAllOrNot()" /></th>
							<th>影片编号</th>
							<th>影片名称</th>
							<th>导演</th>
							<th>主演</th>
							<th>播放影厅</th>
							<th>播放时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${page.datas }" var="film">
						<tr>
							<td><input type="checkbox" value="${film.id }" class="cks" name="cks" /></td>
							<td>${film.filmNum }</td>
							<td><a href="javascript:;" onclick="showInfo(${film.id })">${film.filmName }</a></td>
							<td>${film.director }</td>
							<td>${film.actor }</td>
							<td>${film.movieHall}</td>
							<td><fmt:formatDate value="${film.playTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>
									<a href="${path }/back/form?id=${film.id}" class="btn btn-warning">修改</a>
									<a href="${path }/back/FilmJpg?id=${film.id}" class="btn btn-warning">上传图集</a>
								</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
	<script type="text/javascript">
	function TiJiao(){  
	        var regPage = /^[1-9]*$/;  
	        var page = $('#page').val();
	        $("#filmData").load("${path }/back/getFilmData",buildQuery(page),function(){
				layer.closeAll();
			});
	    };  

	
	</script>
	
	<div class="container">
			<div class="row text-center">
				<div class="col-md-12">
					<ul class="pagination">
						<li><a href="javascript:;" onclick="queryPage(1)">首页</a></li>
					    <li class="${page.current eq page.first ? 'disabled':'' }"><a href="#" onclick="queryPage(${page.previous})">&laquo;</a></li>
					    <c:forEach begin="1" end="${page.pageNum }" var="pages">
						    <li class="${page.current eq pages ? 'active':'' }"><a href="#" onclick="queryPage(${pages})" >${pages}</a></li>
					    </c:forEach>
					    <li class="${page.current eq page.last ? 'disabled':'' }"><a href="#" onclick="queryPage(${page.next})">&raquo;</a></li>
					    <li><a href="#" style="border: 1px solid #ddd;" onclick="queryPage(${page.pageNum})">尾页</a></li>
					    <li><a style="border: 0px;margin-left: 0px;">当前页${page.current }/${page.pageNum }总页</a></li>
					   <li > 跳转到第 <input id="page"  type="text" size="1" > 页  
                      <button onclick="TiJiao()" class="btn btn-info btn-search" >确定</button></li>  
				    </ul>
				   
				</div>
			</div>
		</div>
	</body>
</html>
