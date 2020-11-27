function login_check() {

	var validData = true;
	var fouusinput = false;
	var formData = new FormData();
	$('.cont_form_login .required').each(function() {
		var curobj = $(this);
		if (curobj.val() == "") {
			curobj.addClass('has-error');
			curobj.css('border', '1px solid red');
			if (!fouusinput) {
				fouusinput = true;
				$(this).focus();
			}
			validData = false;
		} else {
			formData.append(this.name, curobj.val());
			$(curobj).css('border', '');
		}
	});
	console.log("login valid : "+validData);
	if (validData) {
		$("#login_error").html("");
		$.ajax({
			type : "POST",
			url : base_url + "login/check",
			cache : false,
			contentType : false,
			processData : false,
			data : formData,
			dataType : "json",
			success : function(data) {
				if (data.error) {
					//$("#login_error").html(data.error);
				} else {
					window.location = data.redirect;
				}

			},
			error : function(data) {
				console.log('----------------------'+data);
				$("#login_error").html(data);
			}
			
		})
		.fail(function (jqXHR, textStatus, error) {
			console.log('----------------------'+error);
				$("#login_error").html(error);
			});
	}

}
function cambiar_login() {
	document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";
	document.querySelector('.cont_form_login').style.display = "block";
	document.querySelector('.cont_form_sign_up').style.opacity = "0";

	setTimeout(function() {
		document.querySelector('.cont_form_login').style.opacity = "1";
	}, 400);

	setTimeout(function() {
		document.querySelector('.cont_form_sign_up').style.display = "none";
	}, 200);
}

function cambiar_sign_up(at) {
	document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
	document.querySelector('.cont_form_sign_up').style.display = "block";
	document.querySelector('.cont_form_login').style.opacity = "0";

	setTimeout(function() {
		document.querySelector('.cont_form_sign_up').style.opacity = "1";
	}, 100);

	setTimeout(function() {
		document.querySelector('.cont_form_login').style.display = "none";
	}, 400);

}
$(document).ready(function() {

	$("#reg_email").blur(function() {
		emailVarification();
	});

	$(".phone").mask("(999) 999-9999");
	$('.required').blur(function() {
		// check_user_exists(this);
	});

});

function sign_up() {
	var valid = true;
	var fouusinput = false;
	var formData = new FormData();
	console.log("sing up");
	$('.cont_form_sign_up .required').each(function() {
		var curobj = $(this);
		if (curobj.val() == "") {
			curobj.addClass('has-error');
			curobj.css('border', '1px solid red');
			if (!fouusinput) {
				fouusinput = true;
				curobj.focus();
			}
			console.log("valid");
			valid = false;
		} else if (curobj.hasClass("emailerror")) {
			valid = false;
			console.log("valid1");
			curobj.css('border', '1px solid red');
			if (!fouusinput) {
				fouusinput = true;
			}
		} else {
			formData.append(this.name, curobj.val());
			$(curobj).css('border', '');
		}
	});
	/*
	 * var googleResponse = grecaptcha.getResponse(recaptcha1); if
	 * (grecaptcha.getResponse() == "") { $("#reg_error").html('<p style="color:red !important" class=error-captcha"><span
	 * class="glyphicon glyphicon-remove " ></span> Please fill up the captcha.</p>');
	 * valid =false;console.log("valid2"); }else{
	 * formData.append("g-recaptcha-response",$("#g-recaptcha-response").val()); }
	 */
	console.log("valid::" + valid);
	if (valid) {
		$("#reg_error").html("");
		$.ajax({
			type : "POST",
			url :  "/loanapp/appsignup",
			cache : false,
			contentType : false,
			processData : false,
			data : formData,
			dataType : "json",
			success : function(data) {
				if (data.error) {
					$("#reg_error").html(data.error);
				} else {
					window.location = data.redirect;
				}

			},
			error : function(data) {

			}

		});
	}
}
var REQUEST_EXISTS = false;
var REQUEST = "";
var recaptcha1;

/*function myCallBack() {
	// Render the recaptcha1 on the element with ID "recaptcha1"
	recaptcha1 = grecaptcha.render('RecaptchaField1', {
		'sitekey' : '6LdB7nUUAAAAAMPNFbGBR04HbycnWjo1fAyqnN_J', // Replace this
																// with your
																// Site key
		// 'callback' : verifyCallback,
		'theme' : 'light'

	});

};*/

function emailVarification() {
	var bool = false;
	var str = $("#reg_email").val();

	if (!str
			.match(/^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/)) {
		$("#email").css('border', '1px solid red');
		$("#email-msg").html("<span style='color:red;'></span>");
		$("#email").focus();
		bool = true;

	} else {
		// $("#email").css('border','');
		info = "email=" + encodeURIComponent(str);
		$
				.ajax({
					type : "POST",
					url : base_url + modulepath + "/application/emailCheck",
					data : info,
					dataType : "json",
					success : function(data) {
						// console.log(data);
						if (data == 0) {
							$("#email").css('border', '');
							$("#email-msg").html(
									'<span style="color:green;"> </span>');
							$("#email").removeClass("emailerror");
							bool = false;

						} else {
							$("#email-msg")
									.html(
											"<span style='color:red;'> Email Already Exist</span>");
							$("#email").css('border', '1px solid red');
							$("#email").focus();
							$("#email").addClass('has-error emailerror');
							bool = true;

						}
					}
				});
	}
	return bool;
}

function ocultar_login_sign_up() {

	document.querySelector('.cont_forms').className = "cont_forms";
	document.querySelector('.cont_form_sign_up').style.opacity = "0";
	document.querySelector('.cont_form_login').style.opacity = "0";

	setTimeout(function() {
		document.querySelector('.cont_form_sign_up').style.display = "none";
		document.querySelector('.cont_form_login').style.display = "none";
	}, 500);

}
