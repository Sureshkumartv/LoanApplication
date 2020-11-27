function app_personal_valid(divname) {
	var datavalid = true;
	var fouusinput = false; 
	var formname = "form_" + divname;
	var requiredIndicator = "#" + formname + " .required";
	console.log(divname + "::" + requiredIndicator);
	var selected = $(".borrowerName option:selected").val();
	console.log('borrowerName selected :' + selected);

	if (selected == "borr") {
		$(requiredIndicator).each(function() {
			console.log('calling 1 ' + $(this).attr("name"));

			if ($(this).val() == "") {
				$(this).addClass('has-error');

				$(this).css('background', '#ffd4d4');

				if (!fouusinput) {
					fouusinput = true;
					$(this).focus();
				}
				datavalid = false;
				// return false;
				console.log('calling ' + $(this).attr("name"));
			} else {
				$(this).css('background', '');
			}
		});
		// alert("calling this"+$(this).attr("name"));

	} else {

		//alert('co borrower div');
	}

	if ($("#currentMailingAddress").is(':checked') == false) {
		/*
		 * $(".house_in_mind_required").each(function() {
		 * 
		 * if ($(this).val() == "") { $(this).addClass('has-error');
		 * 
		 * $(this).css('background', '#ffd4d4');
		 * 
		 * if (!fouusinput) { fouusinput = true; $(this).focus(); } datavalid =
		 * false; // return false; } else { $(this).css('background', ''); } }
		 */
		console.log('testing--------------');

		// alert("calling this");
	}

	// alert(divname);
	/*
	 * var datavalid=true; var fouusinput=false; $( requiredIndicator
	 * ).each(function() {
	 * 
	 * if($( this ).val()==""){ $( this ).addClass('has-error'); //$( this
	 * ).attr("placeholder", placeholder); $( this
	 * ).css('background','#ffd4d4'); if(!fouusinput){ fouusinput=true; $( this
	 * ).focus(); } datavalid=false; //return false; } else {
	 * $(this).css('background',''); } });
	 * if($("#is_b_address_valid").val()==0){ $("#current-street").focus();
	 * datavalid = false; } if($("#is_co_address_valid").val()==0){
	 * $("#co-current-street").focus(); datavalid = false; }
	 * if($("#is_b_mail_address_valid").val()==0){
	 * $("#previous_street").focus(); datavalid = false; }
	 * if($("#is_co_mail_address_valid").val()==0){
	 * $("#co_borrower_mailing_address").focus(); datavalid = false; } $(
	 * ".required43" ).each(function() {
	 * 
	 * if($( this ).val()==""){ $( this ).addClass('has-error'); $( this
	 * ).css('background','#ffd4d4'); if(!fouusinput){ fouusinput=true; $( this
	 * ).focus(); } datavalid = false; //return false; } else {
	 * $(this).css('background',''); } });
	 * 
	 * 
	 * if(co_borrower_status=="on") { //alert("inside"); $( ".required42"
	 * ).each(function() {
	 * 
	 * if($( this ).val()==""){ $( this ).addClass('has-error'); //$( this
	 * ).attr("placeholder", placeholder); $( this
	 * ).css('background','#ffd4d4'); if(!fouusinput){ fouusinput=true; $( this
	 * ).focus(); } datavalid = false; //return false; } else {
	 * $(this).css('background',''); } }); } var abc=
	 * $(".date-of-bith").val().split('/'); var a=abc[0]; var b=abc[1]; var
	 * c=abc[2]; var d = $(this).attr("id"); if(abc !='' && abc !='mm,dd,yyyy'){
	 * datavalid = ageValidation(a,b,c,d); if(datavalid) {
	 * $(".date-of-bith").css('background',''); } else{
	 * $(".date-of-bith").css('background','#ffd4d4'); } }
	 * //alert(co_"borrower_status); return datavalid;
	 */
	console.log("datavalid::" + datavalid);
	return datavalid;
}

