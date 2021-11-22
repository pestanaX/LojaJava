<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
 <h3> Resultado da Pesquisa</h3>
     <table>
		<tr>
			<td>Categoria</td>
			<td>Criador</td>
		</tr>
		<c:forEach items="${categoria}" var="categoria1">
			<tr>
				<td>${categoria.descricaoCategoria}</td>
				<td>${categoria.criadoPor}</td>
				<th><a href="mostraCategoria?id=${categoria.idCategoria}">Editar<a></th>
				<th>Apagar</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>