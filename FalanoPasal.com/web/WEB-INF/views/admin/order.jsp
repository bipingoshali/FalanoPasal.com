<%@include file="adminShared/header.jsp" %>
<h1 class="page-header">Order List</h1>

<!--customer table--> 
<div class="row">
    <div class="col-lg-12">
        <table class="table table-striped table-hover">
            <tr>
                <th>S.N.</th>
                <th>Username</th>
                <th>Date</th>
                <th>Payment Method</th>
                <th>Total price</th>
                <th>Total Calorie Value</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="shoppingCartEntity" items="${shoppingCartList}">
            <tr>
                <c:set var="count" value="${count+1}" scope="page"/>
                <td>${count}</td>
                <td>${shoppingCartEntity.username}</td>
                <td>${shoppingCartEntity.purchasedDate}</td>
                <td>${shoppingCartEntity.paymentMethod}</td>
                <td>${shoppingCartEntity.grandTotal}</td>
                <td>${shoppingCartEntity.totalCalorieValue}</td>
                <td>
                    <c:if test="${shoppingCartEntity.purchased}">
                        <span class="label label-success">Active</span>                        
                    </c:if>
                    <c:if test="${not shoppingCartEntity.purchased}">
                        <span class="label label-danger">Inactive</span>                    
                    </c:if>                    
                </td>
                <td><a href="${SITE_URL}/admin/orderItem/${shoppingCartEntity.cartId}" class="btn btn-success btn-sm" title="View"><span class="glyphicon glyphicon-expand"></span></a></td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="adminShared/footer.jsp" %>