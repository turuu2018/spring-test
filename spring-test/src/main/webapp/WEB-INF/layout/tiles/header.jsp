<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<header>
    <div id="logo"><img src="<c:url value="/static/img/cd-logo.svg"/>" alt="Homepage"></div>

    <div><a class="cd-img-replace" href="#0">Menu</a></div>
    <div id="cart_trigger"><a class="cd-img-replace" href="#0">Cart</a></div>
</header>

<nav id="main-nav">
    <ul>
        <li><a href="#0">Home</a></li>
        <li><a href="#0">About</a></li>
        <li><a class="current" href="#0">Services</a></li>
        <li><a href="#0">Gallery</a></li>
        <li>
            <form:form modelAttribute="searchForm" method="GET" action="${pageContext.request.contextPath}/search?${_csrf.parameterName}=${_csrf.token}" class="form-horizontal">
                <form:input path="searchText" placeholder="Хайх" class="form-control"/>
            </form:form>
        </li>
    </ul>
</nav>

<div style="width: 100%; height: 30px; margin-top: 80px;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6"></div>
            <div class="col-md-6">
                <div class="pull-right">
                    <a href="?lang=mn">MN</a>
                    |
                    <a href="?lang=en">EN</a>

                    <sec:authorize access="isAuthenticated()">
                        <sec:authentication property="principal.username"/>
                        <a href="<c:url value="/logout"/>">Logout</a>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <a href="<c:url value="/login"/>">Login</a>
                        <a href="<c:url value="/register"/>">Register</a>
                    </sec:authorize>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/view/basket.jsp"/>

<script>
    function toggle_panel_visibility($lateral_panel, $background_layer, $body) {
        if ($lateral_panel.hasClass('speed-in')) {
            // firefox transitions break when parent overflow is changed, so we need to wait for the end of the trasition to give the body an overflow hidden
            $lateral_panel.removeClass('speed-in').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
                $body.removeClass('overflow-hidden');
            });
            $background_layer.removeClass('is-visible');

        } else {
            $lateral_panel.addClass('speed-in').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
                $body.addClass('overflow-hidden');
            });
            $background_layer.addClass('is-visible');
        }
    }

    function toggle_panel_visibility($lateral_panel, $background_layer, $body) {
        if ($lateral_panel.hasClass('speed-in')) {
            // firefox transitions break when parent overflow is changed, so we need to wait for the end of the trasition to give the body an overflow hidden
            $lateral_panel.removeClass('speed-in').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
                $body.removeClass('overflow-hidden');
            });
            $background_layer.removeClass('is-visible');

        } else {
            $lateral_panel.addClass('speed-in').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
                $body.addClass('overflow-hidden');
            });
            $background_layer.addClass('is-visible');
        }
    }

    $(function () {
        $menu_navigation = $('#main-nav'),
                $lateral_cart = $('#cd-cart'),
                $shadow_layer = $('#cd-shadow-layer');

        $('#cart_trigger').click(function (e) {
            e.preventDefault();
            //close lateral menu (if it's open)
            $menu_navigation.removeClass('speed-in');
            toggle_panel_visibility($lateral_cart, $shadow_layer, $('body'));
        });
    });
</script>
