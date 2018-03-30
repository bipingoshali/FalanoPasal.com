<%@include file="adminShared/header.jsp" %>
    <h1 class="page-header">Dashboard</h1>
    <div class="col-md-4">
    <form>
        <div class="form-group">
            <label class="control-label" for="selectCategory">Select Category</label>								
            <select class="form-control" id="selectCategory">            
            </select>
        </div>
        <div class="form-group">
            <label class="control-label" for="selectProduct">Select Product</label>								
            <select class="form-control" id="selectProduct">   
                <c:forEach var="productEntity" items="${productList}">                    
                    <option>${productEntity.productName}</option>
                </c:forEach>
            </select>
        </div>
    </form>        
    </div>
<%@include file="adminShared/footer.jsp" %>
                    
                    

