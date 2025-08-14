/**
 * 
 */

// read-only
const router = require('express').Router();

const controller = require('/js/pay_payments.controller');

router.route('/confirm').get(controller.confirmPayment);

module.exports = router;