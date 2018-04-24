<%@include file="adminShared/header.jsp" %>
<h1 class="page-header">Package Bought List

        <div class="pull-right">
        <a class="btn btn-danger" href="${SITE_URL}/admin/packageList">Back</a>
    </div>

</h1>


<div class="row">
    <div class="col-lg-12">
        <table class="table table-striped table-hover">
            <th>S.N.</th>
            <th>Username</th>
            <th>Date</th>
            <th>Package name</th>
            <th>Grand Total Old</th>
            <th>Grand Total New</th>
            <th>Action</th>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="packageBoughtEntity" items="${packageBoughtList}">
                <tr>
                    <c:set var="count" value="${count+1}" scope="page"/>
                    <td>${count}</td>
                    <td>${packageBoughtEntity.username}</td>
                    <td>${packageBoughtEntity.packageBoughtDate}</td>
                    <td>${packageBoughtEntity.packageName}</td>
                    <td>${packageBoughtEntity.grandTotalOld}</td>
                    <td>${packageBoughtEntity.grandTotalNew}</td>
                    <td><a href="${SITE_URL}/admin/packageItemList/${packageBoughtEntity.packageId}" class="btn btn-success" title="View">
                            <span class="glyphicon glyphicon-expand"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<%@include file="adminShared/footer.jsp" %>