<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <form:form class="form-horizontal" modelAttribute="registerForm" method="POST" action="${pageContext.request.contextPath}/register?${_csrf.parameterName}=${_csrf.token}">
                <!--<span class="text-danger">
                    <form:errors path="*"/>
                </span>-->

                <div class="form-group">
                    <label class="col-sm-3"><fmt:message key="username"/></label>
                    <div class="col-sm-9">
                        <form:input path="username" type="email" class="form-control" placeholder="И-мэйл"/>
                        <span class="text-danger">
                            <form:errors path="username"/>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3"><fmt:message key="password1"/></label>
                    <div class="col-sm-9">
                        <form:password path="password1" class="form-control" placeholder="Нууц үг"/>
                        <span class="text-danger">
                            <form:errors path="password1"/>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3"><fmt:message key="password2"/></label>
                    <div class="col-sm-9">
                        <form:password path="password2" class="form-control" placeholder="Нууц үг /давтахх/"/>
                        <span class="text-danger">
                            <form:errors path="password2"/>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3"><fmt:message key="lastname"/></label>
                    <div class="col-sm-9">
                        <form:input path="lastName" class="form-control" placeholder="Овог"/>
                        <span class="text-danger">
                            <form:errors path="lastName"/>
                        </span>
                    </div>
                </div>
                    <div class="form-group">
                    <label class="col-sm-3"><fmt:message key="firstname"/></label>
                    <div class="col-sm-9">
                        <form:input path="firstName" class="form-control" placeholder="Нэр"/>
                        <span class="text-danger">
                            <form:errors path="firstName"/>
                        </span>
                    </div>
                </div>
                <button type="submit" class="btn btn-default"><fmt:message key="register"/></button>
            </form:form>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
