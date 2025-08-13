
let pwCheck = false;

document.querySelector('#addressSearch').addEventListener('click',findAddr);
document.querySelector('#checkpwd').addEventListener('click',checkPw);
const form = document.querySelector('#registerForm');
const userid = document.querySelector('#userId');
const orgpwd = document.querySelector('#orgpwd');
const pwd = document.querySelector('#pwd');
const pwdChk = document.querySelector('#pwdChk');


form.addEventListener('submit', (e) => {
  if(!pwCheck)
	{
		e.preventDefault(); 
		alert("기존 비밀번호 확인이 되지않았습니다.");
		orgpwd.value="";
		orgpwd.focus();
		return;
	}
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

async function checkPw()
{
	// 게시글번호(bno) / 작성자(logId) / 댓글정보(reply)
	// bno, logId는 jsp에서 미리 선언되어있음
	let upwBox = document.querySelector('#orgpwd');
	let upw = upwBox.value;
	if(!upw) // js에서는 0, 공백, null, undefined는 false로 판단
	{
		alert("기존 비밀번호 입력");
		return;
	}	
	let resolve = await fetch('checkUserPw.do?pw='+upw);
	let result = await resolve.json();
	
	if(result.retCode == 'OK')
	{
		alert("정상 비밀번호");
		orgpwd.focus();
		pwCheck=true;
	}
	else
	{
		alert("비밀번호를 다시 확인해 주세요.");
		upwBox.value = "";
		orgpwd.focus();
		pwCheck=false;
	}
		
}