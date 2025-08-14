/**
 * todayHot.js
 */

//console.log("실행되나? todayHot.js")
fetch('todayHot.do')
	.then(resolve => resolve.json())
	.then(result => {		
			let listContainer = document.querySelector("#todayHot");
			let text = "";
			
			
		result.forEach((item, index) => {
			//console.log(item);
			
				
			if(index%2 ==0) {
				text +='<div class="row" >';
			}
			    text += `			<div class="col-6">
			                <div class="featured__item">
			                        
									<img src="img/featured/${item.itemImage}" >
			                        <div class="row">
			                        <div class="featured__item__text col-6">
			                            <h6>${item.itemName}</h6>
			                            <i class="fa fa-heart"></i><span>${item.starPoint}</span><i class="fa fa-pencil"></i><span>${item.reviewCnt}</span>
			                            
			                        </div>
			                        <div class="featured__item__text col-6">
			                            <h6>판매수</h6>
			                            <h6>재고</h6>               
			                        </div>                        
			                        </div>
			                        <div class="row">
			                        <div class="col-12">${item.salePrice}원</div>                        
			                        </div>
			                    </div>
			                </div>`;
				if(index%2 == 1 || index == result.length - 1) {
					//console.log("홀수면 작동함")
					text +='</div>';
				}
				
			
		})
		//console.log(text);
			listContainer.insertAdjacentHTML('beforeend', text)
		
	})
	.catch(err => console.error(err))