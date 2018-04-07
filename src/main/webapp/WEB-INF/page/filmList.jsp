<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>影片列表页</title>
		<link rel="stylesheet" href="${path }/dist/css/bootstrap.min.css" />
		<script type="text/javascript" src="${path }/js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript" src="${path }/dist/js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="${path }/js/layer/layer.js"></script>
		
	</head>
	<body>
		<!--导航开始-->
		<div class="container">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse"
							data-target="#example-navbar-collapse">
							<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
								class="icon-bar"></span> <span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">天悦电影城后台管理系统</a>
					</div>
					<div class="collapse navbar-collapse" id="example-navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#"><span class="text-success">${user.username},你好</span></a></li>
							<!-- <li><a href="#"><span class="badge pull-right">"+count+"</span>在线人数</a></li>
							<li><a href="#"><span class="badge pull-right">"+totalCount+"</span>总访问量</a></li> -->
							<li><a href="${path }/user/login">安全退出</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<!--导航结束-->
		<div class="container">
			<ol class="breadcrumb">
				<li><a href="#">影片信息</a></li>
				<li><a href="#">2017</a></li>
				<li class="active">十月</li>
			</ol>
		</div>
		
		<!--查询开始-->
		<div class="container">
			<div>
				<form action="${path }/back/filmList" class="bs-example bs-example-form" role="form" method="post">
					<div class="row">
						<div class="col-md-3">
							<div class="input-group">
								<input type="hidden" id="uname" name="film.id"> 
								<input type="text" id="filmName" name="film.filmName" value="${filmVo.film.filmName }"  placeholder="影片名称进行模糊查询" class="form-control"> 
								<span class="input-group-btn">
									<button class="btn btn-default" type="button" onclick="queryPage()">查询</button>
								</span>
							</div>
						</div>
						<div class="col-md-4">
							<button class="btn btn-danger" type="button" onclick="delFilms()">删除影片</button>
							<a href="${path }/back/add" class="btn btn-info">添加影片</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!--查询结束-->
		
		<!--列表主体开始-->
		<div id="filmData">
		</div>
		
		
		<!-- 加载页面底部 -->
		<div class="container">
			<div class="row">
				<div class="row text-center">
					<div class="col-md-12">
						<span class="text-info">天智教育&reg; |&nbsp;</span>
						<span class="text-info">天悦在线电影后台系统 |&nbsp;</span>
						<span class="text-info">2015－2020 </span>
					</div>
				</div>
			</div>
		</div>
	</body>
	
	
	<script type="text/javascript">
		//全选/反选
		function checkAllOrNot(){
			for(var i=0;i<$(".cks").length;i++){
				var flag = $(".cks:eq(" + i + ")").prop("checked");
				
				$(".cks:eq(" + i + ")").prop("checked",!flag);
			}
		}
		
		//删除
		function delFilms(){
			//询问框
			layer.confirm('确认删除吗？', {
			  btn: ['必须的','算了吧'] //按钮
			}, function(){
				var ids = "";
				for(var i=0;i<$(".cks:checked").length;i++){
					ids += $(".cks:checked:eq(" + i + ")").val() + ",";//1,2
				}
				ids = ids.substr(0,ids.length-1);
				
				$.ajax({
					url:"${path }/back/filmDel",
					data:{"ids":ids},
					type:"post",
					success:function(msg){
						//判断是否登陆成功
						if(msg == "success"){
							layer.msg("删除成功");
							window.location.href = "${path }/back/filmList";
							return;
						}else{
							return false;
						}
					}
				});
			}, function(){
			  layer.closeAll();
			});
		  }
		
		
		//加载数据 
		$(function(){
			$("#filmData").load("${path }/back/getFilmData");
		})
		
		function queryPage(page){
			var index = layer.load(1, {shade: false});
			$("#filmData").load("${path }/back/getFilmData",buildQuery(page),function(){
				layer.closeAll();
			});
		}
		
		function buildQuery(page){
			var query = {};
			query.page = typeof(page) == "undefined"?1:page;
			query.filmName = $("#filmName").val();
			return query;
		}
	</script>
</html>