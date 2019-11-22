/*Define a variable to display error message*/
var err = '';

/*Set variables for all inputs,the initial value is false*/
var uname_valid = false;
var name_valid = false;
var pw_valid = false;
var email_valid = false;

/*  function--Return the object with specified id*/
function $(id) {
	obj = document.getElementById(id);
	if (obj == null)
		obj = document.all.id;
	return obj;
}

/* function
 * Return the length of string
 * double-byte characters account for two characters
 * */
String.prototype.chLength = function() {
	var len = this.replace(/[^\x00-\xff]/g, "**").length;
	return len;
}

/*call it when press reset*/
function init() {
	$('uname').focus(); //Focus on the first input
	$('msg').innerHTML = ""; //clear error message
	err = '';
}

/*function chkName()---validate user name*/
function chkUName() {
	uname_valid = false;
	var uname = $('uname').value; //obtain the entered user name
	if (uname == null || uname == '') {
		err += 'Username cannot be null.<br/>';
	} else if (uname.chLength() > 16 || uname.chLength() < 3) {
		err += 'The length of user name must be 3-16.<br/>';
	} else {
		uname_valid = true;
	}
}

function chkName(){
	name_valid = false;
	var name = $('name').value;
	var pattern = /^[a-z A-Z]+$/;
	if (name == null || name == ''){
		err += 'Name cannot be null.<br/>';
	}else if (!pattern.test(name)){
			err += 'Name must only contain alphabets';
		} else
		name_valid = true;
	}

/*function chkPassword()-----validate password*/
function chkPassword() {
	pw_valid = false;
	var pw1 = $('pw1').value;
	var pw2 = $('pw2').value;
	if (pw1 != pw2) {
		err += 'Confirmed password is not consistent to the password.<br/>';
	} else {
		var pattern = /^([\w$_]){3,12}$/;
		if (!pattern.test(pw1)) {
			err += 'Password contains 3－12 letters,digits or signs likes $,_.<br/>';
		} else
			pw_valid = true;
	}
}

/*function chkEmail()---Validate email*/
function chkEmail() {
	//Regular expression of email
	email_valid = false; 
	var pattern = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	var email = $('email').value;
	if (email == "" || !pattern.test(email)) 
	{
		err += 'Email format is wrong.<br/>';
	} else {
		email_valid = true;
	}
}

/*-----Validate all inputs，if valid then submit data------*/
function chkAll() {
	$('msg').innerHTML = "";
	err = '';
	chkUName();
	chkName();
	chkPassword();
	chkEmail();
	if (uname_valid && name_valid && pw_valid && email_valid)
		return true;
	else {
		$('msg').innerHTML = "*" + err; //Display error message
		err.focus();
		return false;
	}
}
