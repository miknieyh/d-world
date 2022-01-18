<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/top_login.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="style.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container"
		style="height: 100%; background-color: WhiteSmoke;">
		<div class="row">
			<div class="col-8" style="background-color: white;">
			<div>
		<h1 class="text-center mt-5 mb-5">SELECT GROUP</h1>
	</div>
				<table class="table table-sm">
						<thead class="table-success">
							<tr>
								<td class="text-center"></td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<div class="d-grid gap-2">
										<button class="btn btn-success" type="button">그룹만들기</button>
									</div>
								</td>
							</tr>
						
								<tr>
									<td>
									<div class="d-grid gap-2">
									<button class="btn btn-outline-success" type="button">그룹선택</button>
									</div>
									</td>
								</tr>

						</tbody>
					</table>

			<div class="empty3"></div>


			</div>
			<div class="col-4">
				<div class="d-flex ms-3 " style="height: 150px; width: 100%;">
					<div class="align-self-center">
						<img alt="프로필 이미지" src="resources/img/profile.png">
					</div>
					<div class="align-self-center ms-3">
						<small>${m.userid}</small> <br>${m.name}<br> <b>${m.nickname}</b>
					</div>
				</div>


			</div>
		</div>
	</div>
	<%@ include file="/footer.jsp"%>
</body>
</html>