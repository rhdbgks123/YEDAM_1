/**
 * server.js
 */

require('dotenv').config();
const express = require('express');
const cors = require('cors');

const paymentsRouter = require('./pay_payments.router'); // 상대경로 중요!

const app = express();
app.use(cors());
app.use(express.json()); // JSON 바디 파싱

// 정적 성공/실패 페이지가 있다면(선택)
// app.use('/sandbox', express.static('public')); // public/success.html, public/fail.html 같은 구조

// 결제 API 라우트 마운트
app.use('/sandbox-dev/api/v1/payments', paymentsRouter);

// 공통 에러 핸들링(선택)
app.use((err, req, res, next) => {
  console.error(err);
  const status = err.status || 500;
  res.status(status).json({
    error: true,
    message: err.message || 'Internal Server Error',
  });
});

const port = process.env.PORT || 3000;
app.listen(port, () => {
  console.log(`Payments server listening on http://localhost:${port}`);
});
