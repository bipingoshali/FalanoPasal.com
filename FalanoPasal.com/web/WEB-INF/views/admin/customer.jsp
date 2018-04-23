<%@include file="adminShared/header.jsp" %>
<h1 class="page-header">Customer List</h1>

<!--customer table--> 
<div class="row">
    <div class="col-lg-12">
        <table class="table table-striped table-hover">
            <tr>
                <th>S.N.</th>
                <th>Name</th>
                <th>Email</th>
                <th>Username</th>
                <th>City</th>
                <th>Address</th>
                <th>Birth date</th>
                <th>Order count</th>
                <th>Status</th>                        
            </tr>
            <c:set var="count" value="0" scope="page"/>
            <c:forEach var="userEntity" items="${userList}">
            <tr>
                <c:set var="count" value="${count+1}" scope="page"/>
                <td>${count}</td>
                <td>${userEntity.firstName} <strong>${userEntity.lastName}</strong></td>
                <td>${userEntity.email}</td>
                <td>${userEntity.username}</td>
                <td>${userEntity.city}</td>
                <td>${userEntity.addressLine1}, ${userEntity.addressLine2} ${userEntity.houseNo}</td>  
                <td>${userEntity.birthdateformat}</td>
                <td>${userEntity.orderCount}</td>
                <td>
                    <c:if test="${userEntity.status}">
                        <span class="label label-success">Active</span>                        
                    </c:if>
                    <c:if test="${not userEntity.status}">
                        <span class="label label-danger">Inactive</span>                    
                    </c:if>                                                            
                </td>
            </tr>
            </c:forEach>
        </table>

    </div>
</div>
<%@include file="adminShared/footer.jsp" %>
