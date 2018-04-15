<%@include file="userShared/header.jsp" %>

<!--Page Heading-->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header" style="margin-top: 0px;">
            Order History
            <small>Your ordered list</small>
        </h1>
    </div>
</div>
<!--row-->

<ol class="breadcrumb">
    <li><a href="${SITE_URL}/admin/home">Home</a></li>
    <li class="active">Order History</li>
</ol>

<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <table class="table table-striped table-hover">
            <tr>
                <th>S.N.</th>
                <th>Date</th>
                <th>Payment Method</th>
                <th>Total price</th>
                <th>Total Calorie Value</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="sEntity" items="${s}">
                <tr>
                    <c:set var="count" value="${count+1}" scope="page"/>
                    <td>${count}</td>
                    <td>${sEntity.purchasedDate}</td>
                    <td>${sEntity.paymentMethod}</td>
                    <td>${sEntity.grandTotal}</td>
                    <td>${sEntity.totalCalorieValue}</td>
                    <td>
                    <c:if test="${sEntity.purchased}">
                        <span class="label label-success">Active</span>                        
                    </c:if>
                    <c:if test="${not sEntity.purchased}">
                        <span class="label label-danger">Inactive</span>                    
                    </c:if>
                    </td>
                    <td>
                        <a href="${SITE_URL}/user/orderList/${sEntity.cartId}" class="btn btn-success btn-sm">View</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>    

<%@include file="userShared/footer.jsp" %>
