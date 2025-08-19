/**
 * 
 */

// pay_payments.service.js
const crypto = require('crypto');

const TOSS_SECRET_KEY = process.env.TOSS_SECRET_KEY;
if (!TOSS_SECRET_KEY) {
  throw new Error('TOSS_SECRET_KEY is not set');
}

// Node 18+는 전역 fetch 사용 가능. (Node 16/17이면 node-fetch@2 사용)
async function tossConfirm({ paymentKey, orderId, amount }) {
  const url = 'https://api.tosspayments.com/v1/payments/confirm';

  // Authorization: Basic base64(`${secretKey}:`)
  const basicToken = Buffer.from(`${TOSS_SECRET_KEY}:`).toString('base64');

  const resp = await fetch(url, {
    method: 'POST',
    headers: {
      'Authorization': `Basic ${basicToken}`,
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({ paymentKey, orderId, amount }),
  });

  const json = await resp.json();

  if (!resp.ok) {
    // 토스 측 에러를 그대로 전달해주는 게 디버깅에 좋음
    const err = new Error(json.message || 'Toss confirm failed');
    err.status = resp.status;
    err.details = json;
    throw err;
  }
  return json;
}

exports.confirmPayment = async ({ paymentKey, orderId, amount }) => {
  // (선택) 여기서도 금액/주문 검증 로직 보강 가능
  return await tossConfirm({ paymentKey, orderId, amount });
};