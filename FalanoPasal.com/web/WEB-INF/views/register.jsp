<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FalanoPasal.com</title>

        <!-- Bootstrap core CSS -->
        <link href="${SITE_URL}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- Custom CSS -->
        <link href="${SITE_URL}/static/css/custom.css" rel="stylesheet" type="text/css" />

    </head>
    <body style="background-color: #f9f9f9;height: 1000px;">
        <div class="container" style="padding-top: 15px;">
            <h1 style="text-align: center;margin: 40px 0px 30px 0px;">Join FalanoPasal</h1>
            <div class="panel panel-primary" style="width:900px;margin:0px auto;padding:10px;">
                <div class="panel-heading">Register your account</div>
                <div class="panel-body">
                    <spring:url value="/registerSave" var="registerURL" />
                    <form:form method="post" action="${registerURL}" modelAttribute="user">
                        <div class="row"> 

                            <div class="col-md-6">

                                <!--Name field-set-->
                                <fieldset style="margin-top:10px;margin-bottom:10px;">    	
                                    <legend>Name</legend>
                                    <div class="panel panel-primary">
                                        <div class="panel-body">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="control-label" for="inputFirstName">First Name</label>
                                                    <form:input class="form-control" path="firstName" data-error="Please enter name field." id="inputFirstName" placeholder="First Name"  type="text" required="required" />
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="control-label" for="inputLastName">Last Name</label>
                                                    <form:input class="form-control" path="lastName" data-error="Please enter name field." id="inputLastName" placeholder="Last Name"  type="text" required="required" />
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>

                                <!--Email field-set-->                    
                                <fieldset style="margin-top:10px;margin-bottom:10px;">    	
                                    <legend>Email</legend>
                                    <div class="panel panel-primary">
                                        <div class="panel-body">
                                            <div class="form-group">
                                                <label class="control-label" for="inputEmail">Email</label>
                                                <form:input class="form-control" path="email" data-error="Please enter name field." id="inputEmail" placeholder="Email"  type="email" required="required" />
                                                <div class="help-block with-errors"></div>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>	

                                <!--Login field-set-->                    
                                <fieldset style="margin-top:10px;margin-bottom:10px;">    	
                                    <legend>Login Details</legend>
                                    <div class="panel panel-primary">
                                        <div class="panel-body">
                                            <div class="form-group">
                                                <label class="control-label" for="inputUserName">Username</label>
                                                <form:input class="form-control" path="username" data-error="Please enter name field." id="inputUserName" placeholder="Username"  type="text" required="required" />
                                                <div id="id_res_div" style="color: red;"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label" for="inputPassword">Password</label>
                                                        <form:input class="form-control" path="password" data-error="Please enter name field." id="inputPassword" placeholder="Password"  type="password" required="required" />
                                                        <div class="help-block with-errors"></div>
                                                    </div>								
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label" for="inputConfirmPassword">Confirm Password</label>
                                                        <input class="form-control" data-error="Please enter name field." id="inputConfirmPassword" placeholder="Confirm Password"  type="password" required="required" />
                                                        <div id="id_password_div" style="color: red;"></div>
                                                    </div>																
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>	

                            </div> <!--/.col-md-6-->

                            <div class="col-md-6">
                                <!--Address field-set-->
                                <fieldset style="margin-top:10px;margin-bottom:10px;">    	
                                    <legend>Address</legend>
                                    <div class="panel panel-primary">
                                        <div class="panel-body">
                                            <div class="form-group">
                                                <label class="control-label" for="selectCity">City</label>								
                                                <form:select class="form-control" path="city" id="selectCity" required="required">
                                                    <option value="Kathmandu">Kathmandu</option>
                                                    <option value="Lalitpur">Lalitpur</option>
                                                    <option value="Bhaktapur">Bhaktapur</option>
                                                </form:select>
                                                <div class="help-block with-errors"></div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label" for="inputAddressLine1">Address Line 1</label>
                                                <form:input class="form-control" path="addressline1" data-error="Please enter name field." id="inputAddressLine1" placeholder="Address Line 1"  type="text" required="required" />
                                                <div class="help-block with-errors"></div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label" for="inputAddressLine2">Address Line 2</label>
                                                        <form:input class="form-control" path="addressline2" data-error="Please enter name field." id="inputAddressLine2" placeholder="Address Line 2"  type="text" required="required" />
                                                        <div class="help-block with-errors"></div>
                                                    </div>                                        
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-group">
                                                        <label class="control-label" for="inputHouseNo">House No.</label>
                                                        <form:input class="form-control" path="houseno" data-error="Please enter name field." id="inputHouseNo" placeholder="House No."  type="number" required="required" />
                                                        <div class="help-block with-errors"></div>
                                                    </div>                                        
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>		

                                <!--Other Information field set-->
                                <fieldset style="margin-top:10px;margin-bottom:10px;">    	
                                    <legend>Other Information</legend>
                                    <div class="panel panel-primary">
                                        <div class="panel-body">
                                            <div class="form-group">
                                                <label class="control-label" for="inputPhoneNumber">Phone Number</label>
                                                <form:input class="form-control" path="phoneno" data-error="Please enter name field." id="inputPhoneNumber" placeholder="Phone Number"  type="number" required="required" />
                                                <div class="help-block with-errors"></div>
                                            </div>
                                            <div class="form-group">
                                                <label class="control-label" for="inputBirthDate">Birth date</label>
                                                <form:input class="form-control" path="birthdate" data-error="Please enter name field." id="inputBirthDate"  type="date" required="required" />
                                                <div class="help-block with-errors"></div>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>		

                            </div> <!--/.col-md-6-->
                        </div> <!--/.row-->

                        <div class="form-group">
                            <button class="btn btn-primary" type="submit" >
                                Submit
                            </button>
                            <button class="btn btn-danger" type="reset">
                                Reset
                            </button>
                            <a class="btn btn-success" role="button" href="${SITE_URL}/">
                                <span class="glyphicon glyphicon-home"></span>
                            </a>
                        </div>
                        <div>
                            <p>Already have an account? <a href="${SITE_URL}/login">Sign in</a>.</p>
                        </div>

                    </form:form>

                </div> <!--/.panel-body-->
            </div> <!--/.panel-primary-->
        </div> <!--/.container-->

    </body>