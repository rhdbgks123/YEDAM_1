document.querySelector('#addressSearch').addEventListener('click',findAddr);
document.querySelector('#checkId').addEventListener('click',checkId);

const form = document.querySelector('#registerForm');
const userid = document.querySelector('#userId');
const pwd = document.querySelector('#pwd');
const pwdChk = document.querySelector('#pwdChk');

form.addEventListener('submit', (e) => {
  if (pwd.value!=pwdChk.value) {
	e.preventDefault(); 
	alert("비밀번호가 다릅니다. 확인해주세요");
	pwd.focus();
	return;
  }

});


function findAddr() {
	new daum.Postcode({
		oncomplete: function(data) {
			let addr = '';

			if (data.userSelectedType === 'R') {
				addr = data.roadAddress;
			}
			else {
				addr = data.jibunAddress;
			}
			console.log(addr);
			document.querySelector("#address").value= addr;
		}
	}).open();
}

async function checkId()
{
	// 게시글번호(bno) / 작성자(logId) / 댓글정보(reply)
	// bno, logId는 jsp에서 미리 선언되어있음
	let uidBox = document.querySelector('#userId');
	let uid = uidBox.value;
	if(!uid) // js에서는 0, 공백, null, undefined는 false로 판단
	{
		alert("아이디 입력");
		return;
	}	
	let resolve = await fetch('checkUser.do?userId='+uid);
	let result = await resolve.json();
	
	if(result.retCode == 'OK')
	{
		alert("중복된 아이디입니다.");
		uidBox.value = "";
	}
	else
	{
		alert("사용가능 아이디입니다.");
		document.querySelector('#pwd').focus();
	}
		
}