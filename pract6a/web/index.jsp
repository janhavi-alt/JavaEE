<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple Currency Converter (EJB)</title></head>
<body>
  <h2>Currency Converter (Demo)</h2>
  <form method="post" action="${pageContext.request.contextPath}/convert">
    Amount: <input type="text" name="amount" value="100"/><br/><br/>
    From:
    <select name="from">
      <option>USD</option>
      <option>EUR</option>
      <option>INR</option>
      <option>GBP</option>
      <option>JPY</option>
    </select>
    To:
    <select name="to">
      <option>INR</option>
      <option>USD</option>
      <option>EUR</option>
      <option>GBP</option>
      <option>JPY</option>
    </select>
    <br/><br/>
    <button type="submit">Convert</button>
  </form>
</body>
</html>
