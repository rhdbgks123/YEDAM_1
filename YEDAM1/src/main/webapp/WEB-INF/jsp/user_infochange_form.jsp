<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link href="./css/user_infochange_form.css" rel="stylesheet" />
</head>
<body>
	<div class="register-page">
		<div class="register-content" >
			<h2>회원정보 수정</h2>
			<form class="wrapper-box" id="registerForm" name="registerForm"
				action="infochange.do" method="post">

				<ul>
					<li>
						<label for="orgpwd">기존비밀번호<span class="redaccent">*</span></label>
						<input type="password" id="orgpwd" name="orgpwd" required style="width: 350px;">
						<button type="button" id="checkpwd" style="width: 150px; margin: 0;">비밀번호확인</button>
					</li>
	                <li>
	                    <label for="pwd">변경비밀번호<span class="redaccent">*</span></label>
	                    <input  type="password" id="pwd" name ="pwd" required>
	                </li>
	                <li>
	                    <label for="pwdChk">비밀번호 확인<span class="redaccent">*</span></label>
	                    <input type="password" id="pwdChk" name ="pwdChk" required>
	                </li>
					<li>
						<label for="nickname">닉네임<span class="redaccent">*</span></label>
						<input type="text" id="nickname" name="nickname" required>
					</li>
					<li>
						<label for="phone">휴대폰</label> <input type="tel" id="phone" name="phone" placeholder="'-' 빼고 숫자만 입력하세요.">
					</li>
					<li>
						<label for="userEmail">이메일</label> <input type="email" id="userEmail" name="userEmail">
					</li>
					<li>
						<label for="address">주소</label> <input type="text" id="address" name="address" style="width: 400px;">
						<button type="button" id="addressSearch" style="width: 100px; margin: 0;">주소검색</button>
					</li>
					<li>
						<label for="addressdetail">상세주소</label> <input type="text" id="addressdetail" name="addressdetail" style="width: 500px;">
					</li>
					<li>
						<div id="regbutton">
								<button type="submit"
									class="btn btn-submit btn-default pull-right">정보수정</button>
						</div>
					</li>
				</ul>
			</form>
			<div class="outbutton">
				<input type="button" class="btn-error" value="회원탈퇴">
			</div>
		</div>
	</div>
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="js/user_infochnage_form.js"></script>
</body>
</html>