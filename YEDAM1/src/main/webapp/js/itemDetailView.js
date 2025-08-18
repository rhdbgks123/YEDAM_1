/**
 * itemDetailView.js
 */




let list = document.querySelectorAll("#thumbNail>img");
let bigimg = document.querySelector("#thumbNailTarget");
let imsiimg = "";
for (let imgtag of list) {
	imgtag.addEventListener('click', function(e) {		
		imsiimg = bigimg.src;
		bigimg.src = e.target.src;
		e.target.src = imsiimg;
	})
};

//리뷰 리스트 출력

let page = 1; // page 변경.
let selectCnt ; // total No.
// 페이지 로딩시점에 실행.
function showReplyList() {		
	//기존목록을 지우고...
	document.querySelectorAll('div.content>ul>li')//
	.forEach((elem, idx)=> {
		if(idx >= 2) {
			elem.remove();
		}
	});
	//목록출력.
	svc.replyList({itemCode, page},// 첫번째 param.
		result => {
			selectCnt = result.length;
			result.forEach(review => {
				console.log(review);
				// insertadjacenthtml
				let target = document.querySelector('div.content>ul');
				
				let stars = "";
				for(let i =0; i<review.starPoint;i++) {
					stars += `<i class="fa fa-star"></i>`;
				}
				for(let i =0; i<5-review.starPoint;i++) {
					stars += `<i class="fa fa-star-o"></i>`;
				}
				
				
				let images = "";
				let code = String(review.reviewSeq).padStart(4, "0");
				for (let i = 0; i < review.reviewImageNumber; i++) {
				  images += `<img class="col-2 " src="img/review/review_${code}_${i+1}.jpg" alt="이미지 ${i+1}">`;
				}
				
				let today = new Date(review.createDate);
				
				//1번 포맷
				let dateFormat1 = today.getFullYear() + '-' + String(today.getMonth()+1).padStart(2, "0") + '-'
					+ String(today.getDate()).padStart(2, "0") + ' ' + String(today.getHours()).padStart(2, "0") + ':'
					+ String(today.getMinutes()).padStart(2, "0") + ':'
					+ String(today.getSeconds()).padStart(2, "0")

				
				let text = `<li class="product__details__text row">						      
						      <span class="col-2 product__details__rating">
						      ${stars}						      
					          </span>	      
						      <span class="col-6 row">	
							  ${images}					  
							  <span class="col-6 ">${review.reviewdetail}</span>
							  							  
							  </span>
						      <span class="col-1">${review.createdBy}</span>
						      <span class="col-2">${dateFormat1}</span>
					        </li>`;
				target.insertAdjacentHTML('beforeend', text) //position, text
				
				//let li = makeRow(reply);
				//document.querySelector('div.content>ul').appendChild(li);
			})
			// 페이징목록.
			showPagingList();
		}, //두번째 param.
		err => console.error(err) // 세번째 param.
		);
}//end of showReplyList().
showReplyList(); // 최초목록 출력.	

// 페이징목록 출력.
function showPagingList() {	
	
		let totalCnt = selectCnt; // 80
		let paging = new PageVO(page, totalCnt);
		console.log(paging);
		
		// parent요소
		let target = document.querySelector('div.pagination');
		target.innerHTML = '';//기존목록삭제
		// 이전페이지 여부.
		if (paging.prev) {
			let atag = document.createElement('a');
			atag.href = paging.start-1;
			atag.setAttribute('data-page', paging.start-1);
			atag.innerHTML = '&laquo;';
			target.appendChild(atag);
		}
		
		// start ~ end
		for(let p=paging.start; p<=paging.end; p++) {
			let atag = document.createElement('a');
			atag.href = p; //setAttribute('href', p);
			if(p==page) {
				atag.setAttribute('class', 'active');
			}
			atag.setAttribute('data-page', p);
			atag.innerText = p;
		    target.appendChild(atag);			
		}
		// 이후페이지 여부.
		if (paging.next) {
			let atag = document.createElement('a');
			atag.href = paging.end + 1;
			atag.setAttribute('data-page', paging.end + 1);
			atag.innerHTML = '&raquo;';
			target.appendChild(atag);
		}
		// a 태그에 클릭이벤트.
		addEvent();
	

}// end of showPagingList();

// 페이징 링크에 클릭이벤트.
function addEvent() {	
document.querySelectorAll('div.footerr>div.pagination>a')//
.forEach(atag => {
	atag.addEventListener('click', e => {
		e.preventDefault(); //기본기능을 차단.		
		page = e.target.dataset.page; // data-page = dataset.page
		console.log(page);
		// 목록그려주기.
		showReplyList();
	  })
  })
}//end of addEvent