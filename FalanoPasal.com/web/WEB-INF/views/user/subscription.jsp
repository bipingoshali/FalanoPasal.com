<%@include file="userShared/header.jsp" %>

<!--Page Heading-->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header" style="margin-top: 0px;">
            Subscription List
            <small>Subscribed products</small>
        </h1>
    </div>
</div>
<!--row-->

<ol class="breadcrumb">
    <li><a href="${SITE_URL}/admin/home">Home</a></li>
    <li class="active">Subscription List</li>
</ol>

<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <table class="table table-striped table-hover">
            <tr>
                <th>S.N.</th>
                <th>Product Name</th>
                <th>Quantity</th>
                <th>Duration</th>
                <th>Date</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="splEntity" items="${subscribedProductList}">
                <tr>
                    <c:set var="count" value="${count+1}" scope="page"/>
                    <td>${count}</td>
                    <td>${splEntity.productName}</td>
                    <td>${splEntity.subscribeProductQuantity}</td>
                    <td>${splEntity.productSubscriptionDuration}</td>
                    <td>${splEntity.productSubscribeDate}</td>
                    <td>
                        <c:if test="${splEntity.subscribedProductStatus}">
                            <span class="label label-success">Active</span>                        
                        </c:if>
                        <c:if test="${not splEntity.subscribedProductStatus}">
                            <span class="label label-danger">Inactive</span>                    
                        </c:if>                        
                    </td>
                    <td>
                        <a href="${SITE_URL}/user/orderList/" class="btn btn-success btn-sm">Start</a>
                        <a href="${SITE_URL}/user/orderList/" class="btn btn-warning btn-sm">Pause</a>
                        <a href="${SITE_URL}/user/orderList/" class="btn btn-danger btn-sm">Cancel</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>    


<%@include file="userShared/footer.jsp" %>