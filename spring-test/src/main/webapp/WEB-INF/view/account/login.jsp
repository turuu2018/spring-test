<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <form:form class="form-horizontal" modelAttribute="loginForm" method="POST" action="${pageContext.request.contextPath}/login?${_csrf.parameterName}=${_csrf.token}">
                <div class="form-group">
                    <label class="col-sm-3">Email address</label>
                    <div class="col-sm-9">
                        <form:input path="username" type="email" class="form-control" placeholder="Email"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3">Password</label>
                    <div class="col-sm-9">
                        <form:password path="password" class="form-control" placeholder="Password"/>
                    </div>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="remember-me"> Remember me
                    </label>
                </div>
                <button type="submit" class="btn btn-default">Login</button>
            </form:form>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
