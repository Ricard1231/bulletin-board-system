var username_format = false;
var username_length = false
var username_valid = false;
var name_valid = false;
var email_valid = false;
var date_valid = false;
var password_valid = false;
var msg = "";

function $(id) {
	var jspid = document.getElementById(id);
	if (jspid == null)
		jspid = document.all.id;
	return jspid;
}

function check_username() {
	var username = $('username');
	var alphaExp = /^[0-9a-zA-Z]+$/;
	username_valid = false;
	username_format = false;
	username_length = false;
	if (username.value.match(alphaExp)) {
		username_format = true;
	} else {
		msg += "Please use letters and numbers only, ";
		username_format = false;
	}
	if (username.value.length >= 3 && username.value.length <= 10) {
		username_length = true;
	} else {
		msg += "Please enter between 3 to 10 characters, ";
		username_length = false;
	}
	if (username_format && username_length) {
		username_valid = true;
	} else {
		username_valid = false;
	}
	return username_valid;
}

function check_name() {
	var name = $('name')
	var alphaExp = /^[a-zA-Z]+$/;
	name_valid = false;
	if (name.value.match(alphaExp)) {
		name_valid = true;
	} else {
		msg += "Please use alphabets only for your name, "
		name_valid = false;
	}
	return name_valid;
}

function check_email() {
	var email = $('email');
	var emailExp = /^[w-.+]+@[a-zA-Z0-9.-]+.[a-zA-z0-9]{2,4}$/;
	email_valid = false;
	if (email.value.match(emailExp)) {
		email_valid = true;
	} else {
		msg += "Please enter a valid email address, "
		email_valid = false;
	}
	return email_valid;
}

function check_date() {
	var date = $('datepicker');
	date_valid = false;
	if (date.value == null) {
		msg += "Please choose date, ";
		date_valid = false;
	} else {
		date_valid = true;
	}
	return date_valid;
}

function check_password() {
	var password = $('password')
	var cpassword = $('cpassword');
	password_valid = false;
	if (password.value == cpassword.value) {
		password_valid = true;
	} else {
		msg += "Password is different, ";
		password_valid = false;
	}
	return password_valid;
}

function check() {
	var username = $('username');
	var head = $('head');
	if (username.value.length == 0 || name.value.length == 0 || email.value.length == 0 || password.value.length == 0 || date.value.length == 0) {
		head.innerText = "* All fields are mandatory";
		return false;
	} else {
		check_username();
		check_name();
		check_email();
		check_date();
		check_password();
		return (username_valid && name_valid && email_valid && date_valid && password_valid);
////		{
////			return true;
////		} else {
		$('msg').innerText = msg;
////			return false;
////		}
////		return false;
	}
}
