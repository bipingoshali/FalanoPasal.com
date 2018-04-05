<%@include file="userShared/header.jsp" %>
<!--Page Heading-->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header" style="margin-top: 0px;">
            <span class="glyphicon glyphicon-shopping-cart"></span>
            Shopping Cart
            <small>Item list</small>
        </h1>
    </div>
</div>
<!--row-->

<ol class="breadcrumb">
    <li><a href="${SITE_URL}/admin/home">Home</a></li>
    <li class="active">Shopping Cart detail</li>
</ol>


<div class="row">
    <div class="col-lg-12">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <h2 style="margin-bottom:30px;">Your shopping cart list</h2>
            <c:if test="${not empty shoppingCartHandlerEntries}">
                <c:forEach var="shoppingCartEntry" items="${shoppingCartHandlerEntries}">
                    <div class="row">
                        <div class="col-lg-12">
                            <center>
                                <style>
                                    img {width:150px;height: 150px;object-fit: cover;}
                                </style>
                                <div class="col-lg-2"><img src="<c:url value="/static/images/13.png"/>" alt="image" class="image"/></div>
                                <div class="col-lg-2"><strong>${shoppingCartEntry.productName}</strong></div>
                                <div class="col-lg-2"><strong>Price: £</strong> ${shoppingCartEntry.price}<br/><strong>Calorie Value:</strong> ${shoppingCartEntry.calorieValue} Kcal/g</div>
                                <div class="col-lg-2"><strong>Quantity:</strong> ${shoppingCartEntry.quantity}</div>
                                <div class="col-lg-2"><strong>Total price: £</strong> ${shoppingCartEntry.productTotalPrice}</div>
                                <div class="col-lg-2"><strong>Total calorie value:</strong>${shoppingCartEntry.totalCalorieValue} Kcal/g</div>
                            </center>
                        </div>
                    </div>
                    <hr>
                </c:forEach>

                <div class="row">

                    <h4>${shoppingItemSize} items on your basket.</h4>

                </div>
            </c:if>
            <c:if test="${empty shoppingCartHandlerEntries}">
                <h4>You have not add any product in the cart</h4>
            </c:if>
            <div class="row">
                <span class="pull-right"><strong>Total: £</strong> ${grandTotal}</span>
            </div>
            <div class="row">
                <span class="pull-right"><strong>Total Calorie Value:</strong> ${totalCalorieValue} Kcal/g</span>
            </div>
            <div class="row">
                <c:if test="${not empty shoppingCartHandlerEntries}">
                <a href="${SITE_URL}/user/shoppingCartOrder" id="checkout-btn" type="button" class="btn btn-primary btn-md pull-right" onclick="return confirm('Are you sure to order?')" title="Order">Order</a>
                </c:if>
            </div>            
        </div>
    </div>
</div>


<!-- Footer -->

<footer>
    <div class="row">
        <div class="col-lg-12">
            <hr>
            <p>Copyright &copy; FalanoPasal.com 2018</p>
        </div>
    </div>
    <!-- /.row -->
</footer>                
<%@include file="userShared/footer.jsp" %>