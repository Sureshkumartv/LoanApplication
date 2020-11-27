

function app_income_valid(divname) {
    var datavalid = true;
    var fouusinput = false;
    return datavalid;
}
function employee_valid(divname) {
    //alert('div name :"+divname');
    var datavalid = true;
    var fouusinput = false;
    if ($("#borrower_employer_name").val() == "")
    {
        $("#borrower_employer_name").addClass('has-error');
        // $( this ).attr("placeholder", placeholder);
        $("#borrower_employer_name").css('background', '#ffd4d4');
        if (!fouusinput) {
            fouusinput = true;
            $("#borrower_employer_name").focus();
        }
        datavalid = false;
        // return false;
    }
    if ($("#borrower_employer_name").val() != "")
    {
        $(".required71").each(function () {

            if ($(this).val() == "") {
                $(this).addClass('has-error');
                // $( this ).attr("placeholder", placeholder);
                $(this).css('background', '#ffd4d4');
                if (!fouusinput) {
                    fouusinput = true;
                    $(this).focus();
                }
                datavalid = false;
                // return false;
            } else {
                $(this).css('background', '');
            }

        });
    }
    return datavalid;
}
function rent_valid(divname) {
    var datavalid = true;
    var fouusinput = false;

    if ($("#borrower_rent_type").val() == "")
    {
        $("#borrower_rent_type").addClass('has-error');
        // $( this ).attr("placeholder", placeholder);
        $("#borrower_rent_type").css('background', '#ffd4d4');
        if (!fouusinput) {
            fouusinput = true;
            $("#borrower_rent_type").focus();
        }
        datavalid = false;
        // return false;
    }
    if ($("#borrower_rent_type").val() != "")
    {
        $(".required91").each(function () {

            if ($(this).val() == "") {
                $(this).addClass('has-error');
                // $( this ).attr("placeholder", placeholder);
                $(this).css('background', '#ffd4d4');
                if (!fouusinput) {
                    fouusinput = true;
                    $(this).focus();
                }
                datavalid = false;
                // return false;
            } else {
                $(this).css('background', '');
            }

        });
    }
    return datavalid;
}
function ssn_valid(divname) {
    var datavalid = true;
    var fouusinput = false;
    if ($("#borrower-social-security").val() == "")
    {
        $("#borrower-social-security").addClass('has-error');
        // $( this ).attr("placeholder", placeholder);
        $("#borrower-social-security").css('background', '#ffd4d4');
        if (!fouusinput) {
            fouusinput = true;
            $("#borrower-social-security").focus();
        }
        datavalid = false;
        // return false;
    }
    return datavalid;
}
function pension_valid(divname) {
    var datavalid = true;
    var fouusinput = false;
    if ($("#borrower_employer_name_pension").val() == "")
    {
        $("#borrower_employer_name_pension").addClass('has-error');
        // $( this ).attr("placeholder", placeholder);
        $("#borrower_employer_name_pension").css('background', '#ffd4d4');
        if (!fouusinput) {
            fouusinput = true;
            $("#borrower_employer_name_pension").focus();
        }
        datavalid = false;
        // return false;
    }
    if ($("#borrower_employer_name_pension").val() != "")
    {
        $(".required93").each(function () {

            if ($(this).val() == "") {
                $(this).addClass('has-error');
                // $( this ).attr("placeholder", placeholder);
                $(this).css('background', '#ffd4d4');
                if (!fouusinput) {
                    fouusinput = true;
                    $(this).focus();
                }
                datavalid = false;
                // return false;
            } else {
                $(this).css('background', '');
            }

        });
    }
    return datavalid;
}
function other_valid(divname) {
    var datavalid = true;
    var fouusinput = false;
    if ($("#borrower_employment_type_other").val() == "")
    {
        $("#borrower_employment_type_other").addClass('has-error');
        // $( this ).attr("placeholder", placeholder);
        $("#borrower_employment_type_other").css('background', '#ffd4d4');
        if (!fouusinput) {
            fouusinput = true;
            $("#borrower_employment_type_other").focus();
        }
        datavalid = false;
        // return false;
    }
    if ($("#borrower_employment_type_other").val() != "")
    {
        $(".required94").each(function () {

            if ($(this).val() == "") {
                $(this).addClass('has-error');
                // $( this ).attr("placeholder", placeholder);
                $(this).css('background', '#ffd4d4');
                if (!fouusinput) {
                    fouusinput = true;
                    $(this).focus();
                }
                datavalid = false;
                // return false;
            } else {
                $(this).css('background', '');
            }

        });
    }
    return datavalid;
}


