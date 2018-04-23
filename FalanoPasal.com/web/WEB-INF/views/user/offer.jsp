<%@include file="userShared/header.jsp" %>
<!--Page Heading-->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header" style="margin-top: 0px;">
            Offers
            <small>${offermessage}</small>
        </h1>
    </div>
</div>
<!--row-->

<div class="row">
    <div class="col-lg-12">
        <div class="row">
            <h3>${offerBoughtMessage}</h3>
            <c:forEach var="offerEntity" items="${offerList}">
                <div class="col-lg-3">
                    <!--<center><img src=""/>" alt="image" class="image"/></center>-->
                    <h4 style="text-align: center;">${offerEntity.productName}</h4>
                    <center>
                        <h4>
                            <small>Calorie Value: ${offerEntity.type}</small><br/>
                            <small>Rs. ${offerEntity.priceTag}</small>
                        </h4>
                            <a href="<c:url value="/user/buyOffersDiscounts/${offerEntity.offerId}"/>" class="btn btn-success" onclick="return confirm('Are you sure to buy?')">Buy</a>
                    </center>                
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<%@include file="userShared/footer.jsp" %>