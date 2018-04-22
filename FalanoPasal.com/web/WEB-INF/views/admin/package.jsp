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

        $("#create_package_btn").click(function () {
            var packageName = $("#inputPackageName").val();
            if (packageName === '') {
                $("#null_msg").show().html('product name is required');
                return;
            } else {
                $("#null_msg").hide();
            }

            $.ajax({
                url: 'createPackage',
                data: {'packageName': packageName},
                success: function () {
                    setTimeout(function () {// 
                        location.reload(true); //  reload the page.
                    }, 500);
                }
            });
        });

        $("#clear_package_btn").click(function () {
            $.ajax({
                url: 'clearPackage',
                success: function () {
                    setTimeout(function () {// 
                        location.reload(true); //  reload the page.
                    }, 500);
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
                <center>
                    <h4>Create Packages</h4>
                </center>
                <div class="form-group">
                    <label for="inputPackageName">Enter package name: </label>
                    <div id="null_msg" style="color:red;"></div>                    
                    <input type="text" id="inputPackageName" class="form-control"/>
                </div>
                <c:if test="${not empty s}">
                    <center>
                        <h4>Product List</h4>
                    </center>
                    <table class="table table-striped table-hover">
                        <th>Product name</th>
                        <th>Old price (£)</th>
                        <th>New price (£)</th>
                            <c:set var="oldPriceTotal" value="${0}" />
                            <c:set var="newPriceTotal" value="${0}" />
                            <c:forEach var="sp" items="${s}">
                            <c:set var="oldPriceTotal" value="${oldPriceTotal + sp.oldPrice}" />
                            <c:set var="newPriceTotal" value="${newPriceTotal + sp.newPrice}" />
                            <tr>
                                <td>${sp.productName}</td>
                                <td>${sp.oldPrice}</td>
                                <td>${sp.newPrice}</td>
                            </tr>
                        </c:forEach>
                    </table>                    
                    <strong>Grand total (£): </strong>${oldPriceTotal}<br>
                    <strong>New grand total (£): </strong>${newPriceTotal}<br>
                    <button class="btn btn-success" id="create_package_btn">Create</button>
                    <button class="btn btn-danger" id="clear_package_btn">Clear</button>
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
                                <td><button type="submit" class="btn btn-success add_package_btn">Add</button></td>
                            </form:form>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file="adminShared/footer.jsp" %>