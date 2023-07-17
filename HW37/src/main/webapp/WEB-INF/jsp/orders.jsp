<%@ page import="org.my.homeworks.entities.Order" %>
<%@ page import="org.my.homeworks.entities.Product" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Orders</title>
</head>
<body>


    <% if (request.getAttribute("orders") != null) { %>
        <h1>Orders list:</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Cost</th>
                <th>Products</th>
            </tr>
            <% List<Order> orders = (List<Order>) request.getAttribute("orders"); %>
            <% for (Order order : orders) { %>
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
            <% } %>
        </table>
    <% } %>
</body>
</html>
