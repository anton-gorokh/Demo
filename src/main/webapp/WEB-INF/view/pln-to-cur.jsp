<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: anton-gorokh
  Date: 03.03.2022
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<% String currencyCode = request.getAttribute("currencyCode").toString().toUpperCase(); %>
<head>
    <title>PLN to <%= currencyCode%></title>
</head>
<body>
<p>PLN to <%= currencyCode%> exchange rate for last 5 days: </p>

<%
    List<String> rates = (List<String>) request.getAttribute("list");
%>
<%
    for (int i = 1; i <= rates.size(); i++) {
%>
    <tr>
        <br><%= String.format("%d: %s", i, rates.get(rates.size() - i))%></br>
    </tr>
<%
    }
%>
</body>
</html>
