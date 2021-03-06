<%@include file="adminShared/header.jsp" %>
<h1 class="page-header">Products</h1>

<div class="row">    
    <!-- register new product button trigger modal -->
    <button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#addProductModal">
        <span class="glyphicon glyphicon-plus"></span>
        Register new product
    </button>
</div>
<hr>

<div class="row">
    <h4>View product list by category</h4>
    <div style="float: left;padding: 5px;">
        <a href="${SITE_URL}/admin/product" class="btn btn-success" style="margin:15px;">All</a>
        <c:forEach var="categoryEntity" items="${categoryList}">
            <a href="${SITE_URL}/admin/product-by-category-${categoryEntity.categoryId}" style="margin:10px;" class="btn btn-success">${categoryEntity.categoryName}</a>
        </c:forEach>
    </div>
</div>

<hr>

<!-- Register product modal -->
<div class="modal fade" id="addProductModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <spring:url value="/admin/addProduct" var="addProductURL" />            
            <form:form method="post" action="${addProductURL}" modelAttribute="product">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Register new product</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label" for="selectCategory">Select Category</label>								
                        <form:select class="form-control" path="categoryId" id="selectCategory">
                            <c:forEach var="categoryEntity" items="${categoryList}">
                                <option value="${categoryEntity.categoryId}">${categoryEntity.categoryName}</option>                                
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="inputProductName">Product name</label>
                        <form:input class="form-control" path="productName" id="inputProductName" placeholder="Product name"  type="text" required="required" />                            
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="inputProductPrice">Unit price</label>
                        <form:input class="form-control" path="productPrice" id="inputProductPrice" placeholder="Price"  type="number" required="required" />                            
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="inputCalorieValue">Calorie Value</label>
                        <form:input class="form-control" path="calorieValue" id="inputCalorieValue" placeholder="Calorie value"  type="number" required="required" />                            
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="inputDescription">Description</label>
                        <form:textarea class="form-control" path="description" id="inputDescription" placeholder="Provide description" required="required" />                            
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="inputManufacturerName">Manufacturer name</label>
                        <form:input class="form-control" path="manufacturerName" id="inputManufacturerName" type="text" placeholder="Manufacturer name" required="required" />                            
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="inputManufacturerLocation">Manufacturer location</label>
                        <form:input class="form-control" path="location" id="inputManufacturerLocation" type="text" placeholder="Manufacturer location" required="required" />                            
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="inputManufacturedDate">Manufactured date</label>
                        <form:input class="form-control" path="manufacturedDate" id="inputManufacturedDate" type="date" placeholder="Manufactured date" required="required" />                            
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="inputExpiryDate">Expiry date (Add month)</label>
                        <form:input class="form-control" path="expiryDate" id="inputExpiryDate" placeholder="Expiry date" type="number" required="required" />                            
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

<!-- Delete message -->
<div style="color: red;font-size: medium;"><c:out value="${message}"></c:out></div>

<!--product table-->
<div class="row">
    <h3>Product list</h3>
    <table class="table table-striped table-hover">
        <tr>
            <th>S.N.</th>
            <th>Name</th>
            <th>Unit price ($)</th>
            <th>Calorie value (Kcal/g)</th>
            <th>Description</th>
            <th>Category</th>
            <th>Stock Value</th>
            <th style="width: 88px;">Action</th>                        
        </tr>
        <c:set var="count" value="0" scope="page"/>
        <c:forEach var="productEntity" items="${productList}">
            <tr>
                <c:set var="count" value="${count+1}" scope="page"/>
                <td>${count}</td>
                <td>${productEntity.productName}</td>
                <td>${productEntity.productPrice}</td>
                <td>${productEntity.calorieValue}</td>
                <td>
                    <p style="margin-bottom: 0px;">${productEntity.description}</p><br>
                    <strong>Manufacturer-Name:</strong> ${productEntity.manufacturerName}<br>
                    <strong>Location:</strong> ${productEntity.location}<br>
                    <strong>Manufacture-Date:</strong> ${productEntity.manufacturedDate}<br>
                    <strong>Expiry-Date:</strong> ${productEntity.expiryDateStringFormat}<br>
                </td>
                <td>${productEntity.category.categoryName}</td>
                <td>${productEntity.stockValue}</td>
                <td>
                    <a class="btn btn-success btn-sm" href="${SITE_URL}/admin/productEdit/${productEntity.productId}" title="Edit"><span class="glyphicon glyphicon-edit"></span></a>
                    <a class="btn btn-danger btn-sm" href="${SITE_URL}/admin/productDelete/${productEntity.productId}" title="Delete" onclick="return confirm('Are you sure to delete?')">
                        <span class="glyphicon glyphicon-trash"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div> 
<!--end of product table-->        
<%@include file="adminShared/footer.jsp" %>
