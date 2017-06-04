<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div ng-app="basketApp" ng-controller="basketController">
    <div id="cd-shadow-layer"></div>

    <div id="cd-cart">
        <h2>Cart</h2>
        <ul class="cd-cart-items" ng-repeat="bi in basketItems">
            <li>
                <span class="cd-qty">{{ bi.quantity }}</span> {{ bi.product.name }}
                <div class="cd-price">{{ bi.product.price | currency }}</div>
                <a href="#0" class="cd-item-remove cd-img-replace">Remove</a>
            </li>
        </ul> <!-- cd-cart-items -->

        <div class="cd-cart-total">
            <p>Total <span>{{ total | currency }}</span></p>
        </div> <!-- cd-cart-total -->

        <a href="#0" class="checkout-btn">Checkout</a>

        <p class="cd-go-to-cart"><a href="#0">Go to cart page</a></p>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/static/js/angular-1.6.4.min.js"/>"></script>
<script>
    var app = angular.module('basketApp', []);
    app.controller('basketController', function($scope, $http) {
        $http.get('<c:url value="/api/basket"/>').then(function(response) {
            $scope.basketItems = response.data;
            //
        });
    });
</script>
