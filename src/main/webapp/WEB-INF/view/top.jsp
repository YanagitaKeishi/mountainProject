<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<title>ヤマノキロク</title>
</head>
<body>
	<header>
		<c:import url="parts/nav.jsp"></c:import>
	</header>
	<div class="container-fluid top nav-top">
		<h1>山に登ろう。</h1>
	</div>
	<script>
	/*$(document).ready(function(){
		let p = 1;
		function changePhoto(){
			if(p ==1){
				$('.top').fadeOut(500,'linear',function(){
					$(this).css('background-image','url("../images/mount03.jpg")');
					$(this).fadeIn(500);
					p++;
				});
			}else if(p == 2){
				$('.top').fadeOut(500,'linear',function(){
					$(this).css('background-image','url("../images/mount04.jpg")');
					$(this).fadeIn(500);
					p++;
				});
			}else{
				$('.top').fadeOut(500,'linear',function(){
					$(this).css('background-image','url("../images/title.jpg")');
					$(this).fadeIn(500);
					p = 1;
					});
				}
			}
			setInterval(changePhoto,5000);
		});*/
	</script>
</body>
</html>
