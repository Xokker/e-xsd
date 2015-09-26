<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h1>Stats:</h1>
    <p>Сумма всех заказов: ${stats.totalOverall}</p>
    <p>ID клиента с максимальной суммой заказов: ${stats.biggestClient}</p>
    <p>Сумма максимального заказа: ${stats.totalOfBiggestOrder}</p>
    <p>Сумма минимального заказа: ${stats.totalOfSmallestOrder}</p>
    <p>Количество заказов: ${stats.numberOfOrders}</p>
    <p>Средняя сумма заказа: ${stats.avgTotalOfOrders}</p>
</body>
</html>
