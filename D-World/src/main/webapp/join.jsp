<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/top_logout.jsp"%>

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
		<h1 class="text-center mt-5 mb-5">JOIN MEMBER</h1>
	</div>
	<div class="justify-content-center d-flex">
		<img src="resources/img/join.jpg" alt="회원가입이미지">
	</div>
	<form action="joinOk" method="get">
		<div class="d-flex justify-content-center">

			<table class="join mt-3 table">
				<thead class="th1">
					<tr>
						<td colspan="2"></small></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="p-3 ps-5">아이디</td>
						<td class="col-8">
							<div class="d-flex">
								<input type="text" id="idbox" name="userid"
									class="form-control w-50" placeholder="아이디를 입력해주세요."
									aria-describedby="addon-wrapping"> <small id="text1"
									class="info ms-3"></small>
							</div>

						</td>
					</tr>
					<tr>
						<td class="p-3 ps-5">비밀번호</td>
						<td class="col-8">
							<div class="d-flex">
								<input type="password" id="pwbox" name="passwd"
									class="form-control w-50" placeholder="영문+숫자+특수문자 조합 8~16자리"
									aria-describedby="addon-wrapping"> <small id="text2"
									class="info ms-3"></small>
							</div>
						</td>
					</tr>
					<tr>
						<td class="p-3 ps-5">비밀번호 확인</td>
						<td class="col-8"><input type="password" id="pwbox2"
							class="form-control w-50" aria-describedby="addon-wrapping">
						</td>
					</tr>
					<tr>
						<td class="p-3 ps-5">이름</td>
						<td class="col-8"><input type="text" name="name"
							class="form-control w-50" placeholder="ex)홍길동"
							aria-describedby="addon-wrapping"></td>
					</tr>
					<tr>
						<td class="p-3 ps-5">별명</td>
						<td class="col-8"><input type="text" name="nickname"
							class="form-control w-50" placeholder="ex)별라"
							aria-describedby="addon-wrapping"></td>
					</tr>

					<script>
						$(document).ready(function() {

							$("#idbox").keyup(function() {
								var content = $(this).val();
								if ($("#idbox").val() == "") {
									$("#text1").text("아이디를 입력해 주세요");
								} else {
									$("#text1").text("");
								}
							})

							$("#pwbox").keyup(function() {
								var content = $(this).val();
								if ($("#pwbox").val() == "") {
									$("#text2").text("비밀번호를 입력해 주세요");
								} else {
									$("#text2").text("");
								}

							})
							$("#pwbox2").keyup(function() {
								var content = $(this).val();
								if ($("#pwbox").val() == $("#pwbox2").val()) {
									$("#text2").text("사용 가능합니다.");
								} else {
									$("#text2").text("비밀번호 정보가 일치하지 않습니다.");
								}

							})

						})
					</script>
					<tr>
						<td class="p-3 ps-5" rowspan="2">생년월일</td>
						<td class="col-8">
							<div class="d-flex">
								<div class="d-flex w-50">
									<div class="input-group mb-3">
										<select class="form-select" id="year" name="birthyear">
										</select>
									</div>
									<div class="input-group mb-3">
										<select class="form-select" id="month" name="birthmonth">
										</select>
									</div>
									<div class="input-group mb-3">
										<select class="form-select" id="day" name="birthday">

										</select>

										<script>
											$(document).ready(function() {
												setDateBox();
											});

											function setDateBox() {
												var dt = new Date();
												var year = "";
												var com_year = dt.getFullYear();

												$("#year")
														.append(
																"<option selected>년도</option>");
												
												for (var y = (com_year - 50); y <= com_year + 1; y++) {
													$("#year")
															.append(
																	"<option value='"+y+"'>"
																			+ y
																			+ "년</option>");
												}
												;

												a = 0;

												$("#month")
														.append(
																"<option selected>월</option>");
												for (var i = 1; i <= 12; i++) {
													
														$("#month").append(
																	"<option value='"+i+"'>"
																			+ i
																			+ "월</option>");
													
												}

												$("#day")
														.append(
																"<option selected>일</option>");
												for (var i = 1; i <= 31; i++) {
													$("#day")
															.append(
																	"<option value='"+i+"'>"
																			+ i
																			+ "일</option>");
												}

											};
										</script>

									</div>
								</div>
						</td>
					</tr>
					<tr>
						<td><small class="info">생년월일을 정확히 입력해주세요.</small></td>
					</tr>
					<tr>
						<td class="p-3 ps-5">핸드폰번호</td>
						<td class="col-8"><script>
							function inputPhoneNumber(obj) {
								var number = obj.value.replace(/[^0-9]/g, "");
								var phone = "";

								if (number.length < 4) {
									return number;
								} else if (number.length < 7) {
									phone += number.substr(0, 3);
									phone += "-";
									phone += number.substr(3);
								} else if (number.length < 11) {
									phone += number.substr(0, 3);
									phone += "-";
									phone += number.substr(3, 3);
									phone += "-";
									phone += number.substr(6);
								} else {
									phone += number.substr(0, 3);
									phone += "-";
									phone += number.substr(3, 4);
									phone += "-";
									phone += number.substr(7);
								}
								obj.value = phone;
							}
						</script> <input type="text" name="phone" class="form-control w-50"
							onKeyup="inputPhoneNumber(this);" maxlength="13" /></td>
					</tr>

				</tbody>
			</table>
		</div>

		<div class="d-flex justify-content-center mt-3">
			<a href="index.jsp"><button type="button"
					class="btn btn-secondary btn-lg">취소</button></a>
			<div class="empty"></div>
			<button type="submit" class="btn btn-primary bg-black btn-lg">확인</button>
		</div>
	</form>


<div class="empty3"></div>

	<%@ include file="/footer.jsp"%>
</body>
</html>