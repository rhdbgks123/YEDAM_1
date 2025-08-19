/**
 * 
 */

// read-only
const router = require('express').Router();

const controller = require('./pay_payments.controller');

router.post('/confirm', controller.confirmPayment);

module.exports = router;