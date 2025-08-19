<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <title>결제</title>
  <style>
    body { margin:0; font-family: system-ui, -apple-system, Segoe UI, Roboto, sans-serif; }
    #payModal{ position:fixed; inset:0; background:rgba(0,0,0,.45); display:flex; align-items:center; justify-content:center; }
    .sheet{ max-width:520px; width:92%; background:#fff; border-radius:12px; padding:16px; }
    .btn{ width:100%; padding:12px; border:none; border-radius:8px; cursor:pointer; }
    .btn.sub{ margin-top:8px; border:1px solid #ddd; background:#fafafa; }
  </style>
  <!-- v2 표준 위젯 -->
  <script src="https://js.tosspayments.com/v2/standard"></script>
</head>
<body>
<div id="payModal">
  <div class="sheet">
    <h4 style="margin:0 0 12px;">결제</h4>
    <div id="payment-method" style="margin-bottom:12px;"></div>
    <div id="agreement" style="margin-bottom:12px;"></div>
    <button id="payNowBtn" class="btn">결제하기</button>
    <button id="closeBtn" class="btn sub">닫기</button>
  </div>
</div>

<script>
  // ===== 서버에서 전달한 값 =====
  const clientKey    = "test_gck_docs_Ovk5rk1EwkEbP0W43n07xlzm"; // 샘플과 동일한 '결제위젯 연동 키(테스트)' 사용
  const customerKey  = "<%=(String)request.getAttribute("customerKey")%>";
  const orderId      = "<%=(String)request.getAttribute("orderNo")%>";
  const amount       = Number("<%=request.getAttribute("amount")%>");
  const orderName    = "<%=(String)request.getAttribute("orderName")%>";
  const customerName = "<%=(String)request.getAttribute("customerName")%>";
  const successUrl   = location.origin + "<%=(String)request.getAttribute("successUrl")%>";
  const failUrl      = location.origin + "<%=(String)request.getAttribute("failUrl")%>";

  // 1) 위젯 초기화
  const tossPayments = TossPayments(clientKey);

  // 회원결제(권장). 비회원 결제는 TossPayments.ANONYMOUS 사용 가능
  const widgets = tossPayments.widgets({ customerKey });

  (async () => {
    // 2) 금액 먼저 세팅
    await widgets.setAmount({ currency: "KRW", value: amount });

    // 3) 결제수단/약관 UI 렌더
    await widgets.renderPaymentMethods({ selector: "#payment-method", variantKey: "DEFAULT" });
    await widgets.renderAgreement({ selector: "#agreement",       variantKey: "AGREEMENT" });

    // 4) 결제 버튼
    document.getElementById('payNowBtn').addEventListener('click', async () => {
      try {
        await widgets.requestPayment({
          orderId,
          orderName,
          successUrl,      // 예: http://localhost:8080/프로젝트/payApiSuccess.do
          failUrl,
          customerName
        });
      } catch (e) {
        console.error(e);
        alert((e.code || "ERROR") + " : " + (e.message || "결제 요청 실패"));
      }
    });

    // 닫기
    document.getElementById('closeBtn').addEventListener('click', () => {
      location.href = "<%=request.getContextPath()%>/myCart.do";
    });
  })();
</script>
</body>
</html>