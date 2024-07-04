<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calculate Commission</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Calculate Commission</h1>
    <form action="${pageContext.request.contextPath}/commission" method="post">
        <label for="isSalaried">Is Salaried:</label>
        <input type="checkbox" name="isSalaried" id="isSalaried"><br>

        <label for="itemPrice">Item Price:</label>
        <input type="text" name="itemPrice" id="itemPrice"><br>

        <label for="itemType">Item Type:</label>
        <select name="itemType" id="itemType">
            <option value="STANDARD">Standard</option>
            <option value="BONUS">Bonus</option>
            <option value="OTHER">Other</option>
        </select><br>

        <label for="customerType">Customer Type:</label>
        <select name="customerType" id="customerType">
            <option value="REGULAR">Regular</option>
            <option value="NON_REGULAR">Non-Regular</option>
        </select><br>

        <input type="submit" value="Calculate">
    </form>

    <c:if test="${not empty commission}">
        <h1>Commission Result</h1>
        <p>Commission: ${commission}</p>
    </c:if>
</div>
</body>
</html>