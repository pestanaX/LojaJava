<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Listas de Produto</title>
</head>
<body>
	<h3>Listas de Produto</h3>
	<table>
		<tr>
			<td>Descriçao</td>
			<td>Preço</td>
			<td>Quantidade</td>
			<td>Criador</td>
			<td>Modificador</td>
		</tr>
		
		 <c:forEach items="${produto}" var="produto1">
			<tr>
				<td>${produto1.descricaoProduto}</td>
				<td>${produto1.preco}</td>
				<td>${produto1.quantidade}</td>
				<td>${produto1.criadoPor}</td>
				<td>${produto1.modificadoPor}</td>
				<th><a href="mostraProduto?id=${produto1.idProduto}">Editar<a></th>
				<th>Apagar</th>
				<th><a href="adicionarImagem?id=${produto1.idProduto}">Adicionar Imagem<a></th>
				
			</tr>

		 </c:forEach>  
	</table>
	<div>        
		<a href="ProcurarProduto">Procurar Produto</a> <a href="Produto">Cadastrar
			Produto</a>
	</div>
</body>
</html>