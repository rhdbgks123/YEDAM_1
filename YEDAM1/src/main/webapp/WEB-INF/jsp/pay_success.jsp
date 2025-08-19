<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>결제가 완료되었습니다.</h2>
<p>주문번호: ${orderNo}</p>
<details>
  <summary>응답 전문 보기</summary>
  <pre style="white-space:pre-wrap;">${paymentJson}</pre>
</details>
<a href="myOrderDetail.do">주문내역 보기</a>