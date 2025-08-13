/**
 *  myCart 내 장바구니 
 */

// itemTotal 상품 별 수량에 따른 총 가격

document.querySelectorAll('<input[type="number"]').forEach(chk => {
	chk.addEventListener('change', updateQty);
});

function updateQty() {
document.querySelectorAll('.itemTotal').forEach(span => {
	let price = document.querySelectorAll('.itemPrice').textContent;
	let qty = Number(document.querySelectorAll('.pro-qty input[type="number"]').value);
	let total = price * qty;
	document.querySelectorAll('.itemTotal').innerHTML = total + "원";
})
}

updateQty();


// 선택한 상품들의 총 가격
document.querySelectorAll('input[name="selectItem"]').forEach(chk => {
	chk.addEventListener('change', updateTotal);
});

function updateTotal() {
	let selectedTotal = 0;
	document.querySelectorAll('input[name="selectItem"]:checked').forEach(chk => {
		selectedTotal += document.querySelector('.itemTotal').textContent;
	});
	document.querySelector('#selectedItemTotal').innerHTML = total + "원";

}