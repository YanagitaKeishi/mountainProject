<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<header>
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top hight nav-bg">
		<div class="container-fluid nav">
			<a href="top" class="h2 nav-title no-color-change">ヤマノキロク</a>
			<button class="navbar-toggler" data-bs-toggle="collapse"
				data-bs-target="#menu">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="menu">
				<ul class="navbar-nav">
					<li class="nav-item"><a href="mountainList" class="nav-link">百名山リスト</a></li>
					<li class="nav-item"><a href="report" class="nav-link">記録する</a></li>
					<li class="nav-item"><a href="readReport" class="nav-link">みんなの記録</a></li>
				</ul>
				<div class="user-box">
						<c:if test="${user == null}">
							<div class="no-user">
								<a href="login" class="btn btn-light nav-btn">ログイン</a>
								<a href="signUp" class="btn btn-secondary nav-btn">新規登録</a>
							</div>
						</c:if>
						<c:if test="${user != null}">
						<ul class="nav-user">
							<li class="nav-item"><a href="#"> <c:out
										value="${user.name}" />さん</a>
								<ul class="panel-inner">
									<li><a href="myInfo" class="panel-item">ユーザー情報</a></li>
									<li><a href="myReport" class="panel-item">My記録</a></li>
									<li><a href="logout" class="panel-item">ログアウト</a></li>
								</ul>
							</li>
						</ul>
						</c:if>
				</div>
			</div>
		</div>
	</nav>
	<script>
		$(function() {
			$('.nav-item').click(function() {
				$(this).children('.panel-inner').stop().slideToggle();
			});
		});
	</script>
</header>
