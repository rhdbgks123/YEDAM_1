
document.querySelector('#sendmail').addEventListener('click', checkUser);

document.querySelector('#signcheck').addEventListener('click', signCheck);

const form = document.querySelector('#findUserForm');
const userName = document.querySelector('#userName');
const birth = document.querySelector('#birth');
const identi = document.querySelector('#identi');
const email = document.querySelector('#email');
const signkey = document.querySelector('#signkey');

let usersign = "";
let userId = "";
let signbool = false;
form.addEventListener('submit', (e) => {
  if (!signbool) {
	e.preventDefault(); 
	alert("메일인증이 되지 않았습니다.");
	pwd.focus();
	return;
  }

});


async function checkUser()
{
	// 게시글번호(bno) / 작성자(logId) / 댓글정보(reply)
	// bno, logId는 jsp에서 미리 선언되어있음
	let uName = userName.value;
	let uBirth = birth.value;
	let uIdenti = identi.value;
	let uEmail = email.value;
	if(!uName || !uBirth || !uIdenti || !uEmail) // js에서는 0, 공백, null, undefined는 false로 판단
	{
		alert("필수정보를 입력해 주세요");
		return;
	}	
	let resolve = await fetch('findUser.do?userName='+ uName + '&birth=' + uBirth + '&identi=' + uIdenti + '&email=' + uEmail);
	let result = await resolve.json();
	
	if(result.retCode == 'OK')
	{
		alert("메일 발송 완료!");
		signkey.focus();
		usersign = result.usersign;
		userId = result.userId;
	}
	else
	{
		alert("데이터가 일치하지 않습니다. 다시 확인해주세요");
		userName.focus();
	}
		
}
async function signCheck()
{
	let sign = signkey.value;
	console.log('sign : ' + sign);
	console.log('usersign : ' + usersign);
	if(usersign == sign)
	{
		let resolve = await fetch('removeSign.do?userId=' + userId);
		let result = await resolve.json();
		
		if(result.retCode == 'OK')
		{
			alert("정상 인증되었습니다");
			signbool = true;
		}
		else
		{
			alert("인증 중 오류발생! 처음부터 다시 작업해주세요");
			signbool = false;	
		}
		
	}
	else
	{
		alert("인증번호가 일치하지 않습니다. 다시 확인해주세요.");	
		signbool = false;
	}
}