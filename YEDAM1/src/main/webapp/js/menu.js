/**
 * 
 */
//console.log("실행되나? menu.js")
fetch('menuList.do')
	.then(resolve => resolve.json())
	.then(result => {
		result.forEach(menulist => {
			//console.log(menulist);
			let listContainer = document.querySelector("div.hero__categories ul");

			let text = `<li><a href="onClickMenu.do?menuCode=${menulist.menuCode}">${menulist.menuName}</a></li>`;
			listContainer.insertAdjacentHTML('beforeend', text)
		})
	})
	.catch(err => console.error(err))
