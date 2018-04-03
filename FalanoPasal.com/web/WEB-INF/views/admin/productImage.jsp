<%@include file="adminShared/header.jsp" %>
<h1 class="page-header">Product Image</h1>
<div class="row">
<h4>View product image by category</h4>
    <c:forEach var="categoryEntity" items="${categoryList}">
        <div style="float: left;padding: 15px;">
            <a href="${SITE_URL}/admin/productImageByCategory/${categoryEntity.categoryId}" class="btn btn-success">${categoryEntity.categoryName}</a>
        </div>
    </c:forEach>
</div>
<hr style="margin-bottom: 40px;">
<h4>View all product image</h4>
<div class="row" style="padding: 5px;">
    <style>
        img {width:180px;height: 180px;object-fit: cover;}
    </style>
    <c:forEach var="productEntity" items="${productList}">
        <div class="col-lg-3" style="padding: 10px;">
        <center><img src="<c:url value="/static/images/${productEntity.categoryId}${productEntity.productId}.png"/>" alt="image" class="image"/></center>
        <h4 style="text-align: center;">${productEntity.productName}</h4>
        <h4 style="text-align: center;">Rs. ${productEntity.productPrice}</h4>
    </div>        
    </c:forEach>
</div>
<%@include file="adminShared/footer.jsp" %>
