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
			<td>Função</td>
			<td>Criador</td>
		</tr>
		<c:forEach items="${funcao}" var="funcao1">
			<tr>
				<td>${funcao.descricao}</td>
				<td>${funcao.criador}</td>
				<th><a href="mostraFuncao?id=${funcao.id_funcao}">Editar<a></th>
				<th>Apagar</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>