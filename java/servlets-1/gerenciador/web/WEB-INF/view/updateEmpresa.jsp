<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="empresa" scope="request" type="br.com.alura.gerenciador.modelo.Empresa"/>
<c:url var="servletUrl" value="/entrada"/>

<html>
<head>
  <title>Editar Empresa</title>
</head>
<body>
<c:import url="logout-parcial.jsp" />
<form action="${servletUrl}" method="post">
  <input type="hidden" name="acao" value="AlteraEmpresa" />
  Nome: <label>
  <input type="text" name="nome" value="${empresa.nome}">
</label><br/>
  Data de Abertura: <label>
  <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>">
</label><br/>
  <input type="hidden" name="id" value="${empresa.id}">
  <input type="submit">
</form>
</body>
</html>
