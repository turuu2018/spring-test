<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <!-- products -->
            <h5>Search results</h5>

            <p class="text-info">Products</p>
            <c:choose>
                <c:when test="${fn:length(products) > 0}">
                    <table class="table table-striped table-bordered">
                        <thead>
                            <th>Name</th>
                            <th>Price</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${products}" var="_product">
                                <tr>
                                    <td><a href=''<c:url value="/product/${_product.id}"/>'>${_product.name}</a></td>
                                    <td>${_product.price}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <span class="text-warning">No product found</span>
                </c:otherwise>
            </c:choose>

            <!-- users -->
            <p class="text-info">Users</p>
            <c:choose>
                <c:when test="${fn:length(users) > 0}">
                    <table class="table table-striped table-bordered">
                        <thead>
                            <th>Username</th>
                            <th>Last name</th>
                            <th>First name</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="_user">
                                <tr>
                                    <td>${_user.username}</td>
                                    <td>${_user.lastName}</td>
                                    <td>${_user.firstName}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <span class="text-warning">No user found</span>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

<script>
    $(function() {
        //
    });
</script>
