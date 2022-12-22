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
<title>記録する</title>
</head>
<body>
<div class="report-main">
<c:import url="parts/nav.jsp"></c:import> 
	<h1 class="text-center">記録する</h1>
	<div class="container report">
	   <div class="report-box">
			<div class="mt-2">
				<form action="" method="post">
					<div class="report-form">
						<label for="date" class="col-form-label">日付</label>
						<div class="">
							<input class="form-control mt-2" type="date" id="date"
								name="date">
						</div>
					</div>
					<div class="report-form">
						<label for="name" class="col-form-label">山名</label>
						<div class="">
							<input class="form-control mt-2" type="text" id="name"
								name="name" value="<c:out value="${mountain.name}" />">
						</div>
					</div>
					<div class="report-form">
						<label for="area" class="col-form-label">エリア</label>
						<div class="">
							<input class="form-control mt-2" type="text" id="area"
								name="erea" value="<c:out value="${mountain.erea}" />">
						</div>
					</div>
					<div class="report-form">
						<label for="elevation" class="col-form-label">標高</label>
						<div class="">
							<input class="form-control mt-2" type="number" id="elevation"
								min="0" max="4000" name="elevation"  value="<c:out value="${mountain.elevation}" />">
						</div>
					</div>
					<div class="report-form">
						<label for="note" class="col-form-label">コメント</label>
						<div class="">
							<textarea class="form-control mt-2" id="" cols="30" rows="10"
								id="note" name="note"></textarea>
						</div>
					</div>
					<div class="report-btn">
						<input type="submit" class="btn btn-primary" id="btn">
						<a href="top" class="btn btn-secondary">キャンセル</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
$('#btn').click(function(){
	alert('記録しました。')			
});


$('#name').change(function() {
	const input = $(this).val();
	
	$.ajax({
		url: 'http://localhost:8080/MyProject01/api?name=' + input,
		type:'GET',
		dataType:'JSON'
	})
	.done(function(res) {
		console.log(res);
		// エリアと標高の入力欄にセット
		$('#area').val(res.erea);
		$('#elevation').val(res.elevation);
	})
	.fail(function() {
		console.log('接続失敗')
	});
});


	
</script>
</body>
</html>
