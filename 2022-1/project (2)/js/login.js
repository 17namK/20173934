document.getElementById('login').onclick=function(){
let id = document.getElementById('id_').value;
let pw = document.getElementById('pass_').value;
if(id==="test1" && pw==="test1"){
    location.href="main_2.html";
}else{
    alert("아이디 또는 비밀번호를 확인해주세요.")
}
}
