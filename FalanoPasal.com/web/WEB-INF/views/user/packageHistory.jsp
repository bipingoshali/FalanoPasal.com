<%@include file="userShared/header.jsp" %>

<!--Page Heading-->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header" style="margin-top: 0px;">
            Offer List
            <small>Bought list</small>
        </h1>
    </div>
</div>
<!--row-->

<ol class="breadcrumb">
    <li><a href="${SITE_URL}/user/home">Home</a></li>
    <li><a href="${SITE_URL}/user/offer">Offers</a></li>
    <li class="active">Offer List</li>
</ol>

<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <table class="table table-striped table-hover">
            <tr>
                <th>S.N.</th>
                <th>Package name</th>
                <th>Old price Total</th>
                <th>New price Total</th>
                <th>Date</th>
                <th>Action</th>
            </tr>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="packageBoughtEntity" items="${packageBoughtList}">
                <tr>
                    <c:set var="count" value="${count+1}" scope="page"/>
                    <td>${count}</td>
                    <td>${packageBoughtEntity.packageName}</td>
                    <td>${packageBoughtEntity.grandTotalOld}</td>
                    <td>${packageBoughtEntity.grandTotalNew}</td>
                    <td>${packageBoughtEntity.packageBoughtDate}</td>
                    <td><a href="${SITE_URL}/user/packageItem/${packageBoughtEntity.packageId}" class="btn btn-success" title="View">
                            <span class="glyphicon glyphicon-expand"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>    


<%@include file="userShared/footer.jsp" %>