function ageValidation(imonth, iday, iyear, id) {

	var day = Number(iday);
	var month = Number(imonth);
	var year = Number(iyear);
	var age = 18;
	var mydate = new Date();
	mydate.setFullYear(year, month - 1, day);

	var currdate = new Date();
	var setDate = new Date();
	setDate.setFullYear(mydate.getFullYear() + age, month - 1, day);

	if ((currdate - setDate) > 0) {
		// you are above 18
		$("#" + id).css('background', '');
		return true;

	} else {
		$("#" + id).addClass('has-error');
		$("#" + id).attr("placeholder", "DOB should not be upcoming dates");
		$("#" + id).css('background', '#ffd4d4');
		$("#" + id).focus();
		return false;
	}
	// /alert(year);
	if ((year > 1900) && (year < 2199)) {
		$("#" + id).css('background', '');

	} else {
		$("#" + id).addClass('has-error');
		$("#" + id).attr("placeholder", "Please enter valid Date");
		$("#" + id).css('background', '#ffd4d4');
		$("#" + id).focus();
		return false;
	}
}
function address(street, city, state, zip, error, hide, num) {
	// alert(street.val());
	if (zip.val().replace("_____", "") != '' && street.val() != "") {
		$
				.ajax({
					url : base_url + "application/validateaddress",
					type : 'post',
					data : 'address=' + street.val() + "&city=" + city.val()
							+ "&state=" + state.val() + "&zip=" + zip.val(),
					success : function(result) {
						// alert(result);
						if (result == 0) {
							hide.val(0);
							error.show();
							error.css('color', 'red');
							error
									.html('<i class="fa fa-times" aria-hidden="true" style="color:red;"></i> Address is not valid!');
						} else {
							hide.val(1);
							var response = $.parseJSON(result);
							// alert(street);
							if (num == 1) {
								// alert("street");
								if ($("#borrower_mailing_address_status").is(
										':checked') == true) {
									$("#previous_street").val(
											response.street[0]);
									$("#previous_city").val(response.city[0]);
									$("#previous_state").val(response.state[0])
											.change();
									$("#previous_zip").val(response.zip[0]);
								}
							}
							if (num == 2) {
								// alert("street");
								if ($("#co_borrower_mailing_address_status")
										.is(':checked') == true) {
									$("#co_borrower_mailing_address").val(
											response.street[0]);
									$("#co_borrower_mail_city").val(
											response.city[0]);
									$("#co-borrower-mail-state").val(
											response.state[0]).change();
									$("#co_borrower_mailing_zip").val(
											response.zip[0]);
								}
							}
							street.val(response.street[0]);
							city.val(response.city[0]);
							state.val(response.state[0]).change();
							zip.val(response.zip[0]);
							error.show();
							error.css('color', 'green');
							error
									.html('<i class="fa fa-check" aria-hidden="true" style="color:green;"></i> Address is Valid!');

						}
					}
				});
	} else {
		$(".address_error").hide();
	}
}

