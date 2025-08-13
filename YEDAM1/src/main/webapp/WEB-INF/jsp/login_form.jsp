<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link href="./css/login_form.css" rel="stylesheet" />
  </head>

  <body>
    <div class="login-page" ng-app="">

      <div class="login-content login-content-signin" ng-hide="showSignIn">
        <div>
          <h2>로그인</h2>
          <form class="wrapper-box" role="form" action="login.do" method="post">
            <ul>
              <li><input type="text" class="form-control form-control-email" placeholder="아이디" name="id" required></li>
              <li><input type="password"  class="form-control form-control-password" placeholder="비밀번호" name="psw"  required></li>
            </ul>
            <!-- <div class="checkbox pull-left">
          <label>
            <input type="checkbox"> Remember me.
          </label>
        </div> -->
            <a class="outer-link pull-left" href="#/forgot">아이디/비밀번호 찾기</a>
            <button type="submit" class="btn btn-submit btn-default pull-right">로그인</button>
            <input type="button" id="signup" class="btn btn-submit btn-default pull-right" value="회원가입"></input>
          </form>
        </div>
      </div>
    </div>
  </body>

  </html>