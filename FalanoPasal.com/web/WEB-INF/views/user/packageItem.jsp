<%@include file="userShared/header.jsp" %>
<!--Page Heading-->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header" style="margin-top: 0px;">
            Package List
            <small>Select packages</small>
        </h1>
    </div>
</div>
<!--row-->

<ol class="breadcrumb">
    <li><a href="${SITE_URL}/user/home">Home</a></li>
    <li><a href="${SITE_URL}/user/package">Package</a></li>
    <li class="active">Package List</li>
</ol>

<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
        <table class="table table-striped table-hover">
            <tr>
                <th>S.N.</th>
                <th>Product Name</th>
                <th>Old Price</th>
                <th>New Price</th>
            </tr>
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




<%@include file="userShared/footer.jsp" %>