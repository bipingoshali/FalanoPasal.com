<%@include file="adminShared/header.jsp" %>
    <h1 class="page-header">Offers and Discounts</h1>

    <div class="row">   
        <div class="col-lg-12">
    <!-- register new product button trigger modal -->
    <a href="${SITE_URL}/admin/offerHistory" class="btn btn-primary pull-left">
        <span class="glyphicon glyphicon-th"></span>
        View bought offers
    </a>
    <button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#createModal">
        <span class="glyphicon glyphicon-plus"></span>
        Create
    </button>
        </div>
    </div>
<hr>

<!-- create offer or discount modal -->
<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <spring:url value="/admin/offerSave" var="addOfferURL" />            
            <form:form method="post" action="${addOfferURL}" modelAttribute="offer">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Create</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label" for="inputName">Name</label>
                        <form:input class="form-control" path="type" id="inputName" placeholder="Name" type="text" required="required" />                            
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="inputOrderCount">Required order count</label>
                        <form:input class="form-control" path="orderCount" id="inputOrderCount" placeholder="Required order count"  type="number" required="required" />                            
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="selectProduct">Select Product</label>								
                        <form:select class="form-control" path="productId" id="selectProduct">
                            <c:forEach var="productEntity" items="${productList}">
                                <option value="${productEntity.productId}">${productEntity.productName}</option>                                
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="inputProductTag">Price tag</label>
                        <form:input class="form-control" path="priceTag" id="inputProductTag" placeholder="Product tag"  type="number" required="required" />                            
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-success">Save changes</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
<!--end of register product modal-->            

<div class="row">
    <div class="col-lg-12">
        <table class="table table-striped table-hover">
            <th>S.N.</th>
            <th>Type</th>
            <th>Order Count</th>
            <th>Product name</th>
            <th>Price tag</th>
            <th>Action</th>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="offerEntity" items="${offerList}">
            <tr>
                <c:set var="count" value="${count+1}" scope="page"/>
                <td>${count}</td>
                <td>${offerEntity.type}</td>
                <td>${offerEntity.orderCount}</td>
                <td>${offerEntity.productName}</td>
                <td>${offerEntity.priceTag}</td>
                <td>
                    <a class="btn btn-success btn-sm" href="${SITE_URL}/admin/offerEdit/${offerEntity.offerId}" title="Edit"><span class="glyphicon glyphicon-edit"></span></a>
                    <a class="btn btn-danger btn-sm" href="${SITE_URL}/admin/offerDelete/${offerEntity.offerId}" title="Delete" onclick="return confirm('Are you sure to delete?')">
                        <span class="glyphicon glyphicon-trash"></span>
                    </a>                    
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>

<%@include file="adminShared/footer.jsp" %>