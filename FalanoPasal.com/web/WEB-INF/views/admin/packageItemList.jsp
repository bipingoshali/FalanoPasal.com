<%@include file="adminShared/header.jsp" %>

<h1 class="page-header">
    Package Item List
    <div class="pull-right">
        <a class="btn btn-danger" href="${SITE_URL}/admin/packageList">Back</a>
    </div>

</h1>

<div class="row">
    <div class="col-lg-12">
        <table class="table table-striped table-hover">
            <th>S.N.</th>
            <th>Product name</th>
            <th>Old price</th>
            <th>New price</th>
                <c:set var="oldPriceTotal" value="${0}" />
                <c:set var="newPriceTotal" value="${0}" />            
                <c:set var="count" value="0" scope="page"/>
                <c:forEach var="packageItemEntity" items="${packageItemList}">
                    <c:set var="oldPriceTotal" value="${oldPriceTotal + packageItemEntity.oldPrice}" />
                    <c:set var="newPriceTotal" value="${newPriceTotal + packageItemEntity.newPrice}" />

                <tr>
                    <c:set var="count" value="${count+1}" scope="page"/>
                    <td>${count}</td>
                    <td>${packageItemEntity.packageName}</td>
                    <td>${packageItemEntity.oldPrice}</td>
                    <td>${packageItemEntity.newPrice}</td>
                </tr>
            </c:forEach>
        </table>
        <strong>Grand total (£): </strong>${oldPriceTotal}<br>
        <strong>New grand total (£): </strong>${newPriceTotal}<br>
    </div>
</div>


<%@include file="adminShared/footer.jsp" %>