<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listas de Categoria</title>
</head>
<body>
	<h3>Listas de Categoria</h3>
	<table>
		<tr>
			<td>Categoria</td>
			<td>Criador</td>
			<td>Modificador</td>
		</tr>
		
		 <c:forEach items="${categoria}" var="categoria1">
			<tr>
				<td>${categoria1.descricaoCategoria}</td>
				<td>${categoria1.criadoPor}</td>
				<td>${categoria1.modificadoPor}</td>
				<th><a href="mostraCategoria?id=${categoria1.idCategoria}">Editar<a></th>
				<th>Apagar</th>
			</tr>

		 </c:forEach>  
	</table>
	<div>        
		<a href="ProcurarCategoria">Procurar Categoria</a> <a href="Categoria">Cadastrar
			Categoria</a>
	</div>
</body>
</html>