<%@include file="adminShared/header.jsp" %>
<h1 class="page-header">Subscription List</h1>

<!--customer table--> 
<div class="row">
    <div class="col-lg-12">
        <table class="table table-striped table-hover">
            <tr>
                <th>S.N.</th>
                <th>Username</th>
                <th>Product</th>
                <th>Quantity</th>
                <th>Duration</th>
                <th>Date</th>
                <th>Status</th>
            </tr>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="allSPEntity" items="${allSubscribeProductList}">
            <tr>
                <c:set var="count" value="${count+1}" scope="page"/>
                <td>${count}</td>
                <td>${allSPEntity.username}</td>
                <td>${allSPEntity.productName}</td>
                <td>${allSPEntity.subscribeProductQuantity}</td>
                <td>${allSPEntity.productSubscriptionDuration}</td>
                <td>${allSPEntity.productSubscribeDate}</td>
                <td>
                    <c:if test="${allSPEntity.subscribedProductStatus}">
                        <span class="label label-success">Active</span>                        
                    </c:if>
                    <c:if test="${not allSPEntity.subscribedProductStatus}">
                        <span class="label label-danger">Inactive</span>                    
                    </c:if>                    
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>

<%@include file="adminShared/footer.jsp" %>