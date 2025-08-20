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
  try {
    // 결제 성공을 부모(장바구니)로 통지 → 부모가 모달 닫고 후처리
    window.parent.postMessage(
      { type: 'PAY_SUCCESS', orderNo: '<c:out value="${orderNo}"/>' },
      window.location.origin
    );
  } catch (e) {}

  // 혹시 iframe이 아닌 단독 페이지로 열렸다면 페이지 이동(폴백)
  if (window.top === window.self) {
    location.replace('<%=request.getContextPath()%>/myOrderDetail.do');
  }
})();
</script>
</body>
</html>