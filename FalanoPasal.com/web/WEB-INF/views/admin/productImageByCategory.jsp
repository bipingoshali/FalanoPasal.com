<%@include file="adminShared/header.jsp" %>
<h1 class="page-header">
    <div class="pull-right">
        <a class="btn btn-danger" href="${SITE_URL}/admin/productImage">Back</a>
    </div>
    <c:forEach var="categoryEntity" items="${categoryList}">
        ${categoryEntity.categoryName}
    </c:forEach>
</h1>

    <div class="row" style="margin-bottom: 20px;">    
    <!-- register new product button trigger modal -->
    <button type="button" class="btn btn-success pull-right" data-toggle="modal" data-target="#uploadImage">
        <span class="glyphicon glyphicon-plus"></span>
        Upload Image
    </button>
</div>

<div class="row" style="margin-bottom: 5px;">
    <style>
        img {width:200px;height: 200px;object-fit: cover;}
    </style>
    <c:forEach var="productEntity" items="${productList}">
        <div class="col-lg-3" style="padding: 10px;">
            <center><img src="<c:url value="/static/images/${productEntity.categoryId}${productEntity.productId}.png"/>" alt="image" class="image"/></center>
            <h4 style="text-align: center;">${productEntity.productName}</h4>
            <h4 style="text-align: center;">Rs. ${productEntity.productPrice}</h4>
            <center>
                <a href="${SITE_URL}/deletePhoto?categoryId=${productEntity.categoryId}&productId=${productEntity.productId}" class="btn btn-danger" onclick="return confirm('Are you sure to delete?')">
                    <span class="glyphicon glyphicon-trash"></span>
                </a>
            </center>
        </div>        
    </c:forEach>
</div>

<!-- Register product modal -->
<div class="modal fade" id="uploadImage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <spring:url value="/admin/checkUpload" var="checkUploadURL" />            
            <form:form method="post" action="${checkUploadURL}" modelAttribute="product" enctype="multipart/form-data">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Register new product</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label" for="selectProduct">Select Product</label>
                        <form:select path="categoryId" class="form-control" id="selectProduct">
                            <c:forEach var="productEntity" items="${productList}">
                                <option value="${productEntity.categoryId}">${productEntity.category.categoryName}</option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="selectProduct">Select Product</label>
                        <form:select path="productId" class="form-control" id="selectProduct">
                            <c:forEach var="productEntity" items="${productList}">
                                <option value="${productEntity.productId}">${productEntity.productName}</option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Choose image</label>
                        <form:input path="productImage" class="form-control" type="file" />                            
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


<%@include file="adminShared/footer.jsp" %>