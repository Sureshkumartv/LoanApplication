

$(document).ready(function () {
    $("#li_app_preview").click(function () {
        // location.reload();
    });
    // alert(app_pos);

// console.log(co_borrower_status+"loaded");
// alert(co_borrower_status);
    $('.app-tabs a[data-toggle="tab"]').bind('click', function (e) {
        var tab = $(this);
        console.log(tab);
        var contentId = tab.attr("href");
        var cur_pos = contentId.replace("#", "");
        // alert('cur pos '+cur_pos);
        var loadattr = $("#" + cur_pos).attr("load");
        // This check if the tab is active
        if ($("#li_" + cur_pos).hasClass("disabled")) {
            return false;
        } else {
            loadCurrentPage(cur_pos);
        }

    });
    console.log("app_tab_pos::" + app_tab_pos);
    defaultFunctions();
    $("#app_loading").removeClass("active");
    $("#" + app_tab_pos).attr("load", "y");
    $("#" + app_tab_pos).addClass("active");
    $("#li_" + app_tab_pos).removeClass("disabled").addClass("active");

});
 
$("li").each(function (index) {
    if ($(this).hasClass("active"))
    {
        $(".badge_cir").hide();
    }
    if ($(this).hasClass("test"))
    {
        $(".badge_cir").show();
    }
    if ($(this).hasClass("disabled"))
    {
        $(".badge_cir").hide();
    } else
    {
        $(".badge_cir").show();
    }
});
function loadCurrentPage(cur_pos) {
    showLoadinDiv();
    $cur_posdiv = $("#" + cur_pos);
    var curLi = $("#li_" + cur_pos);
    // alert('cur pos '+cur_pos);
    curLi.removeClass("disabled");
    var curTabName = curLi.find("span")[0].innerHTML;
    // var appLoading=$("#app_loading");
    // appLoading.html("Loading "+curTabName+" Data ...");
    var formData = new FormData();
    formData.append("curPos", cur_pos);
    formData.append("leadId", lead_id);

    console.log(formData);
    console.log('base url ' + base_url);
    $.ajax({type: "POST", url: base_url + "loadpage", cache: false, contentType: false, processData: false, data: formData,
        success: function (data) {
            $cur_posdiv.attr("load", "y");
            $cur_posdiv.html(data);
            defaultFunctions();
        }
    });
}
$("li").each(function (index) {
    if ($(this).hasClass("active"))
    {
        $(".badge_cir").hide();
    }
    if ($(this).hasClass("test"))
    {
        $(".badge_cir").show();
    }
    if ($(this).hasClass("disabled"))
    {
        $(".badge_cir").hide();
    } else
    {
        $(".badge_cir").show();
    }
});

