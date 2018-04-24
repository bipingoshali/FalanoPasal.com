<%@include file="userShared/header.jsp" %>

<!--Page Heading-->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header" style="margin-top: 0px;">
            <small>
                Profile
                <c:if test="${not empty rechargeMessage}">
                    ${rechargeMessage}
                </c:if>
            </small>
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
                <div class="row">
                    <div class="col-lg-12">
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
                </div>
                                
                <div class="row">
                    <div class="col-lg-12">
                        <h2>Get pin number</h2>
                        <hr>
                        <div class="row">
                            <div class="col-lg-2"></div>
                            <div class="col-lg-8">
                                <h4>${changePasswordMessage}</h4>
                                <spring:url value="/user/registerDebitAmount" var="registerDebitAmountURL" />            
                                <form:form method="post" action="${registerDebitAmountURL}" modelAttribute="user">
                                    <div class="form-group">
                                        <label class="control-label" for="inputEnterAmount">Enter amount </label>
                                        <form:input class="form-control" path="debitAmount" id="inputEnterAmount" placeholder="Enter amount"  type="number" required="required" />                            
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-success">Get Pin</button>
                                    </div>
                                </form:form>
                                <c:if test="${not empty rechargeToken}">
                                    <h3>Your recharge pin: <br>${rechargeToken}</h3>                                    
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <h2>Recharge your account</h2>
                        <hr>
                        <div class="row">
                            <div class="col-lg-2"></div>
                            <div class="col-lg-8">
                                <h4>${changePasswordMessage}</h4>
                                <spring:url value="/user/rechargeDebitAmount" var="rechargeDebitAmountURL" />            
                                <form:form method="post" action="${rechargeDebitAmountURL}" modelAttribute="user">
                                    <div class="form-group">
                                        <label class="control-label" for="inputEnterPinNumber">Enter pin number </label>
                                        <form:input class="form-control" path="rechargeToken" id="inputEnterPinNumber" placeholder="Enter pin"  type="text" required="required" />                            
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-success" onclick="return confirm('Are you sure to recharge your account')">Get Pin</button>
                                    </div>
                                </form:form>
                            </div>
                        </div>
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
                <div class="row">
                    <div class="col-lg-12">
                        <h3>Total Expenses (£)</h3>
                        <hr>
                        <center><h3><b>${totalExpense}</b></h3></center>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <h3>Total Order Count</h3>
                        <hr>
                        <center><h3><b>${userData.orderCount}</b></h3></center>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <h3>Your debit amount (£)</h3>
                        <hr>
                        <center><h3><b>${userData.debitAmount}</b></h3></center>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <h3>Your credit amount (£)</h3>
                        <hr>
                        <center><h3><b>${creditAmount}</b></h3></center>
                    </div>
                </div>
            </div>
        </div>
    </div>            
</div>

                    <!-- Footer -->

<footer>
    <div class="row">
        <div class="col-lg-12">
            <hr>
            <p>Copyright &copy; FalanoPasal.com 2018</p>
        </div>
    </div>
    <!-- /.row -->
</footer>                


<%@include file="userShared/footer.jsp" %>