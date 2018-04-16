<%@include file="userShared/header.jsp" %>

<!--Page Heading-->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header" style="margin-top: 0px;">
            Hy Kate
            <small>Profile</small>
        </h1>
    </div>
</div>
<!--row-->

<ol class="breadcrumb">
    <li><a href="${SITE_URL}/admin/home">Home</a></li>
    <li class="active">Profile</li>
</ol>

<div class="row">
    <div class="col-lg-12">
        <div class="row">
            <div class="col-lg-6">
                <h2>Change Password</h2>
                <hr>
                <div class="row">
                    <div class="col-lg-2"></div>
                    <div class="col-lg-8">
                        <h4>${changePasswordMessage}</h4>
                        <spring:url value="/user/changePassword" var="changePasswordURL" />            
                        <form:form method="post" action="${changePasswordURL}" modelAttribute="user">
                            <div class="form-group">
                                <label class="control-label" for="inputOldPassword">Old Password: </label>
                                <form:input class="form-control" path="oldPassword" id="inputOldPassword" placeholder="Old Password"  type="password" required="required" />                            
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="inputPassword">New Password: </label>
                                <form:input class="form-control" path="password" id="inputPassword" placeholder="New Password"  type="password" required="required" />                            
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="inputConfirmPassword">Confirm Password: </label>
                                <form:input class="form-control" path="confirmPassword" id="inputConfirmPassword" placeholder="Confirm Password"  type="password" required="required" />                            
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-success">Change</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
            <div class="col-lg-1"></div>
            <div class="col-lg-5">
                <div class="row">
                    <div class="col-lg-12">
                        <h3>Total Calorie Consumption Value (Kcal/g)</h3>
                        <hr>
                        <c:if test="${not empty totalCalorieValue}">
                            <center><h3><b>${totalCalorieValue}</b></h3></center>
                        </c:if>
                        <c:if test="${empty totalCalorieValue}">
                            <center><h3><b>No Transaction</b></h3></center>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>            
</div>


<%@include file="userShared/footer.jsp" %>