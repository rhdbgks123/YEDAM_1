<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
    <link href="./css/register_user_form.css" rel="stylesheet" />
</head>
<body>
<div class="register-page">
  <div class="register-content" ng-hide="showSignIn">
    <h2>회원가입</h2>
    <form class="wrapper-box" id = "registerForm" name="registerForm" action="registUser.do" method="post">

            <ul>
                <li>
                    <label for="userId">아이디<span class="redaccent">*</span></label>
                    <input type="text" id="userId" name="userId" required style="width: 400px;">
                    <button type="button" id="checkId" style="width: 100px; margin: 0;">중복확인</button>
                </li>
                <li>
                    <label for="pwd">비밀번호<span class="redaccent">*</span></label>
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
                    <label for="userName">이름<span class="redaccent">*</span></label>
                    <input type="text" id="userName" name="userName" required>
                </li>
                <li>
                    <label for="birth">주민번호<span class="redaccent">*</span></label>
                    <input class="birth" type="text" id="birth" name="birth" required >
                    -
                    <input style="width: 250px;" type="password" id="identi" name="identi" required >
                </li>
                <li>
                    <label for="phone">휴대폰</label>
                    <input type="tel" id="phone" name="phone" placeholder="'-' 빼고 숫자만 입력하세요.">
                </li>
                <li>
                    <label for="userEmail">이메일</label>
                    <input type="email" id="userEmail" name="userEmail">
                </li>
                <li>
                    <label for="address">주소</label>
                    <input type="text" id="address" name="address" style="width: 400px;">
                    <button type="button" id="addressSearch" style="width: 100px; margin: 0;">주소검색</button>
                </li>
                <li>
                    <label for="addressdetail">상세주소</label>
                    <input type="text" id="addressdetail" name="addressdetail" style="width: 500px;">
                </li>
                <div id="regbutton">
                    <li>
                        <button type="submit" class="btn btn-submit btn-default pull-right">회원가입</button>
                    </li>
                </div>
            </ul>
    </form>
    </div>
</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="js/register_user_form.js"></script>
</body>
</html>