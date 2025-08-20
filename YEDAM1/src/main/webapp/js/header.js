document.addEventListener("DOMContentLoaded", () => {
    headerCart();
});

async function headerCart()
{
	let resolve = await fetch('headerCart.do?');
	let result = await resolve.json();
	if(result.retCode == 'OK') 
	{
		 let data = result.data; 
		 let span1 = document.createElement('span'); 
		 span1.innerText = data.totalCount; 
		 document.querySelector('.header__cart ul li a').appendChild(span1); 
		 let span2 = document.createElement('span'); 
		 span2.innerText = data.totalPrice + '원'; 
		 document.querySelector('.header__cart__price').appendChild(span2); 
	 } 
	 else 
	 { 
		alert("데이터가 일치하지 않습니다. 다시 확인해주세요"); 
	}
}