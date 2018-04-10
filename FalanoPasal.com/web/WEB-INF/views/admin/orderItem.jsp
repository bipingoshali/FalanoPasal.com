<%@include file="adminShared/header.jsp" %>
<h1 class="page-header">Order Item List</h1>

<!--customer table--> 
<div class="row">
    <div class="col-lg-12">
        <table class="table table-striped table-hover">
            <tr>
                <th>S.N.</th>
                <th>Username</th>
                <th>Product</th>
                <th>Quantity</th>                        
                <th>Price</th>
                <th>Total Price</th>
                <th>Calorie Value</th>
            </tr>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="ShoppingCartItemEntity" items="${ShoppingCartItemList}">
            <tr>
                <c:set var="count" value="${count+1}" scope="page"/>
                <td>${count}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>

<%@include file="adminShared/footer.jsp" %>