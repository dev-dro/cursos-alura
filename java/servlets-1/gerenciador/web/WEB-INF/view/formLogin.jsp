<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="linkEntradaServlet" value="/entrada" />
<html>
<head>
  <title>Login</title>
</head>
<body>
  <form action="${linkEntradaServlet}" method="post">
    <input type="hidden" name="acao" value="Login" />
    Login: <input type="text" name="login" />
    Senha: <input type="password" name="senha" />
    <input type="submit" />
  </form>
</body>
</html>
