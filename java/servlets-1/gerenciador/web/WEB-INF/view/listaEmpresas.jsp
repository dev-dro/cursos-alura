<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="empresas" scope="request" type="java.util.List"/>
<jsp:useBean id="usuarioLogado" scope="session" type="br.com.alura.gerenciador.modelo.Usuario"/>

<html>
<head>
  <title>Lista de Empresas</title>
</head>
<body>
<c:import url="logout-parcial.jsp"/>
<h3>Usuario Logado: ${usuarioLogado.login}</h3>
<ul>
  <c:forEach items="${empresas}" var="empresa">
    <li>
        ${empresa.id} - ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
      <a href="<c:url value="/entrada?acao=MostraEmpresa&id=${empresa.id}"/>"> editar</a>
      <a href="<c:url value="/entrada?acao=RemoveEmpresa&id=${empresa.id}"/>"> remover</a>
    </li>
  </c:forEach>
</ul>
</body>
</html>
