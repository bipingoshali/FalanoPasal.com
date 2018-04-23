<%@include file="adminShared/header.jsp" %>
<h1 class="page-header">Category</h1>

<div class="row">    
    <!-- register new category button trigger modal -->
    <button type="button" class="btn btn-success pull-right" data-toggle="modal" data-target="#addCategoryModal">
        <span class="glyphicon glyphicon-plus"></span>
        Register new category
    </button>
</div>

<!-- Register category modal -->
<div class="modal fade" id="addCategoryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <spring:url value="/admin/addCategory" var="addCategoryURL" />            
            <form:form method="post" action="${addCategoryURL}" modelAttribute="category">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Register new category</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label" for="inputCategoryName">Category name</label>
                        <form:input class="form-control" path="categoryName"  id="inputCategoryName" placeholder="Category name"  type="text" required="required" />                            
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
<!--end of register category modal-->            

<!--table-->            
<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <h3>Category list</h3>
        <table class="table table-striped table-hover">
            <tr>
                <th>S.N.</th>
                <th>Name</th>
            </tr>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="categoryEntity" items="${categoryList}">
                <tr>
                    <c:set var="count" value="${count+1}" scope="page"/>
                    <td>${count}</td>
                    <td>${categoryEntity.categoryName}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>            




<%@include file="adminShared/footer.jsp" %>