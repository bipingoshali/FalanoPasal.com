<%@include file="adminShared/header.jsp" %>
<h1 class="page-header">
    Product Edit
    <div class="pull-right">
        <a class="btn btn-danger" href="${SITE_URL}/admin/product">Back</a>
    </div>
</h1>

<!--Edit product details only-->
<div class="col-md-6">
    <spring:url value="/admin/productEditSave" var="productEditSaveURL" />            
    <form:form method="post" action="${productEditSaveURL}" modelAttribute="product">
        <form:hidden path="productId"/>
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
            <form:input class="form-control" path="manufacturerName" id="inputManufacturerName" placeholder="Manufacturer name"  type="text" required="required" />                            
        </div>
        <div class="form-group">
            <label class="control-label" for="inputLocation">Location</label>
            <form:input class="form-control" path="location" id="inputLocation" placeholder="Location"  type="text" required="required" />                            
        </div>
        <div class="form-group">
            <label class="control-label" for="inputManufactureDate">Manufacture date</label>
            <form:input class="form-control" path="manufacturedDate" id="inputManufactureDate" placeholder="Manufacture date"  type="date" required="required" />                            
        </div>
        <div class="form-group">
            <label class="control-label" for="inputExpiryDate">Expiry date</label>
            <form:input class="form-control" path="expiryDateStringFormat" id="inputExpiryDate" placeholder="Manufacture date"  type="date" required="required" />                            
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success" title="Edit">Edit</button>
            <button type="reset" class="btn btn-warning" title="Reset">Reset</button>
        </div>
    </form:form>
</div>
<!--end of edit product details-->

<div class="col-md-6">

    <!--edit product stock amount only-->
    <div class="row">
    <h4>Add Product Stock</h4>
    <spring:url value="/admin/productStockEditSave" var="productStockEditSaveURL" />            
    <form:form class="form-horizontal" method="post" action="${productStockEditSaveURL}" modelAttribute="product">
        <form:hidden path="productId"/>        
        <div class="form-group form-group">
            <div class="row" style="margin-top:15px;margin-bottom:15px;">
                <label class="col-sm-4 control-label" for="forProductName">Product Name</label>
                <div class="col-sm-6">
                    <form:input path="productName" class="form-control"  id="forProductName" disabled="true"/>
                </div>
            </div>
            <div class="row" style="margin-bottom: 15px;">
                <label class="col-sm-4 control-label" for="forPreviousStock">Previous Stock</label>
                <div class="col-sm-6">
                    <form:input path="stockValue" class="form-control"  id="forPreviousStock" disabled="true"/>
                </div>
            </div>
            <div class="row" style="margin-bottom:15px;">
                <label class="col-sm-4 control-label" for="forAddStock">Add Stock</label>
                <div class="col-sm-6">
                    <form:input path="updatedStockValue" class="form-control" type="number" id="forAddStock" required="required" />
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="col-sm-6">
                    <button class="btn btn-success" title="Add" type="submit">Add</button>
                </div>
            </div>
        </div>
    </form:form>
    </div>
    <!--end of edit product stock amount-->
    
    <!--edit product categoryId only-->
    <div class="row">
        <h4>Update Product Category Type</h4>
        <spring:url value="/admin/productCategoryIdEditSave" var="productCategoryIdEditSaveURL" />            
        <form:form class="form-horizontal" method="post" action="${productCategoryIdEditSaveURL}" modelAttribute="product">
            <form:hidden path="productId"/>        
            <div class="form-group form-group">
                <div class="row" style="margin-top:15px;margin-bottom:15px;">
                    <label class="col-sm-4 control-label" for="forProductName">Product Name</label>
                    <div class="col-sm-6">
                        <form:input path="productName" class="form-control"  id="forProductName" disabled="true"/>
                    </div>
                </div>
                <div class="row" style="margin-bottom: 15px;">
                    <label class="col-sm-4 control-label" for="forPreviousType">Previous Type</label>
                    <div class="col-sm-6">
                        <form:input path="category.categoryName" class="form-control"  id="forPreviousType" disabled="true"/>
                    </div>
                </div>
                <div class="row" style="margin-bottom:15px;">
                    <label class="col-sm-4 control-label" for="forUpdateType">Update Type</label>
                    <div class="col-sm-6">
                        <form:select class="form-control" path="categoryId" id="forUpdateType" required="required">
                            <c:forEach var="categoryEntity" items="${categoryList}">
                                <option value="${categoryEntity.categoryId}">${categoryEntity.categoryName}</option>                                
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-6">
                        <button class="btn btn-success" title="Update" type="submit">Update</button>
                    </div>
                </div>
            </div>
        </form:form>

    </div>


</div>    



<%@include file="adminShared/footer.jsp" %>