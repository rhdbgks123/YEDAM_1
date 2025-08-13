/**
 * todaySale.js
 */

console.log("실행되나? todaySale.js")
fetch('menuList.do')
	.then(resolve => resolve.json())
	.then(result => {		
		result.forEach(item, index => {
			console.log(item);
			let listContainer = document.querySelector("#todaySaleList");
			let text;
			if(item.[index]%2 ==0) {
				text +='<div class="row" >';
			}
			    text += `			<div class="col-6">
			                <div class="featured__item">
			                        <div class="featured__item__pic set-bg" data-setbg="img/featured/feature-1.jpg">
			                            <ul class="featured__item__pic__hover">
			                                
			                                <li><a href="#"><i class="fa fa-check"></i></a></li>
			                                <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
			                            </ul>
			                        </div>
			                        <div class="row">
			                        <div class="featured__item__text col-6">
			                            <h6>Crab Pool Security</h6>
			                            <i class="fa fa-heart"></i><span>1</span><i class="fa fa-pencil"></i><span>1</span>
			                            
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
				if(item.[index]%2 !=0) {
					text +='</div>';
				}
			listContainer.insertAdjacentHTML('beforeend', text)
		})
	})
	.catch(err => console.error(err))