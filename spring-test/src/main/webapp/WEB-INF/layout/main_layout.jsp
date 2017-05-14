<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <meta name="description" content="spring test project"/>
        <meta name="keywords" content="spring test"/>
        <meta name="author" content="Turuu"/>

        <title>Spring Test</title>

        <!-- CSS -->
        <link rel="stylesheet" href="<c:url value="/static/css/bootstrap.min.css"/>"/>

        <!-- JS -->
        <script type="text/javascript" src="<c:url value="/static/js/jquery-1.11.1.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
    </head>
    <body class="body-offcanvas">
        <div class="wrap">
            <tiles:insertAttribute name="header" />
            <tiles:insertAttribute name="content" />
        </div>

        <tiles:insertAttribute name="footer" />
        <!-- Core JS -->
    </body>
</html>
