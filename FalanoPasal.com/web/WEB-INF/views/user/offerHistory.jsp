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
                <th>Type Name</th>
                <th>Product name</th>
                <th>price</th>
                <th>Date</th>
            </tr>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="splEntity" items="${offerList}">
                <tr>
                    <c:set var="count" value="${count+1}" scope="page"/>
                    <td>${count}</td>
                    <td>${splEntity.type}</td>
                    <td>${splEntity.productName}</td>
                    <td>${splEntity.priceTag}</td>
                    <td>${splEntity.offerBoughtDate}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>    

<%@include file="userShared/footer.jsp" %>