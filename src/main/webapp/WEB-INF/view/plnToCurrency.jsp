<%@ page import="java.util.List" %>
<%@ page import="java.time.LocalDate" %>

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
<p>PLN to <%= currencyCode%> exchange rate for last 5 business days: </p>

<%
    List<LocalDate> dates = (List<LocalDate>) request.getAttribute("dates");
    List<Double> prices = (List<Double>) request.getAttribute("prices");
%>
<%
    for (int i = 0; i < dates.size(); i++) {
%>
    <tr>
        <br><%= String.format("%s: %f", dates.get(i).toString(), prices.get(i))%></br>
    </tr>
<%
    }
%>
</body>
</html>
