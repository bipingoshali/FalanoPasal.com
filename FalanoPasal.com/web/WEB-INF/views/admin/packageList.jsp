<%@include file="adminShared/header.jsp" %>
<h1 class="page-header">Package List</h1>

<div class="row">   
    <div class="col-lg-12">
    <a href="${SITE_URL}/admin/packageBoughtList" class="btn btn-primary pull-left">
        <span class="glyphicon glyphicon-th"></span>
        View bought package
    </a>        
        <a href="${SITE_URL}/admin/package" class="btn btn-primary pull-right">
            <span class="glyphicon glyphicon-plus"></span>
            Create Packages
        </a>
    </div>
</div>
<hr>

<div class="row">
    <div class="col-lg-12">
        <table class="table table-striped table-hover">
            <th>S.N.</th>
            <th>Package name</th>
            <th>Grand Total Old</th>
            <th>Grand Total New</th>
            <th>Action</th>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="packageEntity" items="${packageList}">
                <tr>
                    <c:set var="count" value="${count+1}" scope="page"/>
                    <td>${count}</td>
                    <td>${packageEntity.packageName}</td>
                    <td>${packageEntity.grandTotalOld}</td>
                    <td>${packageEntity.grandTotalNew}</td>
                    <td><a href="${SITE_URL}/admin/packageItemList/${packageEntity.packageId}" class="btn btn-success" title="View">
                            <span class="glyphicon glyphicon-expand"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<%@include file="adminShared/footer.jsp" %>