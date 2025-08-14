<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
    <link href="./css/find_user_form.css" rel="stylesheet" />
</head>
<body>
<div class="register-page">
  <div class="register-content" ng-hide="showSignIn">
    <h2>아이디/비밀번호 찾기</h2>
    <form class="wrapper-box" id = "findUserForm" name="findUserForm" action="sendMailUserInfo.do" method="post">

            <ul>
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
                    <label for="userId">이메일<span class="redaccent">*</span></label>
                    <input type="email" id="email" name="email" required style="width: 350px;">
                    <button type="button" id="sendmail" name="sendmail"  style="width: 150px; margin: 0;">인증번호받기</button>
                </li>
                <li>
                    <label for="userId">인증번호<span class="redaccent">*</span></label>
                    <input type="text" id="signkey" name="signkey" required style="width: 400px;">
                    <button type="button" id="signcheck" name="signcheck"style="width: 100px; margin: 0;">인증</button>
                </li>
                <div id="regbutton">
                    <li>
                        <button type="submit" class="btn btn-submit btn-default pull-right">ID/PW 찾기</button>
                    </li>
                </div>
            </ul>
    </form>
    </div>
</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="js/find_user_form.js"></script>
</body>
</html>