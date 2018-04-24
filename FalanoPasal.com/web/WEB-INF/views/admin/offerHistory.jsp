<%@include file="adminShared/header.jsp" %>

<h1 class="page-header">
    Bought Offer List
    <div class="pull-right">
        <a class="btn btn-danger" href="${SITE_URL}/admin/offer">Back</a>
    </div>
</h1>

    <div class="row">
        <div class="col-lg-12">
            <table class="table table-striped table-hover">
                <th>S.N.</th>
                <th>Type</th>
                <th>Username</th>
                <th>Product name</th>
                <th>Price</th>
                <th>Date</th>
                <c:set var="count" value="0" scope="page"/>                
                <c:forEach var="boughtOfferEntity" items="${boughtOfferList}">
                <tr>
                    <c:set var="count" value="${count+1}" scope="page"/>
                    <td>${count}</td>                    
                    <td>${boughtOfferEntity.type}</td>
                    <td>${boughtOfferEntity.username}</td>
                    <td>${boughtOfferEntity.productName}</td>
                    <td>${boughtOfferEntity.priceTag}</td>
                    <td>${boughtOfferEntity.offerBoughtDate}</td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>

<%@include file="adminShared/footer.jsp" %>