<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-bordered">
                <thead>
                    <th>Name</th>
                    <th>Price</th>
                    <th></th>
                </thead>
                <tbody>
                    <c:forEach items="${products}" var="_product">
                        <tr>
                            <td><a href="<c:url value="/product/${_product.id}"/>">${_product.name}</a></td>
                            <td>${_product.price}</td>
                            <td><a class="link_product" href="" data-id="${_product.id}">Add to cart</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    $(function() {
        $('a.link_product').click(function(e) {
            e.preventDefault();

            var product_id = $(this).attr('data-id');
            $.ajax({
                url: "<c:url value="/api/basket/add-product"/>",
                data: {
                    productId: product_id,
                    quantity: 1
                },
                success: function(result) {
                    //console.log(result);
                    updateBasket();
                }
            });
        });
    });
</script>
