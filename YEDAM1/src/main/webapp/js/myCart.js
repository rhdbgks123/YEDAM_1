/**
 *  myCart 내 장바구니 
 */

document.addEventListener('DOMContentLoaded', function() {
	// 콤마/원 제거
	function toNumber(str) {
		if (!str) return 0;
		return Number(String(str).replace(/[^0-9.-]/g, '')) || 0;
	}
	function formatNumber(num) {
		return String(num).replace(/\B(?=(\d{3})+(?!\d))/g, ',');
	}

	// 상품 별 수량에 따른 총금액 계산
	function updateRowTotal(row) {
		let price = toNumber(row.querySelector('.itemPrice').textContent);
		let qtyInput = row.querySelector('input[type="number"]');
		let qty = Number(qtyInput.value);

		let total = price * qty;
		row.querySelector('.itemTotal').textContent = formatNumber(total) + '원';
	}

	// 선택된 상품들의 총 금액
	let deliveryPrice = 0;
	function updateSelectedTotal() {
		let sum = 0;
		let checked = document.querySelectorAll('input[name="selectItem"]:checked')
		checked.forEach(function(chk) {
			const row = chk.closest('tr');
			sum += toNumber(row.querySelector('.itemTotal').textContent);
		});
		document.querySelector('#selectedItemTotal').textContent = formatNumber(sum) + '원';

		if (checked.length == 0) {
			deliveryPrice = 0;
		} else {
			deliveryPrice = sum < 5000000 ? 3000 : 0;
			document.querySelector('#deliveryPrice').innerText = deliveryPrice + '원';
		}

		document.querySelector('#orderTotal').innerText = formatNumber(deliveryPrice + sum) + '원';


	}

	// 양 옆의 버튼 눌러도 바뀜
	document.addEventListener('click', (e) => {
		const btn = e.target.closest('.qtybtn');
		if (!btn) return;

		const tr = btn.closest('tr');
		const input = tr?.querySelector('.pro-qty input[type="number"]');
		if (!tr || !input) return;

		setTimeout(() => {
			let v = parseInt(input.value, 10);
			const min = +input.min || 1;
			if (isNaN(v) || v < min) { v = min; input.value = v; };

			updateRowTotal(tr);
			updateSelectedTotal();
		}, 0);
	});

	// 수량 변동 시
	document.querySelectorAll('input[type="number"]').forEach(function(input) {
		input.addEventListener('input', function() {
			const row = input.closest('tr');
			updateRowTotal(row);
			updateSelectedTotal();
		});
		input.addEventListener('change', function() {
			const row = input.closest('tr');
			updateRowTotal(row);
			updateSelectedTotal();
		});
	});

	// 체크박스 변동 시
	document.querySelectorAll('input[name="selectItem"]').forEach(function(chk) {
		chk.addEventListener('change', function() {
			updateSelectedTotal();
		});
	});

	let itemChecks = Array.from(document.querySelectorAll('input[name="selectItem"]'));
	let checkAll = document.querySelector('#checkAll');


	itemChecks.forEach(chk => { chk.checked = true; });
	if (checkAll) checkAll.checked = itemChecks.length > 0;


	if (typeof updateSelectedTotal == 'function') updateSelectedTotal();

	
	itemChecks.forEach(chk => {
		chk.addEventListener('change', () => {
			let allChecked = itemChecks.length > 0 && itemChecks.every(i => i.checked);
			if (checkAll) checkAll.checked = allChecked;
			if (typeof updateSelectedTotal === 'function') updateSelectedTotal();
		});
	});

	// 모두 체크
	if (checkAll) {
		checkAll.addEventListener('change', () => {
			let turnOn = checkAll.checked;
			itemChecks.forEach(i => { i.checked = turnOn; });
			if (typeof updateSelectedTotal === 'function') updateSelectedTotal();
		});
	}

	// 페이지 처음 로드 시
	document.querySelectorAll('tbody tr').forEach(function(row) {
		updateRowTotal(row);
		updateSelectedTotal();
	});
	
	// 결제하기 컨트롤 방식
	document.querySelector('.primary-btn').addEventListener('click', function(){
		let selected = document.querySelectorAll('input[name="selectItem"]:checked');
		
		if(selected.length == 0){
			alert('상품을 선택하세요');
			return;
		}
		
		document.querySelector('#cartForm').submit();
		
	})
	
});