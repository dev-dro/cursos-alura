<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Livros de Java, Android, iPhone, PHP, Ruby e muito mais - Casa do Código</title>
</head>
<body>
<form:form action="${s:mvcUrl('PC#gravar').build()}" method="POST" commandName="produto">
    <div>
        <label>Título</label>
        <form:input type="text" path="titulo"/>
        <form:errors path="titulo"/>
    </div>
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
        <form:errors path="descricao"/>
    </div>
    <div>
        <label>Páginas</label>
        <form:input type="text" path="paginas"/>
        <form:errors path="paginas"/>
    </div>
    <div>
        <label>Data de Lançamento</label>
        <form:input path="dataLancamento" type="text" />
        <form:errors path="dataLancamento" />
    </div>
    <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
        <div>
            <label>${tipoPreco}</label>
            <form:input type="text" path="precos[${status.index}].valor"/>
            <form:input type="hidden" path="precos[${status.index}].tipo" value="${tipoPreco}"/>
        </div>
    </c:forEach>
    <div>
        <label>Sumario</label>
        <input type="file" name="sumario"/>
    </div>

    <button type="submit">Cadastrar</button>
</form:form>
</body>
</html>
