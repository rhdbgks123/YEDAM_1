/**
 *  내 장바구니 목록 삭제
 */

// x버튼 온클릭
function deleteRowFnc(e) {
	console.log(e);
	let rno = e.target.parentElement.parentElement.children[0].innerText;
	
	
	console.log(rno);
	if (!confirm(`${rno} 번 글을 삭제하겠소?`)) {
		alert('삭제를 취소했소.');
		return;
	}
	// fetch 서버프로그램 호출
	removeReply(rno, successCallback, errorCallback) {
		fetch('removeReply.do?rno=' + rno)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	}
}