$(document).ready(function () {
	
	$(".rentalNoOfMortgages").on("change", function() {
		$(".rentalNoOfMortgages_bank").hide();
		if (this.value == "1") {
			$(".rental_bank1").show();
		} else if (this.value == "2") {
			$(".rental_bank1").show();
			$(".rental_bank2").show();
		}
	})
	
	incomeButtonsScript();
	
	$(".buttons").click(function() {
		$("#incomeid_emp").val("");
		$("#incomeid_pension").val("");
		$("#incomeid_rent").val("");
		$("#incomeid_ssn").val("");
		$("#incomeid_other").val("");
		var divname = $(this).attr("data-datac");
		console.log("divname::"+divname);
		$(".tabForms").hide();
		$("#" + divname).show("slow").siblings().hide("slow");
		$("#buttonsDiv").hide();
		$("#nxtbut").hide();
		$("#backbutton").show();
		 
	});
    $(".date").datepicker({
    });


    LoadIncomeInfo();



});
var totalIncomesCount=0;
function showIncomeTableDiv(){
	  $("#emp_div").hide();
      $("#rental_div").hide();
      $("#social_div").hide()
      $("#pension_div").hide();
      $("#others_div").hide();
      $("#buttonsDiv").hide();
      $("#addAnother").show();
      $("#added_income").show();
      $("#btn_next_app_income").show();
	  $("#btn_prev_app_income").show();
	  $('#showIncomeDetails').hide();
	  $("#nxtbut").show();
}
function showButtonsDiv(){
	$("#buttonsDiv").show();
	$("#nxtbut").show();
	// $("#backbutton").hide();
	$("#added_income").hide();
	$(".tabForms").hide();
}
function clearAllForms(){
	$("#employment_owner_emp").val('');
	$("#borrower_employer_name_1").val('');
	$("#borrower_current_employer").val('');

	$("#borrower_employer_work_phone_1").val('');
	$("#borrower_employer_address_1").val('');
	$("#borrower_employer_city_1").val('');
	$("#borrower_employer_state_1").val('');
	$("#borrower_employer_zip_1").val('');
	$("#borrower_employer_start_date_1").val('');
	$("#borrower_employer_position_1").val('');
	$("#borrower_employer_years_line_work_1").val('');
	$("#borrower_employer_start_date_1").val('');
	$("#borrower_income_type_1").val(''); 
	$("#borrower_employer_base_income_1").val('');
	$("#borrower_monthliy_overtime_amount").val('');
	$("#borrower_employer_bonus_amount").val('');
	$("#borrower_employer_commision_amount").val('');
	
	$('#borrower_rent_type').val('');
	$('#borrower_rent_value').val('');
	$('#borrower_employer_rent_income').val('');
	$('#borrower_rent_mortgages').val('');
	$("#borrower_prop_address_1").val('');
	$("#borrower_prop_city_1").val('');
	$("#borrower_prop_state_1").val('');
	$("#borrower_prop_zip_1").val('');
	
	$("#borrower-social-security").val('');
	
	$("#borrower_employer_name_pension").val('');
	$("#borrower-pension").val('');
	$("#borrower-retire-date_pension").val('');
	
	$("#borrower_employer_base_income_other").val('');
}
function LoadIncomeInfo(){

    var formData1 = new FormData();
    // formData1.append("incomeid",index_id);
    formData1.append("leadId", lead_id);
  // formData1.append("call", 'income');

    $.ajax({
        type: "POST", url: base_url + "loadincomedata/", cache: false, contentType: false, processData: false,
        data:  JSON.stringify(serializeForm(formData1)), dataType: "json",
        success: function (data) {
           // console.log(data);
            // nextBtnObj.show();
            if (data.leadId == "")
            {
                appLoading.html("Their is error while submitting application. please contact us");
                curLi.addClass("active");
            } else {
                if (lead_id == "") {
                    window.location = base_url + "application/curapp";
                } else {
                    lead_id = data.leadId;
                    console.log(lead_id);
                    console.log(data.incomeDetails);
                    var json = data.incomeDetails;
                    // (json.length);
                    $('#location1 tbody>tr').remove();
                    if (json.length > 0)
                    {     // $("#btn_adincome").show();
                    	showIncomeTableDiv();
                      
                        totalIncomesCount =json.length;
                        var tr = null;
                        for (var i = 0; i < json.length; i++) {
                            tr = $('<tr id="income_dispaly_row_'+json[i].id+'">');
                            if (json[i].accountOwner == "borr")
                            { 
                                tr.append("<td class='text-center'>" + borrower_full_name + "</td>");
                            } else if (json[i].accountOwner == "coborr")
                            {
                                tr.append("<td class='text-center'>" + co_borrower_full_name + "</td>");
                            }else{
                            	 tr.append("<td class='text-center'> </td>");
                            }
                            tr.append("<td class='text-center'>" + json[i].incomeType + "</td>");
                            tr.append("<td class='text-center'>" + json[i].incomeAmount + "</td>");

                            tr.append("<td><span class='incomeeditbtn  text-center' id='" + json[i].id + "'>" +
                            		" <i class='fa fa-edit' style='font-size:36px,color:red;'></i></span> " +
                            		"<span class='incomedeletebtn' id='" + json[i].id + "'>" +
                            				"<i class='fa fa-trash' style='font-size:36px,color:red;'></i></span></td>" );
                            tr.append("</tr>");
                            $('tbody').first().append(tr);
                        }
                        IncomeDeleteButtonEnable();
                        IncomeEditButtonEnable();
                    } else
                    {
                        $("#emp_div").hide();
                        $("#rental_div").hide();
                        $("#social_div").hide()
                        $("#pension_div").hide();
                        $("#others_div").hide();
                        $("#buttonsDiv").show();
                        $("#added_income").hide();
                    }
                }

            }
        }, error: function (data) {
            // nextBtnObj.show();
        }

    });
}
function IncomeEditButtonEnable(){
	$(".incomeeditbtn").click(  function (event) {
	    var index_id = $(this).attr("id");
	    var formData1 = new FormData();
	    formData1.append("incomeid", index_id);
	    formData1.append("leadId", lead_id);
	    formData1.append("call", 'income'); 
	    $.ajax({
	        type: "POST", url: base_url + "incomedetails", cache: false, contentType: false, processData: false,
	        data: formData1 ,
	        success: function (data) {
	        	  $("#added_income").hide();
                  $("#emp_div").hide();
                  $("#rental_div").hide();
                  $("#social_div").hide()
                  $("#pension_div").hide();
                  $("#others_div").hide();
                  $("#nxtbut").hide();
	            console.log(data);
	            var tabFormsid=	$(data).attr("id");
	            console.log(tabFormsid);
	          //  $("#"+tabFormsid).parent().remove();
	            $("#"+tabFormsid).remove();
	            $(".income_form").append(data);
	            $("#"+tabFormsid).show();
	            maskinputs(); 
	            incomeButtonsScript();
	        }, error: function (data) {
	            console.log(data);
	        }

	    });

	});


}
function IncomeEditButtonEnable1(){
	$(".incomeeditbtn").click(  function (event) {
	    var index_id = $(this).attr("id");
	    var formData1 = new FormData();
	    formData1.append("incomeid", index_id);
	    formData1.append("leadId", lead_id);
	    formData1.append("call", 'income'); 
	    $.ajax({
	        type: "POST", url: base_url + "incomedetails", cache: false, contentType: false, processData: false,
	        data: formData1, dataType: "json",
	        success: function (data) {
	            console.log(data);

	            if (data.leadId == "")
	            {
	                appLoading.html("Their is error while submitting application. please contact us");
	                curLi.addClass("active");
	            } else {
	                if (lead_id == "") {
	                    window.location = base_url + "newloan";
	                } else {
	                    lead_id = data.leadId;

	                    console.log(data.editIncomeDetails);
	                    console.log("incomeType"+data.incomeType );
	                    var incomeType=data.incomeType ;
	                    var jsonresp = data.editIncomeDetails;
	                    $("#added_income").hide();
                        $("#emp_div").hide();
                        $("#rental_div").hide();
                        $("#social_div").hide()
                        $("#pension_div").hide();
                        $("#others_div").hide();
	                    if (incomeType == "rental")
	                    { 
	                        $("#incomeid_rent").val(jsonresp.incomeId);
	                        $('#employment_owner_emp').val(jsonresp.rentalPropertyOwner);
	                         $("input[name=rentalPropertyType][value=" + jsonresp.rentalPropertyType + "]").attr('checked', 'checked');
	                        $("#borrower_prop_address_1").val(jsonresp.rentalPropertyAddress);
	                        $("#borrower_prop_city_1").val(jsonresp.rentalPropertyCity);
	                        $("#borrower_prop_state_1").val(jsonresp.rentalPropertyState);
	                        $("#borrower_prop_zip_1").val(jsonresp.rentalPropertyZip);
	                       
	                         $('#propertyValue').val(jsonresp.rentalPropertyValue);
		                    $('#borrower_employer_rent_income').val(jsonresp.rentalMonthlyRent);
		                    
		                    $("input[name=rentalNoOfMortgages][value=" + jsonresp.rentalNoOfMortgages + "]").attr('checked', 'checked');
		                   
		                    $('#rentalBankName').val(jsonresp.rentalBankName);   
		                    $('#rentalBalanceMortgage').val(jsonresp.rentalBalanceMortgage); 
		                    $('#rentalMonthlyPayment').val(jsonresp.rentalMonthlyPayment); 
		                    
		                    $('#rentalSecondBankName').val(jsonresp.rentalSecondBankName);   
		                    $('#rentalSecondBalanceMortgage').val(jsonresp.rentalSecondBalanceMortgage); 
		                    $('#rentalSecondMonthlyPayment').val(jsonresp.rentalSecondMonthlyPayment); 
		                    $("#rental_div").show();
	                        
	                    }
	                    else  if (incomeType == "Employee")
	                    {
	                        $("#incomeid_emp").val(jsonresp.incomeId);
	                         
	                        $("#employment_owner_emp").val(jsonresp.owner);
	                        $("#borrower_employer_name_1").val(jsonresp.BE0102);
	                        $("#borrower_current_employer").val(jsonresp.BE0109);

	                        $("#borrower_employer_work_phone_1").val(jsonresp.BE0117);
	                        $("#borrower_employer_address_1").val(jsonresp.BE0104);
	                        $("#borrower_employer_city_1").val(jsonresp.BE0105);
	                        $("#borrower_employer_state_1").val(jsonresp.BE0106);
	                        $("#borrower_employer_zip_1").val(jsonresp.BE0107);
	                        $("#borrower_employer_start_date_1").val(jsonresp.BE0111);
	                        $("#borrower_employer_position_1").val(jsonresp.BE0110);
	                        $("#borrower_employer_years_line_work_1").val(jsonresp.BE0116);
	                        $("#borrower_employer_start_date_1").val(jsonresp.BE0111);
	                        $("#borrower_income_type_1").val(jsonresp.BE0033);
 	                        $("#borrower_employer_base_income_1").val(jsonresp.BE0119);
	                        $("#borrower_monthliy_overtime_amount").val(jsonresp.BE0120);
	                        $("#borrower_employer_bonus_amount").val(jsonresp.BE0121);
	                        $("#borrower_employer_commision_amount").val(jsonresp.BE0122);
	                        $("#emp_div").show();
	                    }
	                    else  if (incomeType == "socialsecurity")
	                    {
	                        $("#employment_owner_ssn").val(jsonresp.accountOwner);
	                        $("#incomeid_ssn").val(jsonresp.incomeId);
	                        $("#borrower-social-security").val(jsonresp.anualIncome);
	                       
	                        $("#social_div").show()
	                        
	                    }
	                    else  if (incomeType == "Pension")
	                    {
	                        $("#employment_owner_pen").val(jsonresp.owner);
	                        $("#pension_div").show();
	                        $("#incomeid_pension").val("");
 
	                        $("#borrower_employer_name_pension").val("");
	                        $("#borrower-pension").val("");
	                        $("#borrower-retire-date_pension").val("");
	                        $("#incomeid_pension").val("");
	                        $("#incomeid_pension").val(jsonresp.id);
	                        $("#borrower_employer_name_pension").val(jsonresp.BE0102);
	                        $("#borrower-pension").val(jsonresp.BE0119);
	                        $("#borrower-retire-date_pension").val(jsonresp.BE0020);

	                    }
	                    else if ((incomeType == "Alimony / Child Support" || incomeType == "Annuity" || incomeType == "Deferred Compensation" 
	                    	|| incomeType == "Interest / Dividends " || incomeType == "Other"))
	                    {
	                        $("#others_div").show();
	                        $("#incomeid_other").val(jsonresp.id);
	                        $("#employment_owner_other").val(jsonresp.owner);
	                        $("#borrower_employment_type_other").val(jsonresp.BE0001);
	                        $("#borrower_employer_base_income_other").val(jsonresp.BE0119);

	                    }
	                    maskinputs()
	                }

	            }
	        }, error: function (data) {
	            console.log(data);
	        }

	    });

	});


}
function IncomeDeleteButtonEnable(){
	// incomedeletebtn
	$(".incomedeletebtn").click(function (event) {
	    var index_id = $(this).attr("id");
	    var formData1 = new FormData();
	    formData1.append("incomeid", index_id);
	    formData1.append("leadId", lead_id);
	    formData1.append("call", 'income');

	    $.ajax({
	        type: "POST", url: base_url + "deleteincome", cache: false, contentType: false, processData: false,
	        data: formData1, dataType: "json",
	        success: function (data) {
	            console.log(data);

	            if (data.leadId == "")
	            {
	                appLoading.html("Their is error while submitting application. please contact us");
	                curLi.addClass("active");
	            } else {
	                if (lead_id == "") {
	                    window.location = base_url + "application/curapp";
	                } else {
	                	$("#income_dispaly_row_"+index_id).remove();
	                	totalIncomesCount--;
	                	if(totalIncomesCount ==0){
	                		showButtonsDiv();
	                	}
	                     // lead_id = data.leadId;

	                    // console.log(data);
	                    // var jsonresp = data.data;
	                  // var json = data.data;
	                   // LoadIncomeInfo();

	                }
	            }
	        }, error: function (data) {
	            console.log(data);
	        }

	    });

	});
}
 function button_income_click(btnid) {
      // alert("clicked " + btnid);
        // btn_add_income_app_pension
        try {
            var nextBtnObj = $("#" + btnid);
            nextBtnObj.hide();
            var cur_pos = "app_income"
            	console.log(cur_pos);
            var curLi = $("#li_" + cur_pos);
            var curTabName = curLi.find("span")[0].innerHTML;
            var nextLi = curLi.next();
            var next_pos = "";
            if (cur_pos == "app_confirmation") {
                next_pos = "app_confirmation";
            } else {
                next_pos = nextLi.attr("id").replace("li_", "");
            }
            console.log('next_pos ' + next_pos);
           
            var validdata = true;
           // var curForm = $(".income_form" ).find("form");
          // console.log(curForm);
            var formData = new FormData();
            if (btnid == "employement") {
                validdata = employee_valid();
                formData = new FormData($("#form_app_employement")[0]);
            } else if (btnid == "rent")
            {
                validdata = rent_valid();
                formData = new FormData($("#form_rental")[0]);
            } else if (btnid == "pension")
            {
                validdata = pension_valid();
                formData = new FormData($("#form_pension")[0]);
            } else if (btnid == "ssn")
            {
                validdata = ssn_valid();               
                formData = new FormData($("#form_app_socialsecurity")[0]);
            } else if (btnid == "other")
            {
                validdata = other_valid();
                formData = new FormData($("#form_otherincome")[0]);
            }
            console.log(formData);
            console.log('valid :' + validdata)
            if (validdata) {
            	 
            	  var json = JSON.stringify(serializeForm(formData));
            	 console.log(lead_id+'----json------   ' + json);
            	  let newFormData = new FormData();
            	  newFormData.append("request", json);
            	  newFormData.append("curPos", cur_pos);
                  newFormData.append("nextPos", next_pos);
            	  newFormData.append("leadId",lead_id);
            	  newFormData.append("incomeType", btnid);
 

            	  console.log(cur_pos);
                
                
                $.ajax({
                    type: "POST", url: base_url + "incomeapp/"+btnid, cache: false, contentType: false, processData: false,
                    data: JSON.stringify(serializeForm(newFormData)), dataType: "json",
                    success: function (data) {
                        // console.log(data);
                      
                        nextBtnObj.show();
                        if (data.leadId == "")
                        {
                            appLoading.html("Their is error while submitting application. please contact us");
                            curLi.addClass("active");
                        } else {
                            if (lead_id == "") {
                                window.location = base_url + "application/curapp";
                            } else {
                                lead_id = data.leadId;
                                
                                LoadIncomeInfo();

                            }

                        }
                    }, error: function (data) {
                        nextBtnObj.show();
                    }

                });

            } else {
                nextBtnObj.show();
            }
        } catch (ex) {
            console.log(ex);
        }
        return false;
    }
