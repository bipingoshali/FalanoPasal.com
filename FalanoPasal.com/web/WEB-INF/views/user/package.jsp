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
    <li><a href="${SITE_URL}/admin/home">Home</a></li>
    <li class="active">Package List</li>
</ol>

<div class="row">
    <div class="col-lg-12">
        <h2>${packageMessage}</h2>
        <c:forEach var="packageEntity" items="${packageList}">
            <div class="col-lg-3" style="padding: 10px;">
                <center>
                    <strong><h4>${packageEntity.packageName}</h4></strong><br>
                    <strong>Price: </strong>${packageEntity.grandTotalOld}<br>
                    <strong>New price: </strong>${packageEntity.grandTotalNew}<br>
                    <a href="${SITE_URL}/user/buyPackage/${packageEntity.packageId}" class="btn btn-success" onclick="return confirm('Are you sure to buy?')">Buy</a>
                    <a href="${SITE_URL}/user/packageItem/${packageEntity.packageId}" class="btn btn-default" >View products</a>
                </center>
            </div>
        </c:forEach>
    </div>
</div>    

<%@include file="userShared/footer.jsp" %>