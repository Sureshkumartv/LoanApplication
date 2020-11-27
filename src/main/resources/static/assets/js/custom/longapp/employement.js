

function app_employment_valid(divname) {
    var datavalid = true;
    var fouusinput = false;
    return datavalid;
}
function employee_valid(divname) {
   // alert('div name :"+divname');
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

$(document).on("click", '.jsondata', function (event) {
    var index_id = $(this).attr("id");
    var formData1 = new FormData();
    formData1.append("incomeid", index_id);
    formData1.append("lead_id", lead_id);
    formData1.append("call", 'income'); 
    $.ajax({
        type: "POST", url: base_url + "application/incomeapp", cache: false, contentType: false, processData: false,
        data: formData1, dataType: "json",
        success: function (data) {
            console.log(data);

            if (data.lead_id == "")
            {
                appLoading.html("Their is error while submitting application. please contact us");
                curLi.addClass("active");
            } else {
                if (lead_id == "") {
                    window.location = base_url + "newloan";
                } else {
                    lead_id = data.lead_id;

                    console.log(data.data);
                    var jsonresp = data.data;
                    if (jsonresp.BE0001 == "Rent")
                    { 
                        $("#added_income").hide();
                        $("#incomeid_rent").val(jsonresp.id);
                        $('#borrower_rent_type').val(jsonresp.BE0032);
                        $('#borrower_rent_value').val(jsonresp.BE0030);
                        $('#borrower_employer_rent_income').val(jsonresp.BE0119);
                        $("#employment_owner_rent").val(jsonresp.owner);
                        $("#borrower_prop_address_1").val(jsonresp.BE0034);
                        $("#borrower_prop_city_1").val(jsonresp.BE0035);
                        $("#borrower_prop_state_1").val(jsonresp.BE0036);
                        $("#borrower_prop_zip_1").val(jsonresp.BE0037);
                        $('#borrower_rent_mortgages').val(jsonresp.BE0031);



                        // ('#form_rent_app_employement').append('<input type="hidden"
                        // name="borrower_id" value='+data.id+'>');
                        $("#emp_div").hide();
                        $("#rental_div").show();
                        $("#social_div").hide()
                        $("#pension_div").hide();
                        $("#others_div").hide();
                    }
                    if (jsonresp.BE0001 == "Employee")
                    {
                        $("#incomeid_emp").val(jsonresp.id);
                        $("#added_income").hide();
                        $("#rental_div").hide();
                        $("#social_div").hide()
                        $("#pension_div").hide();
                        $("#others_div").hide();
                        $("#emp_div").show();
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
                    }
                    if (jsonresp.BE0001 == "SSN")
                    {
                        $("#employment_owner_ssn").val(jsonresp.owner);
                        $("#incomeid_ssn").val(jsonresp.id);
                        $("#added_income").hide();
                        $("#emp_div").hide();
                        $("#rental_div").hide();
                        $("#pension_div").hide();
                        $("#others_div").hide();
                        $("#social_div").show()
                        $("#borrower-social-security").val(jsonresp.BE0119);
                    }
                    if (jsonresp.BE0001 == "Pension")
                    {
                        $("#employment_owner_pen").val(jsonresp.owner);
                        $("#added_income").hide();
                        $("#emp_div").hide();
                        $("#rental_div").hide();
                        $("#social_div").hide()
                        $("#others_div").hide();
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
                    if ((jsonresp.BE0001 == "Alimony / Child Support" || jsonresp.BE0001 == "Annuity" || jsonresp.BE0001 == "Deferred Compensation" || jsonresp.BE0001 == "Interest / Dividends " || jsonresp.BE0001 == "Other"))
                    {
                        $("#added_income").hide();
                        $("#emp_div").hide();
                        $("#rental_div").hide();
                        $("#social_div").hide()
                        $("#pension_div").hide();
                        $("#others_div").show();
                        $("#incomeid_other").val(jsonresp.id);
                        $("#employment_owner_other").val(jsonresp.owner);
                        $("#borrower_employment_type_other").val(jsonresp.BE0001);
                        $("#borrower_employer_base_income_other").val(jsonresp.BE0119);

                    }
                }

            }
        }, error: function (data) {
            console.log(data);
        }

    });

});
$(document).on("click", '.jsondatadelete', function (event) {
    var index_id = $(this).attr("id");
    var formData1 = new FormData();
    formData1.append("incomeid", index_id);
    formData1.append("lead_id", lead_id);
    formData1.append("call", 'income');

    $.ajax({
        type: "POST", url: base_url + "application/delete", cache: false, contentType: false, processData: false,
        data: formData1, dataType: "json",
        success: function (data) {
            console.log(data);

            if (data.lead_id == "")
            {
                appLoading.html("Their is error while submitting application. please contact us");
                curLi.addClass("active");
            } else {
                if (lead_id == "") {
                    window.location = base_url + "application/curapp";
                } else {
                    lead_id = data.lead_id;

                    console.log(data);
                    var jsonresp = data.data;
                    var json = data.data;
                    // (json.length);
                    $('#location1 tbody>tr').remove();
                    if (json.length > 0)
                    {

                        // $("#btn_adincome").show();


                        var tr = null;
                        for (var i = 0; i < json.length; i++) {
                            tr = $('<tr/>');
                            if (json[i].owner == "Borrower")
                            {

                                tr.append("<td class='text-center'>" + borrower_full_name + "</td>");
                            } else if (json[i].owner == "Co-Borrower")
                            {
                                tr.append("<td class='text-center'>" + co_borrower_full_name + "</td>");
                            }
                            tr.append("<td class='text-center'>" + json[i].BE0001 + "</td>");
                            tr.append("<td class='text-center'>" + json[i].BE0119 + "</td>");

                            tr.append("<td><span class='jsondata my-edit text-center' id='" + json[i].id + "'>Edit</span></td>");
                            tr.append("<td><span class='jsondatadelete my-edit text-center' id='" + json[i].id + "'>Edit</span></td></tr>");
                            $('tbody').first().append(tr);
                        }

                    }

                }
            }
        }, error: function (data) {
            console.log(data);
        }

    });

});


$(document).ready(function () {
    $(".date").datepicker({
    });

    $(".btn_add_income").click(function () {
        // alert("clicked income");
        $('#form_employee_app_employement').append('<input type="hidden" name="borrower_employment_type" value="Employee">');
        button_income_click("employement");
        return false;
    });
    $(".btn_add_rent").click(function () {
        // alert("clicked rent");
        $('#form_rent_app_employement').append('<input type="hidden" name="borrower_employment_type" value="Rent">');
        button_income_click("rent");
        return false;
    });
    $(".btn_add_pension").click(function () {
        // alert("clicked pension");
        $('#form_pension_app_employement').append('<input type="hidden" name="borrower_employment_type" value="Pension">');
        button_income_click("pension");
        return false;
    });
    $(".btn_add_ssn").click(function () {
        // alert("clicked ssn");
        $('#form_ssn_app_employement').append('<input type="hidden" name="borrower_employment_type" value="SSN">');
        button_income_click("ssn");
        return false;
    });
    $(".btn_add_other").click(function () {
        // alert("clicked other");
// $('#form_other_app_employement').append('<input type="hidden"
// name="borrower_employment_type" value="ssn">');
        button_income_click("other");
        return false;
    });



    var formData1 = new FormData();
    // formData1.append("incomeid",index_id);
    formData1.append("lead_id", lead_id);
    formData1.append("call", 'income');

    $.ajax({
        type: "POST", url: base_url + "application/loaddata", cache: false, contentType: false, processData: false,
        data: formData1, dataType: "json",
        success: function (data) {
            console.log(data);
            // nextBtnObj.show();
            if (data.lead_id == "")
            {
                appLoading.html("Their is error while submitting application. please contact us");
                curLi.addClass("active");
            } else {
                if (lead_id == "") {
                    window.location = base_url + "application/curapp";
                } else {
                    lead_id = data.lead_id;


                    console.log(data.data);
                    var json = data.data;
                    // (json.length);
                    $('#location1 tbody>tr').remove();
                    if (json.length > 0)
                    {

                        // $("#btn_adincome").show();
                        $("#emp_div").hide();
                        $("#rental_div").hide();
                        $("#social_div").hide()
                        $("#pension_div").hide();
                        $("#others_div").hide();
                        $("#buttonsDiv").hide();
                        $("#added_income").show();
                        $("#nxtbut").hide();

                        var tr = null;
                        for (var i = 0; i < json.length; i++) {
                            tr = $('<tr/>');
                            if (json[i].owner == "Borrower")
                            {

                                tr.append("<td class='text-center'>" + borrower_full_name + "</td>");
                            } else if (json[i].owner == "Co-Borrower")
                            {
                                tr.append("<td class='text-center'>" + co_borrower_full_name + "</td>");
                            }
                            tr.append("<td class='text-center'>" + json[i].BE0001 + "</td>");
                            tr.append("<td class='text-center'>" + json[i].BE0119 + "</td>");

                            tr.append("<td><span class='jsondata my-edit text-center' id='" + json[i].id + "'>Edit</span>/<span class='jsondatadelete' id='" + json[i].id + "'><i class='fa fa-trash' style='font-size:36px,color:red;'></i></span></td></tr>");
                            tr.append("");
                            $('tbody').first().append(tr);
                        }
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


});
    

    function button_income_click(btnid) {
       // alert("clicked " + btnid);
        // btn_add_income_app_pension
        try {
            var nextBtnObj = $("#" + btnid);
            nextBtnObj.hide();
            var cur_pos = "app_income"
            //alert(cur_pos);
            var curLi = $("#li_" + cur_pos);
            var curTabName = curLi.find("span")[0].innerHTML;
            var nextLi = curLi.next();
            var next_pos = "";
            if (cur_pos == "app_confirmation") {
                next_pos = "app_confirmation";
            } else {
                next_pos = nextLi.attr("id").replace("li_", "");
            }
            //alert('next_pos ' + next_pos);
           
            var validdata = true;
            var curForm = $(".income_form" ).find("form");
            console.log(curForm);
            var formData = new FormData();
            if (btnid == "employement") {
                validdata = employee_valid();
                formData = new FormData(curForm[0]);
            } else if (btnid == "rent")
            {
                validdata = rent_valid();
                formData = new FormData(curForm[1]);
            } else if (btnid == "pension")
            {
                validdata = pension_valid();
                formData = new FormData(curForm[2]);
            } else if (btnid == "ssn")
            {
                validdata = ssn_valid();
                formData = new FormData(curForm[3]);
            } else if (btnid == "other")
            {
                validdata = other_valid();
                formData = new FormData(curForm[4]);
            }
            console.log('valid :' + validdata)
            if (validdata) {
            	 console.log(formData);
            	  var json = JSON.stringify(serializeForm(formData));
            	 console.log('----json------   ' + json);
            	  let newFormData = new FormData();
            	  newFormData.append("request", json);
            	  newFormData.append("curPos", cur_pos);
                  newFormData.append("nextPos", next_pos);
            	  newFormData.append("leadId", lead_id);
            	  newFormData.append("incomeType", btnid);

                for (var value of newFormData.values()) {
                    console.log(value);
                }

              //  alert(cur_pos);
                
                
                $.ajax({
                    type: "POST", url: base_url + "submitapp/"+curPos, cache: false, contentType: false, processData: false,
                    data: JSON.stringify(serializeForm(newFormData)), dataType: "json",
                    success: function (data) {
                        // console.log(data);
                        $('#borrower_rent_type').val('');
                        $('#borrower_rent_value').val('');
                        $('#borrower_employer_rent_income').val('');
                        $("#borrower-social-security").val('');
                        $('#borrower_rent_mortgages').val('');
                        $("#borrower_employer_name_pension").val('');
                        $("#borrower-pension").val('');
                        $("#borrower-retire-date_pension").val('');
                        $("#borrower_employer_base_income_other").val('');
                        $("#borrower_prop_address_1").val('');
                        $("#borrower_prop_city_1").val('');
                        $("#borrower_prop_state_1").val('');
                        $("#borrower_prop_zip_1").val('');
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
                        nextBtnObj.show();
                        if (data.lead_id == "")
                        {
                            appLoading.html("Their is error while submitting application. please contact us");
                            curLi.addClass("active");
                        } else {
                            if (lead_id == "") {
                                window.location = base_url + "application/curapp";
                            } else {
                                lead_id = data.lead_id;
                                if (app_tab_pos != "app_confirmation") {
                                    app_tab_pos = next_pos;
                                }
                                console.log(data.data);
                                var json = data.data;
                                $('#location1 tbody>tr').remove();
                                var tr = null;
                                for (var i = 0; i < json.length; i++) {
                                    tr = $('<tr/>');
                                    if (json[i].owner == "Borrower")
                                    {

                                        tr.append("<td class='text-center'>" + borrower_full_name + "</td>");
                                    } else if (json[i].owner == "Co-Borrower")
                                    {
                                        tr.append("<td class='text-center'>" + co_borrower_full_name + "</td>");
                                    }
                                    tr.append("<td class='text-center'>" + json[i].BE0001 + "</td>");
                                    tr.append("<td class='text-center'>" + json[i].BE0119 + "</td>");
                                    tr.append("<td><span class='jsondata my-edit text-center' id='" + json[i].id + "'>Edit</span></td>");
                                    tr.append("<td><span class='jsondatadelete my-edit text-center' id='" + json[i].id + "'>Edit</span></td></tr>");
                                    $('tbody').first().append(tr);
                                }
                                $("#added_income").show();
                                $("#nxtbut").hide();

                                $("#buttonsDiv").hide();
                                $("#backbutton").show();
                                $(".tabForms").hide();

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

