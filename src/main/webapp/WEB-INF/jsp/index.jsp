<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Hey there, тест!</title>
</head>
<body>
    <h1>Загрузка файла</h1>

    <c:if test="${not empty error}">
        <p>Error: ${error}</p>
    </c:if>

    <form id="fileUpload" method="POST" enctype="multipart/form-data" action="/">
        File to upload: <input type="file" name="file"><br />
        <input id="btn" type="submit" value="Upload"> Press here to upload the file!
    </form>
</body>
</html>
