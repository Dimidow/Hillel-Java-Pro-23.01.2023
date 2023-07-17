<%@ page import="org.my.homeworks.entities.Order" %>
<%@ page import="org.my.homeworks.entities.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order</title>
</head>
<body>

    <% if (request.getAttribute("order") != null) { %>
        <h1>Order details:</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Cost</th>
                <th>Products</th>
            </tr>
            <% Order order = (Order) request.getAttribute("order"); %>
            <tr>
                <td><%= order.getId() %></td>
                <td><%= order.getDate() %></td>
                <td><%= order.getCost() %></td>
                <td>
                    <ul>
                        <% for (Product product : order.getProducts()) { %>
                            <li><%= product.getName() %> - <%= product.getCost() %></li>
                        <% } %>
                    </ul>
                </td>
            </tr>
        </table>
    <% } %>
</body>
</html>