$(document).ready(function() {
	
	$(".coCurrentMailingAddress").on("change", function() {
		if ($("#coCurrentMailingAddress").is(':checked') == true) {
			$('.coborrmailing').hide();
		} else {
			$(".coborrmailing").show();
		}
	});
	$(".currentMailingAddress").on("change", function() {
		if ($("#currentMailingAddress").is(':checked') == true) {
			$('.borrmailing').hide();
		} else {
			$(".borrmailing").show();
		}
	});
	
	$("select.houseType").change(function() {
		var selectedhouseType = $(".houseType option:selected").val();
		if (selectedhouseType == "Rent") {
			$('.borrrent').show();

		} else if (selectedhouseType == "Own") {

			$('.borrrent').hide();
		}

	});
	
	$("select.cohouseType").change(function() {
		var selectedhouseType = $(".cohouseType option:selected").val();
		if (selectedhouseType == "Rent") {
			$('.coborrrent').show();

		} else if (selectedhouseType == "Own") {

			$('.coborrrent').hide();
		}

	});
	
	

					$(".borrowerName").on("change", function() {
						//alert('coming');
						$(".borrDiv").hide();
						$(".coborrDiv").hide();
						if (this.value == "coborr") {
//person_heading
							$(".person_heading").html("Co Borrower Personal Information");
							$(".coborrDiv").show();
						}else{
							$(".person_heading").html("Borrower Personal Information");
							$(".borrDiv").show();
						}
					});

					$("#currentMailingAddress")
							.on(
									"change",
									function() {
										if ($("#currentMailingAddress").is(
												':checked') == true) {
											$(".mailing").show();
										} else {
											$(".mailing").hide();
										}
									})

					$(
							"#current-zip,#current-street,#current-city,#borrower_present_state")
							.blur(
									function() {
										if ($(
												"#borrower_mailing_address_status")
												.is(':checked') == true) {
											var street = $('#current-street')
													.val();
											var city = $('#current-city').val();
											var state = $(
													'#borrower_present_state')
													.val();
											var zip = $('#current-zip').val();
											$('#previous_street').val(street);
											$('#previous_city').val(city);
											$('#previous_state').val(state);
											$('#previous_zip').val(zip);
										}
										// console.log(e);
										address($("#current-street"),
												$("#current-city"),
												$("#borrower_present_state"),
												$("#current-zip"),
												$(".address_error"),
												$("#is_b_address_valid"), 1);

									});
					$(
							"#previous_street,#previous_city,#previous_state,#previous_zip")
							.blur(
									function() {
										// console.log(e);
										address($("#previous_street"),
												$("#previous_city"),
												$("#previous_state"),
												$("#previous_zip"),
												$(".address_erro"),
												$("#is_b_mail_address_valid"),
												0);

									});
					$(
							"#co-current-street,#co-current_city,#co_borrower_present_state,#co-current-zip")
							.blur(
									function() {
										address(
												$("#co-current-street"),
												$("#co-current_city"),
												$("#co_borrower_present_state"),
												$("#co-current-zip"),
												$(".address_err"),
												$("#is_co_address_valid"), 2);
										if ($(
												"#co_borrower_mailing_address_status")
												.is(':checked') == true) {
											var street = $('#co-current-street')
													.val();
											var city = $('#co-current_city')
													.val();
											var state = $(
													'#co_borrower_pre_state')
													.val();
											var zip = $('#co-current-zip')
													.val();
											$('#co_borrower_mailing_address')
													.val(street);
											$('#co_borrower_mail_city').val(
													city);
											$('#co_borrower_mailing_zip').val(
													zip);
											$('#co-borrower-mail-state').val(
													state);
										}
										// console.log(e);

									});
					$(
							"#co_borrower_mailing_address,#co_borrower_mail_city,#co-borrower-mail-state,#co_borrower_mailing_zip")
							.blur(
									function() {
										// console.log(e);
										address(
												$("#co_borrower_mailing_address"),
												$("#co_borrower_mail_city"),
												$("#co-borrower-mail-state"),
												$("#co_borrower_mailing_zip"),
												$(".address_er"),
												$("#is_co_mail_address_valid"),
												0);

									});
					$(".date").datepicker({});

					if ($("#borrower_present_house_type").val() == "Rent") {
						$("#rent").show();
					} else {
						$("#rent").hide();
					}
					if ($("#co_borrower_present_house_type").val() == "Rent") {
						$("#co_rent").show();
					} else {
						$("#co_rent").hide();
					}

					if (co_borrower_status == "on") {
						$("#co-borrower-info").show();
					} else {
						$("#co-borrower-info").hide();
					}

					$("#borrower_present_house_type").change(function() {
						rentEnable();

					});
					$("#co_borrower_present_house_type")
							.change(
									function() {
										if ($("#co_borrower_present_house_type")
												.val() == "Rent") {
											$("#co_rent").show();
										} else {
											$("#co_rent").hide();
										}

									});

					function rentEnable() {
						if ($("#borrower_present_house_type").val() == "Rent") {
							$("#rent").show();
						} else {
							$("#rent").hide();
						}
					}
					;
					$('#borrower_mailing_address_status').on(
							'change',
							function() {
								if ($("#borrower_mailing_address_status").is(
										':checked') == true) {
									// $(".mailing").show();
									// $('#previous-street').val("");
									// $('#previous_city').val("");
									// $('#previous-zip').val("");
									var street = $('#current-street').val();
									var city = $('#current-city').val();
									var state = $('#borrower_present_state')
											.val();
									var zip = $('#current-zip').val();

									$('#previous_street').val(street);
									$('#previous_city').val(city);
									$('#previous_state').val(state);
									$('#previous_zip').val(zip);
								} else {

									$('#previous_street').val("");
									$('#previous_city').val("");
									$('#previous_state').val("");
									$('#previous_zip').val("");
								}
							});
					$('#co_borrower_mailing_address_status').on(
							'change',
							function() {
								if ($("#co_borrower_mailing_address_status")
										.is(':checked') == true) {
									// alert("checked");
									var street = $('#co-current-street').val();
									var city = $('#co-current_city').val();
									var state = $('#co_borrower_pre_state')
											.val();
									var zip = $('#co-current-zip').val();

									$('#co_borrower_mailing_address').val(
											street);
									$('#co_borrower_mail_city').val(city);
									$('#co_borrower_mailing_zip').val(zip);
									$('#co-borrower-mail-state').val(state);

								} else {
									// $("#co-borrower-mailing").hide();
									$('#co_borrower_mailing_address').val("");
									$('#co_borrower_mail_city').val("");
									$('#co_borrower_mailing_zip').val("");
									$('#co-borrower-mail-state').val("");
								}
							});
					$(".date-of-bith").blur(function() {
						// var [a, b, c] = $(this).val().split('/');
						var abc = $(this).val().split('/');
						var a = abc[0];
						var b = abc[1];
						var c = abc[2];
						var d = $(this).attr("id");
						if (abc != '' && abc != 'mm,dd,yyyy') {
							ageValidation(a, b, c, d);
						}
					});
					$(".numberBox").blur(function() {
						var max = parseInt($(this).attr('max'));
						var min = parseInt($(this).attr('min'));

						if ($(this).val() > max && $(this).val() != '') {
							$(this).val('');
							$(this).css('background', '#ffd4d4');
						} else if ($(this).val() < min && $(this).val() != '') {
							$(this).val('');
							$(this).css('background', '#ffd4d4');
						} else {
							$(this).css('background', '');
						}
					});

				});