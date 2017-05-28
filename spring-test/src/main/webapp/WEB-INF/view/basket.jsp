<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="cd-shadow-layer"></div>

<div id="cd-cart">
    <h2>Cart</h2>
    <ul class="cd-cart-items">
        <!--<li>
            <span class="cd-qty">1x</span> Product Name
            <div class="cd-price">$9.99</div>
            <a href="#0" class="cd-item-remove cd-img-replace">Remove</a>
        </li>-->
    </ul> <!-- cd-cart-items -->

    <div class="cd-cart-total">
        <p>Total <span>$0.0</span></p>
    </div> <!-- cd-cart-total -->

    <a href="#0" class="checkout-btn">Checkout</a>

    <p class="cd-go-to-cart"><a href="#0">Go to cart page</a></p>
</div>

<script>
    function updateBasket() {
        $.ajax({
            url: "<c:url value="/api/basket"/>",
            data: {},
            success: function(result) {
                var total_price = 0;
                $('div#cd-cart ul.cd-cart-items').html('');

                result.forEach(function(item, index) {
                    var prod_html = '<li>';
                    prod_html += '<span class="cd-qty">' + item.quantity + '</span> ' + item.product.name;
                    prod_html += '<div class="cd-price">$' + item.product.price + '</div>';
                    prod_html += '<a href="#0" class="cd-item-remove cd-img-replace">Remove</a>';
                    prod_html += '</li>';
                    $('div#cd-cart ul.cd-cart-items').append(prod_html);
                    total_price += item.product.price;
                });

                $('div.cd-cart-total span').html('$' + total_price);
            }
        });
    }

    $(function () {
        updateBasket();
    });
</script>