function incomeButtonsScript(){
	

    $(".btn_add_income").click(function () {
    	  console.log("lead_id::"+lead_id); 
        button_income_click("employement");
        return false;
    });
    $(".btn_add_rent").click(function () {
       
        button_income_click("rent");
        return false;
    });
    $(".btn_add_pension").click(function () {
        
        button_income_click("pension");
        return false;
    });
    $(".btn_add_ssn").click(function () {
        
        button_income_click("ssn");
        return false;
    });
    $(".btn_add_other").click(function () {
     
        button_income_click("other");
        return false;
    });
	$('#showIncomeDetails').click(function() {
		showIncomeTableDiv();
	});
	$("#addAnother").click(function() {
		// alert("clicked");
		  $("#addAnother").hide();
		  if(totalIncomesCount >0){
			  $("#btn_next_app_income").hide();
			  $("#btn_prev_app_income").hide();
			  $('#showIncomeDetails').show();
		  }else{
			  $("#btn_next_app_income").show();
			  $("#btn_prev_app_income").show();
			  $('#showIncomeDetails').hide();
		  }
		$("#buttonsDiv").show();
		$("#nxtbut").show();
		// $("#backbutton").hide();
		$("#added_income").hide();
		$(".tabForms").hide();
	});
	 	 
	$("#backbutton_emp_1").click(function() {
		clearAllForms();
		// alert("clicked");
		if($("#incomeid_emp").val() ==""){
			showButtonsDiv();
		}else{
			showIncomeTableDiv();
		}
		
		return false;
	});
	$("#backbutton_rental").click(function() {
		clearAllForms();
		// alert("clicked");
		if($("#incomeid_rent").val() ==""){
			showButtonsDiv();
		}else{
			showIncomeTableDiv();
		}
		return false;
	});

	$("#backbutton_ssn").click(function() {
		clearAllForms();
		if($("#incomeid_ssn").val() ==""){
			showButtonsDiv();
		}else{
			showIncomeTableDiv();
		};
		return false;
	});
	$("#backbutton_pension").click(function() {
		clearAllForms();
		 // alert("clicked");
		if($("#incomeid_pension").val() ==""){
			showButtonsDiv();
		}else{
			showIncomeTableDiv();
		}
		return false;
	});
	$("#backbutton_other").click(function() {
		clearAllForms();
		if($("#incomeid_other").val() ==""){
			showButtonsDiv();
		}else{
			showIncomeTableDiv();
		}
		return false;
	});
}
