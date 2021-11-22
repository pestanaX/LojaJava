<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Pesquisa</title>
</head>
<body> 
 <h3> Resultado da Pesquisa</h3>
     <table>
		<tr>
			<td>Fornecidor</td>
			<td>Criador</td>
		</tr>
		<c:forEach items="${fornecidor}" var="fornecidor1">
			<tr>
				<td>${fornecidor.nomeDoFornecidor}</td>
				<td>${fornecidor.criadoPor}</td>
				<th><a href="mostraFornecidor?id=${fornecidor.idFornecidor}">Editar<a></th>
				<th>Apagar</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>