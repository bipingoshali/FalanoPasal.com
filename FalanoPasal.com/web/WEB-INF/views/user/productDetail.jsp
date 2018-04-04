<%@include file="userShared/header.jsp" %>

<script>
    $(document).ready(function () {
        $("#add-to-basket-btn").click(function () {
            var productId = $(this).attr('data-product-id');
            var quantity = $("#quantity-input").val();

            if (quantity === '') {
                $("#modal-body-msg").text('Please enter a quantity');
                return;
            }

            $.ajax({
                url: 'addToCart',
                data: {
                    'productId': productId,
                    'quantity':quantity
                }
            });

            var msg = quantity + ' items added to your cart.';
            $("#modal-body-msg").text(msg);
        });

        $("#ok-modal-button").click(function () {
            // refresh quantity input
            $("#quantity-input").val('');
        });
    });
</script>


<!--Page Heading-->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header" style="margin-top: 0px;">
            ${product.category.categoryName}
            <small>Select product</small>
        </h1>
    </div>
</div>
<!--row-->

<ol class="breadcrumb">
    <li><a href="${SITE_URL}/admin/home">Home</a></li>
    <li class="active">Product detail</li>
</ol>

<div class="row container">
    <div class="row" style="background-color: white;padding: 30px;">
        <div class="col-md-4" style="background-color: white;">
            <center><img src="<c:url value="/static/images/${product.categoryId}${product.productId}.png"/>" alt="image" class="image"/></center>
        </div>
        <div class="col-md-8" style="background-color: white; padding: 0px 30px 0px 150px;">
            <div class="row" style="margin-bottom: 20px;">
                <div class="col-md-12">
                    <h2 style="margin-top: 10px;">${product.productName}</h2>
                    <p style="color:red;">
                        <strong>${message}</strong>
                    </p>
                </div>
            </div>   
            <div class="row" style="margin-bottom:30px;">
                <div class="col-md-12">        
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div class="input-group">
                                <div class="input-group-addon">Quantity</div>
                                <input id="quantity-input" type="number" class="form-control"  aria-describedby="quantity-input">                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3">
                            <!--if the product is out of stock then the add to basket will be disabled-->
                            <c:if test="${not empty message}">
                                <button type="submit" class="btn btn-primary" disabled="disabled">Add to Basket</button>
                            </c:if>
                            <c:if test="${empty message}">
                                <button id="add-to-basket-btn" data-product-id="${product.productId}" type="button" class="btn btn-primary" data-toggle="modal" data-target="#success-modal">Add to Basket</button>
                            </c:if>
                        </div>
                    </div>
                </div>    
            </div>


            <!-- success modal -->
            <div class="modal fade" id="success-modal" role="dialog">
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

            <div class="row">
                <div class="col-md-10">
                    <table class="table">
                        <thead>
                        <td><strong>Product Details</strong></td>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Price:</td>
                                <td>£${product.productPrice}</td>
                            </tr>
                            <tr>
                                <td>Calorie Value:</td>
                                <td>${product.calorieValue} Kcal/g</td>
                            </tr>
                        </tbody>
                    </table>
                </div>    
            </div>


            <div class="row">                
                <div class="col-md-12">
                    <strong>Product Description</strong><br/>
                    <style>
                        #rcorners2 {
                            margin-top: 5px;
                            border-radius: 5px;
                            border: 1px solid #eee;
                            background-color: #eee;
                            padding: 10px; 
                            width: auto;
                            height: auto;    
                        }
                    </style>
                    <p id="rcorners2">${product.description}</p>
                </div>
            </div>

        </div>
    </div>
</div>
<%@include file="userShared/footer.jsp" %>