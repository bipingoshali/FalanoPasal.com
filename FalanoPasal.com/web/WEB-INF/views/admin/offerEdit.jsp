<%@include file="adminShared/header.jsp" %>
<h1 class="page-header">
    Offer and Discount Edit
    <div class="pull-right">
        <a class="btn btn-danger" href="${SITE_URL}/admin/offer">Back</a>
    </div>
</h1>

<!--Edit offer details -->
<div class="col-md-12">
    <spring:url value="/admin/offerEditSave" var="offerEditSaveURL" />            
    <form:form method="post" action="${offerEditSaveURL}" modelAttribute="offer">
        <form:hidden path="productId"/>
        <div class="form-group">
            <label class="control-label" for="inputType">Name</label>
            <form:input class="form-control" path="type" id="inputType" placeholder="Name"  type="text" required="required"/>                            
        </div>
        <div class="form-group">
            <label class="control-label" for="inputProductName">Product name</label>
            <form:input class="form-control" path="productName" id="inputProductName" placeholder="Product name"  type="text" disabled="true" />                            
        </div>
        <div class="form-group">
            <label class="control-label" for="inputOrderCount">Order count</label>
            <form:input class="form-control" path="orderCount" id="inputOrderCount" placeholder="Order count"  type="number" required="required" />                            
        </div>
        <div class="form-group">
            <label class="control-label" for="inputPriceTag">Price tag</label>
            <form:input class="form-control" path="priceTag" id="inputPriceTag" placeholder="Price tag"  type="number" required="required" />                            
        </div>
        <form:hidden path="offerId" />                            
        <div class="form-group">
            <button type="submit" class="btn btn-success" title="Edit">Edit</button>
        </div>
    </form:form>
</div>
<!--end of edit offer details-->


<%@include file="adminShared/footer.jsp" %>