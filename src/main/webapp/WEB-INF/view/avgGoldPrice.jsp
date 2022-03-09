<%--
  Created by IntelliJ IDEA.
  User: anton-gorokh
  Date: 09.03.2022
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Average Gold Price</title>
</head>
<body>
<p>The average 1g gold price for the last 14 business days is <%= String.format("%.2f", (double) request.getAttribute("price"))%> pln.</p>
</body>
</html>
