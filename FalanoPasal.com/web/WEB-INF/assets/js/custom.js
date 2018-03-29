
$(document).ready(function(){

    //Register form 
    //keyup function validates the data when the user starts to type
    //blur funtion works when the input field is left null
    
    $("#inputFirstName").keyup(function(){
        if(/^[a-zA-z]+$/.test($(this).val()) && $(this).val().trim()!==""){
            $(this).css("border-color","#00E640");
        }else{
            $(this).css("border-color","red");	
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });
    $("#inputFirstName").blur(function(){
        if(/^[a-zA-z]+$/.test($(this).val()) && $(this).val().trim()!==""){
            $(this).css("border-color","#00E640");
        }else{
            $(this).css("border-color","red");			
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });
    $("#inputLastName").keyup(function(){
        if(/^[a-zA-z]+$/.test($(this).val()) && $(this).val().trim()!==""){
            $(this).css("border-color","#00E640");
        }else{
            $(this).css("border-color","red");
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });
    $("#inputLastName").blur(function(){
        if(/^[a-zA-z]+$/.test($(this).val()) && $(this).val().trim()!==""){
            $(this).css("border-color","#00E640");
        }else{
            $(this).css("border-color","red");	
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });
    $("#inputEmail").keyup(function () {
        if (/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/.test($(this).val()) && $(this).val() !== "" && $(this).val().trim() !== "") {
            $(this).css("border-color", "#00E640");
        } else {
            $(this).css("border-color", "red");
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });
    $("#inputEmail").blur(function () {
        if (/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/.test($(this).val()) && $(this).val() !== "" && $(this).val().trim() !== "") {
            $(this).css("border-color", "#00E640");
        } else {
            $(this).css("border-color", "red");
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });
    $("#inputPassword").keyup(function(){
        if($(this).val()!=="" && $(this).val().trim()!==""){
            $(this).css("border-color", "#00E640");
        } else {
            $(this).css("border-color", "red");
            $(':input[type="submit"]').prop('disabled', true);			           
        }
    });
    $("#inputPassword").blur(function(){
        if($(this).val()!=="" && $(this).val().trim()!==""){
            $(this).css("border-color", "#00E640");
        } else {
            $(this).css("border-color", "red");
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });
    $("#inputConfirmPassword").keyup(function () {
        a = $(this).val();
        b = $("#inputPassword").val();
        if (a === b) {
            $(this).css("border-color", "#37ff00");
            $("#inputPassword").css("border-color", "#37ff00");
        } else {
            $(this).css("border-color", "red");
            $("#inputPassword").css("border-color", "red");
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });    
    $("#inputConfirmPassword").blur(function () {
        a = $(this).val();
        b = $("#inputPassword").val();
        if (a === b) {
            $(this).css("border-color", "#37ff00");
            $("#inputPassword").css("border-color", "#37ff00");
        } else {
            $(this).css("border-color", "red");
            $("#inputPassword").css("border-color", "red");
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });
    $("#inputAddressLine1").keyup(function(){
        if($(this).val()!=="" && $(this).val().trim()!==""){
            $(this).css("border-color", "#00E640");
        } else {
            $(this).css("border-color", "red");
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });
    $("#inputAddressLine1").blur(function(){
        if($(this).val()!=="" && $(this).val().trim()!==""){
            $(this).css("border-color", "#00E640");
        } else {
            $(this).css("border-color", "red");
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });
    $("#inputAddressLine2").keyup(function(){
        if($(this).val()!=="" && $(this).val().trim()!==""){
            $(this).css("border-color", "#00E640");
        } else {
            $(this).css("border-color", "red");
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });
    $("#inputAddressLine2").blur(function(){
        if($(this).val() !== "" && $(this).val().trim() !== "") {
            $(this).css("border-color", "#00E640");
        } else {
            $(this).css("border-color", "red");
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });
    $("#inputPhoneNumber").keyup(function () {
        
//        check if all the input fields are filled up or not
//        if it is not filled up then a error message will pop out
        if ($("#inputFirstName").val() === ""
                | $("#inputLastName").val() === ""
                | $("#inputEmail").val()===""
                | $("#inputUserName").val()===""
                | $("#inputPassword").val()===""
                | $("#inputConfirmPassword").val()===""
                | $("#inputAddressLine1").val()===""
                | $("#inputAddressLine2").val()===""
                | $("#inputBirthDate").val()==="") 
        {
            $("#id_required_message").html("Please fill the remaining details");
        }
        else {
            $("#id_required_message").html("");
            if (/^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$/.test($(this).val()) && $(this).val().trim() !== "") {
                $(this).css("border-color", "#00E640");
                $(':input[type="submit"]').prop('disabled', false);
            } else {
                $(this).css("border-color", "red");
                $(':input[type="submit"]').prop('disabled', true);
            }
        }
    });    
    $("#inputPhoneNumber").blur(function () {
        if ($("#inputFirstName").val() === ""
                | $("#inputLastName").val() === ""
                | $("#inputEmail").val()===""
                | $("#inputUserName").val()===""
                | $("#inputPassword").val()===""
                | $("#inputConfirmPassword").val()===""
                | $("#inputAddressLine1").val()===""
                | $("#inputAddressLine2").val()===""
                | $("#inputBirthDate").val()==="") 
        {
            $("#id_required_message").html("Please fill the remaining details");
        }
        else {
            $("#id_required_message").html("");
            if (/^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$/.test($(this).val()) && $(this).val().trim() !== "") {
                $(this).css("border-color", "#00E640");
                $(':input[type="submit"]').prop('disabled', false);
            } else {
                $(this).css("border-color", "red");
                $(':input[type="submit"]').prop('disabled', true);
            }
        }
    });
    $("#inputBirthDate").blur(function () {
        var timestamp = Date.parse($("input[id='inputBirthDate']").val());

        if (isNaN(timestamp) === false) {
            $(this).css("border-color", "#00E640");
        } else {
            $(this).css("border-color", "red");
            $(':input[type="submit"]').prop('disabled', true);			            
        }
    });
    $("#inputUserName").keyup(function () {
        $.ajax({
            url: 'check_username',
            data: {username: $("#inputUserName").val()},
            success: function (data) {
                if(data){
                    $("#inputPassword").prop('disabled', true);			                            
                    $("#inputConfirmPassword").prop('disabled', true);			                            
                    $("#id_res_div").html(data);                    
                }else{
                    $("#inputPassword").prop('disabled', false);			                            
                    $("#inputConfirmPassword").prop('disabled', false);			                            
                    $("#id_res_div").html(data);                                        
                }
            }
        });
    });    
    $("#inputUserName").blur(function () {
        $.ajax({
            url: 'check_username',
            data: {username: $("#inputUserName").val()},
            success: function (data) {
                if(data){
                    $("#inputPassword").prop('disabled', true);			                            
                    $("#inputConfirmPassword").prop('disabled', true);			                            
                    $("#id_res_div").html(data);                    
                }else{
                    $("#inputPassword").prop('disabled', false);			                            
                    $("#inputConfirmPassword").prop('disabled', false);			                            
                    $("#id_res_div").html(data); 
                }
            }
        });        
    });
    
    
    
    
});

