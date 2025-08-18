/**
 * 
 */

class PageVO {
	
	// 생성자.
	constructor(currPage, totalCnt) {
		this.currPage = currPage; //currPage 필드선언.
		this.totalCnt = totalCnt;
		// start, end 계산.
		this.end = Math.ceil(currPage / 10) * 10; // 10page
		this.start = this.end - 9; // 1page
		
		let realEnd = Math.ceil(totalCnt /5); // if...3page
		this.end = this.end > realEnd ? realEnd : this.end;
		// prev, next 계산.
		this.prev = this.start > 1;
		this.next = this.end < realEnd;
	}
}

const svc = {
	// 목록 ajax 메소드.
		replyList(param={itemCode: 1, page: 1}, successCallback, errorCallback) {			
			fetch('reviewList.do?bno=' + param.itemCode+'&page='+param.page)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
		}
}