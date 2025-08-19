<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>결제</title></head>
<body style="margin:0;">
  <div id="payModal" style="position:fixed; inset:0; background:rgba(0,0,0,.45); display:flex;align-items:center;justify-content:center;">
    <div style="max-width:520px;width:92%; background:#fff; border-radius:12px; padding:16px;">
      <h4 style="margin:0 0 12px;">결제</h4>
      <div id="payment-method" style="margin-bottom:12px;"></div>
      <div id="agreement" style="margin-bottom:12px;"></div>
      <button id="payNowBtn" style="width:100%;padding:12px;border:none;border-radius:8px;cursor:pointer;">결제하기</button>
      <button id="closeBtn"  style="width:100%;margin-top:8px;padding:10px;border:1px solid #ddd;border-radius:8px;background:#fafafa;cursor:pointer;">닫기</button>
    </div>
  </div>

  <!-- Toss Payments Widget v1 -->
  <script src="https://js.tosspayments.com/v1/payment-widget"></script>
  <script>
    // 서버에서 전달한 값
    const clientKey   = "test_ck_kYG57Eba3GYZxWB2ezLzrpWDOxmA";
    const customerKey = "<%=(String)session.getAttribute("logId")%>";
    const orderId     = "<%=(String)request.getAttribute("orderNo")%>";
    const amount      = Number("<%=request.getAttribute("amount")%>");
    const orderName   = "<%=(String)request.getAttribute("orderName")%>";
    const customerName= "<%=(String)request.getAttribute("customerName")%>";
    const successUrl  = location.origin + "<%=(String)request.getAttribute("successUrl")%>";
    const failUrl     = location.origin + "<%=(String)request.getAttribute("failUrl")%>";

    const widget = PaymentWidget(clientKey, customerKey);
    widget.renderPaymentMethods('#payment-method', { value: amount });
    widget.renderAgreement('#agreement');

    document.getElementById('payNowBtn').addEventListener('click', async () => {
      try {
        await widget.requestPayment({ orderId, orderName, successUrl, failUrl, customerName, currency: 'KRW' });
      } catch (e) {
        alert('결제 요청에 실패했습니다. 잠시 후 다시 시도해주세요.');
      }
    });

    document.getElementById('closeBtn').addEventListener('click', () => {
      location.href = "<%=request.getContextPath()%>/myCart.do";
    });
  </script>
</body>
</html>