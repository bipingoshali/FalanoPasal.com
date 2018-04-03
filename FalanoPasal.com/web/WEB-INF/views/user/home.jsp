<%@include file="userShared/header.jsp" %>
<!--Page Content-->
<div class="container">

    <!--Page Heading-->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header" style="margin-top: 0px;">
                Product
                <small>Select product</small>
            </h1>
        </div>
    </div>
    <!--row-->


    <div class="row container">
        <div class="row">
            <!--left category-->
            <div class="col-md-3">
                <center><p class="lead">Top Categories</p></center>
                <div class="list-group">
                    <c:forEach var="categoryEntity" items="${categoryList}">
                        <a href="#" class="list-group-item category-select-option" data-category-name="${categoryEntity.categoryName}">${categoryEntity.categoryName}</a>                        
                    </c:forEach>                            
                </div>
            </div>
            <div class="col-md-9" style="padding: 20px;">
                <div class="row">
                    <style>
                        img {width:150px;height: 150px;object-fit: cover;}
                    </style>
                    <c:forEach var="productEntity" items="${productList}">
                        <div class="col-md-3" style="padding: 10px;">
                            <center><img src="<c:url value="/static/images/${productEntity.categoryId}${productEntity.productId}.png"/>" alt="image" class="image"/></center>
                            <h4 style="text-align: center;">${productEntity.productName}</h4>
                            <center>
                                <h4>
                                    <small>Calorie Value: ${productEntity.calorieValue}</small><br/>
                                    <small>Rs. ${productEntity.productPrice}</small>
                                </h4>
                                <a class="btn btn-default">View details</a>
                            </center>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="userShared/footer.jsp" %>