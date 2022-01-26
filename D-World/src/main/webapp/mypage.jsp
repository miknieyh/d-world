<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/top_login.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
		<h1 class="text-center mt-5 mb-5">내 정보</h1>
	</div>

		<div class="d-flex justify-content-center">

			<table class="join mt-3 table">
				<thead class="th1">
					<tr>
						<td colspan="2"></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="p-3 ps-5">아이디</td>
						<td class="col-8">
							

						</td>
					</tr>
					<tr>
						<td colspan ="2" class="p-3 ps-5">
						비밀번호
						</td>
						
					</tr>
					
					<tr>
						<td class="p-3 ps-5">이름</td>
						<td class="col-8"></td>
					</tr>
					<tr>
						<td class="p-3 ps-5">별명</td>
						<td class="col-8"> <a>수정</a> </td>
					</tr>

					
					<tr>
						<td class="p-3 ps-5">생년월일</td>
						<td class="col-8">
							
						</td>
					</tr>
					
					<tr>
						<td class="p-3 ps-5">핸드폰번호</td>
						<td class="col-8">
						<a>수정</a></td>
						</tr>

				</tbody>
			</table>
		</div>

	


<div class="empty3"></div>

	<%@ include file="/footer.jsp"%>
</body>
</html>