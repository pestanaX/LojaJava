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
			<td>Fornecidor</td>
			<td>Criador</td>
			<td>Modificador</td>
		</tr>
		
		 <c:forEach items="${fornecidor}" var="fornecidor1">
			<tr>
				<td>${fornecidor1.nomeDoFornecidor}</td>
				<td>${fornecidor1.criadoPor}</td>
				<td>${fornecidor1.modificadoPor}</td>
				<th><a href="mostraFornecidor?id=${fornecidor1.idFornecidor}">Editar<a></th>
				<th>Apagar</th>
				<th><a href="adicionarEnderecoFornecidor?id=${fornecidor1.idFornecidor}">Endereço<a></th>
			</tr>

		 </c:forEach>  
	</table>
	<div>        
		<a href="ProcurarFornecidor">Procurar Fornecidor</a> <a href="Fornecidor">Cadastrar Fornecidor
			</a>
	</div>
</body>
</html>