<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<div style="width: 100%; height: 30px;">
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
