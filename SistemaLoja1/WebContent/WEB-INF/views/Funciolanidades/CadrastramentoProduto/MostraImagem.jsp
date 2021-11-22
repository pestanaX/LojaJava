<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Imagem do Produto</title>
</head>
<body>
	<h3>Imagens Do Produto - "${produto.descricaoProduto}" </h3>

	<c:forEach items="${imagem}" var="arrayImagem">
		<img src="<spring:url value ="${arrayImagem}"/>" width="300"
			height="300">
		<p>${arrayImagem}</p>
	</c:forEach>
	<div>        
		<a href="ProcurarProduto">Procurar Produto</a>
		<a href="alterarImagem?id=${dadosImagem.idImagem}">Alterar Imagem<a>
		 
	</div>


</body>
</html>