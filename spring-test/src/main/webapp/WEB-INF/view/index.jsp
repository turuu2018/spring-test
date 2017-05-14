<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            Spring Test 1
        </div>
        <div class="col-md-4">
            Spring Test 2
        </div>
        <div class="col-md-4">
            Spring Test 3
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-bordered">
                <thead>
                    <th>Username</th>
                    <th>Last Name</th>
                    <th>First Name</th>
                    <th>Registered Date</th>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="_user">
                        <tr>
                            <td><a class="link_user" href="" data-id="${_user.id}">${_user.username}</a></td>
                            <td>${_user.lastName}</td>
                            <td>${_user.firstName}</td>
                            <td><fmt:formatDate value="${_user.registeredDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <span id="json_test" class="text-warning"></span>
        </div>
    </div>
</div>

<script>
    $(function() {
        $('.link_user').click(function(e) {
            e.preventDefault();

            var user_id = $(this).attr('data-id');
            $.getJSON("<c:url value="/api/user/"/>" + user_id, function(result){
                $('#json_test').append(result.username + '<br>');
            });
        });
    });
</script>
