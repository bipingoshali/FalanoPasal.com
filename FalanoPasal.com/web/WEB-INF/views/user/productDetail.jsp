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
                    'quantity': quantity
                },
                success: function (data) {
                    $("#quantityAlertMessage").html(data);
                }
            });

            var msg = quantity + ' items added to your cart.';
            $("#modal-body-msg").text(msg);

        });

        $("#ok-modal-button").click(function () {
            // refresh quantity input
            $("#quantity-input").val('');
        });

        $("#rate-input").keyup(function () {
            var rate = $(this).val();
            if (rate > 5) {
                $("#rateResponse").show();
                $("#rateResponse").html("Invalid rate input");
            } else {
                $("#rateResponse").hide();
            }
        });

        $("#rate_btn").click(function () {
            var rateInput = $("#rate-input").val();
            var productId = $(this).attr('data-product-id');
            if (rateInput === "") {
                $("#rateResponse").show();
                $("#rateResponse").html("Input field is null");
                return;
            } else {
                $("#rateResponse").hide();
                $("#rate-input").val('');
            }
            $.ajax({
                url: 'rateProduct',
                data: {
                    'productId': productId,
                    'rating': rateInput
                },
                success: function (data) {
                    if (data.success === true) { // if true (1)
                        setTimeout(function () {// wait for 5 secs(2)
                            location.reload(); // then reload the page.(3)
                        }, 5000);
                    }
                }
            });
        });

        $("#comment_btn").click(function () {
            var commentInput = $("#comment_txt").val();
            var productId = $(this).attr('data-product-id');

            if (commentInput === "") {
                $("#commentResponse").show();
                $("#commentResponse").html("Input field is null");
                return;

            } else {
                $("#commentResponse").hide();
                $("#comment_txt").val('');
            }
            $.ajax({
                url: 'commentProduct',
                data: {
                    'productId': productId,
                    'comment': commentInput
                },
                success: function () {
                    setTimeout(function () {// wait for 5 secs(2)
                        location.reload(true); // then reload the page.(3)
                    }, 500);
                }
            });
        });
        
        $("#subscribe_btn").click(function (){
            var productId = $(this).attr('data-product-id');
            var quantity = $("#inputSubscribeQuantity").val();
            var duration = $("#subscriptionOption").val();
            
            if (quantity === "") {
                $("#subscribeResponse").show();
                $("#subscribeResponse").html("Quantity field is null");
                return;

            } else {
                $("#subscribeResponse").hide();
                $("#inputSubscribeQuantity").val('');
            }
           $.ajax({
              url: 'subscribeproduct',
              data: {
                  'productId': productId,
                  'duration': duration,
                  'quantity': quantity
              }
           }); 
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

<!--breadcrumb-->
<ol class="breadcrumb">
    <li><a href="${SITE_URL}/admin/home">Home</a></li>
    <li class="active">Product detail</li>
</ol>
<!--end of breadcrumb-->

<div class="row">
    <div class="row" style="background-color: white;padding: 30px;">

        <!--product image-->
        <div class="col-md-4" style="background-color: white;">
            <center><img src="<c:url value="/static/images/${product.categoryId}${product.productId}.png"/>" alt="image" class="image"/></center>
        </div>

        <!--products add basket-->
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
                                <input id="quantity-input" type="number" class="form-control"  aria-describedby="quantity-input">                                  
                            </div>
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
                        <div class="col-lg-3 col-md-3">
                            <div id="quantityAlertMessage" style="color: red;" ></div> <!--not enough quantity message-->
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

            <!--product details-->
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


        </div>                
        <!--end of product basket-->

        <div class="row"> 
            <div class="col-lg-1"></div>

            <!--product description-->                           
            <div class="col-lg-10">
                <strong>Product Description</strong><br/>
                <style>
                    .rcorners2 {
                        margin-top: 5px;
                        border-radius: 5px;
                        border: 1px solid #eee;
                        background-color: #eee;
                        padding: 10px; 
                        width: auto;
                        height: auto;    
                    }
                </style>
                <p class="rcorners2">${product.description}</p>
                <!--end of product description-->

                <!--rate product-->
                <strong>Rate this product</strong><br/>                
                <div class="row" style="margin-bottom: 10px;">
                    <div class="col-lg-3">
                        <div class="input-group">
                            <div class="input-group-addon">Rate (1-5)</div>
                            <input id="rate-input" type="number" class="form-control" aria-describedby="rate-input">  
                        </div>
                    </div>
                    <div class="col-lg-1">
                        <button id="rate_btn" data-product-id="${product.productId}" type="button" class="btn btn-success">Rate</button>                        
                    </div>
                    <div class="col-lg-3">
                        <div id="rateResponse" class="alert alert-danger" role="alert" hidden="hidden">
                        </div>                        
                    </div>
                </div>
                <!--end of rate product-->

                <!--comment product-->
                <div class="row">
                    <div class="col-lg-7">
                        <strong>Comment this product</strong><br/> 
                        <textarea id="comment_txt" type="text" class="form-control"></textarea>
                    </div>
                    <div class="col-lg-2" style="margin-top:30px;">
                        <button id="comment_btn" data-product-id="${product.productId}" type="button" class="btn btn-success">Comment</button>                        
                    </div>
                    <div class="col-lg-2" style="margin-top:15px;">
                        <div id="commentResponse" class="alert alert-danger" role="alert" hidden="hidden">
                        </div>                        
                    </div>
                </div>
                <!--end of comment product-->

                <hr>

                <!--subscribe this product-->
                <div class="row">
                    <div class="col-lg-12">
                        <h4><Strong>Subscribe this product</Strong></h4>
                        <div class="col-lg-8">
                            <form class="form-inline">
                                <div class="form-group">
                                    <label for="inputSubscribeQuantity">Quantity</label>
                                    <input type="number" class="form-control" id="inputSubscribeQuantity" />
                                </div>
                                <div class="form-group">
                                    <label class="control-label" for="subscriptionOption">Subscription Option</label>								
                                    <select class="form-control" id="subscriptionOption">
                                        <option value="Weekly">Weekly</option>
                                        <option value="Monthly">Monthly</option>
                                    </select>
                                </div>
                                <button id="subscribe_btn" data-product-id="${product.productId}" type="button" class="btn btn-primary" >Subscribe</button>                                
                            </form>
                        </div>
                        <div class="col-lg-3">
                            <div id="subscribeResponse" class="alert alert-danger" role="alert" hidden="hidden">
                            </div>                        
                        </div>
                    </div>
                </div>
                <!--end of subscribe this product-->
                <hr>
                <div class="row">
                    <div class="col-lg-12">
                        <h4><strong>Comments</strong></h4>
                        <c:forEach var="productCommentEntity" items="${productComment}">
                            <div class="row">                            
                                <div class="col-lg-2">
                                    <h5><strong>${productCommentEntity.username}</strong></h5>
                                </div>
                                <div class="col-lg-8">
                                    <p class="rcorners2">${productCommentEntity.productComment}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
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