/**
 * 
 */

// read-only
const service = require('./pay_payments.service');

function badRequest(msg) {
  const e = new Error(msg);
  e.status = 400;
  return e;
}

exports.confirmPayment = async (req, res, next) => {
  try {
    const { paymentKey, orderId, amount } = req.body || {};

    // 1) 기본 검증
    if (!paymentKey) throw badRequest('paymentKey is required');
    if (!orderId) throw badRequest('orderId is required');
    if (amount === undefined || amount === null) throw badRequest('amount is required');

    // 2) 타입/형식 보정
    const numAmount = Number(amount);
    if (!Number.isFinite(numAmount) || numAmount <= 0) {
      throw badRequest('amount must be a positive number');
    }

    // (선택) orderId/amount 서버 저장값과 대조하여 위변조 방지 로직 추가 가능

    // 3) 서비스에 위임(토스 결제 승인 API 호출)
    const data = await service.confirmPayment({
      paymentKey,
      orderId,
      amount: numAmount,
    });

    // 4) 결과 반환
    res.json({ ok: true, data });
  } catch (err) {
    next(err);
  }
};