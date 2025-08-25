<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
    <h2>Simple Calculator</h2>
    <form action="calculate" method="post">
        Number 1: <input type="text" name="num1" required><br><br>
        Number 2: <input type="text" name="num2" required><br><br>
        Operation:
        <select name="operation">
            <option value="add">Add (+)</option>
            <option value="subtract">Subtract (-)</option>
            <option value="multiply">Multiply (*)</option>
            <option value="divide">Divide (/)</option>
        </select><br><br>
        <input type="submit" value="Calculate">
    </form>

    <h3>
        <% if (request.getAttribute("result") != null) { %>
            Result: <%= request.getAttribute("result") %>
        <% } else if (request.getAttribute("error") != null) { %>
            <span style="color:red;"><%= request.getAttribute("error") %></span>
        <% } %>
    </h3>
</body>
</html>