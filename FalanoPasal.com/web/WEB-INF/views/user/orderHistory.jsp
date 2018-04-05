<%@include file="userShared/header.jsp" %>

<!--Page Heading-->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header" style="margin-top: 0px;">
            ${product.category.categoryName}
            <small>Select product</small>
        </h1>
    </div>
</div>
<!--row-->

<ol class="breadcrumb">
    <li><a href="${SITE_URL}/admin/home">Home</a></li>
    <li class="active">Order History</li>
</ol>

<div class="row">
    <div class="col-lg-12">
        <table class="table table-striped table-hover">
            <tr>
                <th>S.N.</th>
                <th>Product name</th>
                <th>Quantity</th>
                <th>Total price</th>
                <th>Total Calorie Value</th>
            </tr>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="sEntity" items="${s}">
                <tr>
                    <c:set var="count" value="${count+1}" scope="page"/>
                    <td>${count}</td>
                    <td>${sEntity.productId}</td>
                    <td>${sEntity.quantity}</td>
                    <td>${sEntity.productTotalPrice}</td>
                    <td>${sEntity.totalCalorieValue}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>    

<%@include file="userShared/footer.jsp" %>
