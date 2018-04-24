<%@include file="adminShared/header.jsp" %>

<h1 class="page-header">
    Customer Order Count List
    <div class="pull-right">
        <a class="btn btn-danger" href="${SITE_URL}/admin/home">Back</a>
    </div>
</h1>

<div class="row">
    <div class="col-lg-3"></div>
    <div class="col-lg-6">
        <table class="table table-striped table-hover">
            <th>S.N.</th>
            <th>Username</th>
            <th>Total count</th>
            <c:set var="count" value="0" scope="page"/>
                <c:forEach var="productEntity" items="${productList}">
                <tr>
                    <c:set var="count" value="${count+1}" scope="page"/>
                    <td>${count}</td>
                    <td>${productEntity.productName}</td>
                    <td>${productEntity.boughtCount}</td>
                </tr>
            </c:forEach>                
        </table>
    </div>
</div>

<%@include file="adminShared/footer.jsp" %>