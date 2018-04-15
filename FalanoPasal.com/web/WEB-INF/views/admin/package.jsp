<%@include file="adminShared/header.jsp" %>

<script>
    $(document).ready(function () {
        $(".add_package_btn").click(function () {
            var productId = $(this).attr('data-product-id');
            var newprice = $(".price-input").val();

            if (newprice === '') {
                $("#modal-body-msg").text('Please enter the new price');
                return;
            }

            $.ajax({
                url: 'addToPackage',
                data: {
                    'productId': productId,
                    'newprice': newprice
                }
            });
        });
    });
</script>

<h1 class="page-header">Package</h1>

<div class="row">
    <div class="col-lg-12">
        <div class="row">
            <div class="col-lg-6">
                <center><h4>Create Packages</h4></center>
                <c:if test="${not empty s}">
                    <c:forEach var="sp" items="${s}">
                    ${sp.productId}
                    </c:forEach>
                    </c:if>
                
            </div>
            <div class="col-lg-6">
                <center><h4>Product List</h4></center>

                <table class="table table-striped table-hover">
                    <tr>
                        <th>Product name</th>
                        <th>Product price(£)</th>
                        <th>New price</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="productEntity" items="${productList}">
                        <tr>
                            <td>${productEntity.productName}</td>
                            <td>${productEntity.productPrice}</td>
                            <spring:url value="/admin/package/addToPackage" var="addPackageURL" />
                            <form:form method="post" action="${addPackageURL}" modelAttribute="packages">                                
                                <td>
                                    <form:input path="productId" value="${productEntity.productId}" hidden="hidden"/>                                                              
                                    <form:input path="newPrice" type="number" class="form-control price-input"  aria-describedby="price-input" required="required"/>                                                              
                                </td>
                                <td><button type="submit" class="btn btn-success add_package_btn" data-toggle="modal" data-target="#package-success-modal">Add</button></td>
                            </form:form>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- package success modal -->
<div class="modal fade" id="package-success-modal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Thank You</h4>
            </div>
            <div class="modal-body">
                <p id="modal-body-msg">items added to your cart.</p>
            </div>
            <div class="modal-footer">                            
                <button id="ok-modal-button" type="button" class="btn btn-default" data-dismiss="modal">OK</button>
                <a href="products" type="button" class="btn btn-default" >Back To Products</a>
            </div>
        </div>
    </div>
</div> 

<%@include file="adminShared/footer.jsp" %>