<%@include file="adminShared/header.jsp" %>
<h1 class="page-header">
    <div class="pull-right">
        <a class="btn btn-danger" href="${SITE_URL}/admin/order">Back</a>
    </div>
    Order Item List
</h1>

<!--customer table--> 
<div class="row">
    <div class="col-lg-12">
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
            <c:forEach var="ShoppingCartItemEntity" items="${ShoppingCartItemList}">
            <tr>
                <c:set var="count" value="${count+1}" scope="page"/>
                <td>${count}</td>
                <td>${ShoppingCartItemEntity.productName}</td>
                <td>${ShoppingCartItemEntity.quantity}</td>
                <td>${ShoppingCartItemEntity.price}</td>
                <td>${ShoppingCartItemEntity.productTotalPrice}</td>
                <td>${ShoppingCartItemEntity.totalCalorieValue}</td>                
            </tr>
            </c:forEach>
        </table>
    </div>
</div>

<%@include file="adminShared/footer.jsp" %>