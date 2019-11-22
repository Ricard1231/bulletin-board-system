function formValidation() {
	var username = document.getElementById('username');
	var password = document.getElementById('password');
	
	if (username.value.length == 0 || password.value.length == 0) {
		document.getElementById('head').innerText = "* All fields are mandatory";
		return false;
		
}else return true;
}

