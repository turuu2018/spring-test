<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <form:form class="form-horizontal" modelAttribute="imageUploadForm" method="POST" action="${pageContext.request.contextPath}/image-upload?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
                <!--<span class="text-danger">
                    <form:errors path="*"/>
                </span>-->

                <div class="form-group">
                    <label class="col-sm-3">Images</label>
                    <div class="col-sm-9">
                        <input type="file" name="images" multiple/>
                        <span class="text-danger">
                            <form:errors path="images"/>
                        </span>
                    </div>
                </div>

                <button type="submit" class="btn btn-default">Upload</button>
            </form:form>
        </div>
    </div>
</div>

<script>
    $(function() {
        //
    });
</script>
