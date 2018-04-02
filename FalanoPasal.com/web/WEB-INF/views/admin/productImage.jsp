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
<%@include file="adminShared/footer.jsp" %>
