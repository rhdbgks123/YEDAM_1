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
			    text += `     <div class="col-6" style="padding-left:15px; padding-right:0px;">
			                    <div class="featured__item" style="padding:15px; margin-bottom:15px; border:1px solid #f5f5f5; border-radius: 15px;">
			                        
									<a href="itemDetailView.do?itemCode=${item.itemCode }"><img style=" width: 189px; height: 189px; " src="img/featured/${item.itemImage}" ></a>
			                        <div class="row">
			                          <div class="featured__item__text col-12">
			                            <h6>${item.itemName}</h6>
			                            <h6>${item.price}원</h6>               
			                            <i class="fa fa-heart"></i><span>${item.reviewStarPointAvg}&emsp;&emsp;</span><i class="fa fa-pencil"></i><span>${item.reviewCnt}</span>
			                            
			                          </div>
			                        			                        		                                                
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