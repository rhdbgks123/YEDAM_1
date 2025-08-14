/**
 * itemDetailView.js
 */

let detail = document.querySelectorAll('#tagList>a');
let container = document.querySelector('#tagInfo');
console.log(detail);

//상세정보
detail[0].addEventListener('click', function(e) {
	e.preventDefault();
	let text = "";
	fetch('DetailInfo.do')
		.then(resolve => resolve.json())
		.then(result => {		
				
			
			
				container.innerText = 
			
		})
		.catch(err => console.error(err))
});

//리뷰

//문의사항
