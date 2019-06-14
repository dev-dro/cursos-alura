<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="servletUrl" value="/entrada"/>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Nova Empresa</title>
</head>
<body>
<c:import url="logout-parcial.jsp"/>
<form action="${servletUrl}" method="post">
  <input type="hidden" name="acao" value="NovaEmpresa">
  Nome: <label>
  <input type="text" name="nome">
</label><br/>
  Data de Abertura: <label>
  <input type="text" name="data">
</label><br/>
  <input type="submit">
</form>
</body>
</html>