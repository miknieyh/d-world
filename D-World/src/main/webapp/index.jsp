<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/top_logout.jsp"%>	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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

	<div>
		<h1 class="text-center mt-5 mb-5">LOGIN</h1>
	</div>


	<div class="d-flex justify-content-center">
		<form action="loginOk" method="get">
			<table class="join table-borderless">
				<thead>
					<tr>
						<td colspan="3"></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="col-2 pt-5">
						
						<input type="hidden" value="${param.invite}" name="invite">
						</td>
						
						<td class="ps-5  align-middle">아이디</td>
						<td><input type="text" name="userid" class="form-control"
							placeholder="아이디를 입력해주세요." aria-describedby="addon-wrapping"></td>
						<td class="ps-3" rowspan="2">
							<button type="submit"
								class="btn btn-primary bg-black btn-lg h-100">로그인</button>
						</td>
						<td rowspan="2" class="col-2"></td>
					</tr>
					<tr>
						<td></td>
						<td class="ps-5 align-middle">비밀번호</td>
						<td><input type="password" name="passwd" class="form-control"
							placeholder="영문+숫자+특수문자 조합 8~16자리"
							aria-describedby="addon-wrapping"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

<div class="empty3"></div>
<%@ include file="/footer.jsp"%>
</body>
</html>