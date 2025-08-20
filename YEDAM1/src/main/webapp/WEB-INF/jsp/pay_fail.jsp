<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <title></title>
  <style>html,body{margin:0;background:transparent}</style>
</head>
<body>
<script>
(function () {
  var msg = '결제를 완료하지 못했습니다.';
  try {
    window.parent.postMessage(
      { type: 'PAY_FAIL', message: msg },
      window.location.origin
    );
  } catch (e) {}

  // 단독 페이지로 열렸을 때는 장바구니로 폴백 이동
  if (window.top === window.self) {
    location.replace('<%=request.getContextPath()%>/myCart.do');
  }
})();
</script>
</body>
</html>