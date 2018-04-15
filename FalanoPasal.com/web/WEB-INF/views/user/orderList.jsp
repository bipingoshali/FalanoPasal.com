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
    <li><a href="${SITE_URL}/user/home">Home</a></li>
    <li><a href="${SITE_URL}/user/orderHistory">Order History</a></li>
    <li class="active">Order List</li>
</ol>

<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <table class="table table-striped table-hover">
            <tr>
                <th>S.N.</th>
                <th>Product Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total Price</th>
                <th>Total Calorie</th>
            </tr>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="sEntity" items="${s}">
                <tr>
                    <c:set var="count" value="${count+1}" scope="page"/>
                    <td>${count}</td>
                    <td>${sEntity.productName}</td>
                    <td>${sEntity.quantity}</td>
                    <td>${sEntity.price}</td>
                    <td>${sEntity.productTotalPrice}</td>
                    <td>${sEntity.totalCalorieValue}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>    

<%@include file="userShared/footer.jsp" %>