function showLoadinDiv() {
    $(".tab-pane").removeClass("active");
    $("#app_loading").addClass("active");
}
var serializeForm = function (newFormData) {
    var obj = {};
    for (var key of newFormData.keys()) {
        obj[key] = newFormData.get(key);
    }
    return obj;
};
function button_next_click(btnid) {
    console.log('coming  ' + btnid);
    try {
        var nextBtnObj = $("#" + btnid);
        nextBtnObj.hide();
        var cur_pos = btnid.replace("btn_next_", "");
        // alert(cur_pos);
        var curLi = $("#li_" + cur_pos);
        console.log(curLi);
        var curTabName = curLi.find("span")[0].innerHTML;
        // alert(curTabName);
        var nextLi = curLi.next();
        if(nextLi.hasClass("remove")){
        	nextLi =nextLi.next();
        }
        var next_pos = "";
        if (cur_pos == "app_confirmation") {
            next_pos = "app_confirmation";
        } else {
            next_pos = nextLi.attr("id").replace("li_", "");
        }

        var validationFun = cur_pos + "_valid";
        console.log(validationFun);
        var validdata = true;
        if (typeof window[validationFun] == "function") {
            validdata = window[validationFun](cur_pos);
        }
        if (validdata) {
            var appLoading = $("#app_loading");
            // appLoading.html("Submitting "+curTabName+" Data ...");
            showLoadinDiv();
            var curForm = $("#" + cur_pos).find("form");
            // alert(cur_pos);
            if ((cur_pos == "app_assets") || (cur_pos == "app_employement"))
            {
                var formData = new FormData();
            } else
            {
                var formData = new FormData(curForm[0]);
            }

            for (var value of formData.values()) {
                console.log(value);
            }
            // alert(co_borrower_status);
            if (co_borrower_status == "on")
            {

                if (document.getElementById("co-borrower-info") !== null)
                {

                    $("#co-borrower-info").show();
                }


            } else
            {
                $("#co-borrower-info").hide();
            }

            var object = {};
            formData.forEach((value, key) => {
                object[key] = value
            });
            var json = JSON.stringify(object);
            console.log('----json------   ' + json);
            let newFormData = new FormData();
            newFormData.append("request", json);
            newFormData.append("curPos", cur_pos);
            newFormData.append("nextPos", next_pos);
            newFormData.append("leadId", lead_id);
 
            $.ajax({
                type: "POST", url: base_url + "submitapp/" + cur_pos, cache: false, contentType: false, processData: false,
                data: JSON.stringify(serializeForm(newFormData)),
                success: function (data) {
                    nextBtnObj.show();
                    if (data.leadId == "")
                    {
                        appLoading.html("Their is error while submitting application. please contact us");
                        curLi.addClass("active");
                    } else {
                        if (lead_id == "") {
                            window.location = base_url + "newloan";
                        } else {
                            lead_id = data.leadId;
                            if (app_tab_pos != "app_confirmation") {
                                app_tab_pos = next_pos;
                            }
                            curLi.addClass("test");
                            isApplicaitonSubmit();
                            nextLi.removeClass("disabled");
                            // console.log(nextLi);
                            // alert(a[data-toggle="tab"]);
                            nextLi.find('a[data-toggle="tab"]').click();

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

function button_prev_click(btnid) {
    try {
        var cur_pos = btnid.replace("btn_prev_", "");
        console.log(cur_pos);
        var prevLi = $("#li_" + cur_pos).prev();
        if(prevLi.hasClass("remove")){
        	prevLi =prevLi.prev();
        }
        console.log(prevLi);
        var prev_pos = prevLi.attr("id").replace("li_", "");
       
        prevLi.find('a[data-toggle="tab"]').click();
    } catch (ex) {
        console.log(ex);
    }
}

function isApplicaitonSubmit() {
    if (app_tab_pos == "app_confirmation") {
        $(".submitapp").remove();
        $(".tab-content input").prop('disabled', true);
        $(".tab-content select").prop('disabled', true);
        $(".tab-content textarea").prop('disabled', true);

    }
}
function defaultFunctions() {
    isApplicaitonSubmit();
    $(".btn_next").click(function () {
        button_next_click(this.id);

        return false;
    });
    $(".btn_previous").click(function () {
        button_prev_click(this.id);
        return false;
    });
    maskinputs();

}
function maskinputs() {
    $(".date").mask("99/99/9999", {autoclear: false});
    $(".phone").mask("(999) 999-9999", {autoclear: false});

    $(".phoneext").mask("(999) 999-9999? x99999", {autoclear: false});
    $(".ssn").mask("999-99-9999", {autoclear: false});
    $(".zip").mask("99999", {autoclear: false});
    $(".year").autoNumeric('init', {mDec: 0, vMax: 99, placeholder: "YY"});
    $(".month").autoNumeric('init', {mDec: 0, vMax: 99, placeholder: "MM"});
    $(".monthandyear").mask("99/9999", {placeholder: "MM/YYYY"});
    $(".money").autoNumeric('init', {mDec: 0, vMax: 99999999, aSign: '$', pSign: 'p'});
    $(".number").autoNumeric('init', {mDec: 0});
    $(".digits").autoNumeric('init', {mDec: 0, aSep: ''});
    $(".intrest").autoNumeric('init', {mDec: 4});
    $(".rate").autoNumeric('init', {mDec: 3});
    $(".percent").autoNumeric('init', {mDec: 2, aSign: '%', pSign: 's'});
    $(".tin").mask("99-9999999");
    $(".zip-code").mask("99999");
    $(".phone").focus(function () {
        var input = this;
        setTimeout(function () {
            input.setSelectionRange(0, 0);
        }, 0);
    });

}
$.fn.setCursorPosition = function (pos) {
    this.each(function (index, elem) {
        if (elem.setSelectionRange) {
            elem.setSelectionRange(pos, pos);
        } else if (elem.createTextRange) {
            var range = elem.createTextRange();
            range.collapse(true);
            range.moveEnd('character', pos);
            range.moveStart('character', pos);
            range.select();
        }
    });
    return this;
}