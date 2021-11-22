<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listas de funcionaliades do sistema</title>
</head>
<body>
	<h3>Listas de Funcionalidade</h3>
	<table>
		<tr>
			<td>Função</td>
			<td>Criador</td>
		</tr>
		
		 <c:forEach items="${funcoes}" var="funcao1">
			<tr>
				<td>${funcao1.descricao}</td>
				<td>${funcao1.criador}</td>
				<th><a href="mostraFuncao?id=${funcao1.id_funcao}">Editar<a></th>
				<th>Apagar</th>
			</tr>

		 </c:forEach>  
	</table>
	<div>        
		<a href="ProcurarFuncao">Procurar</a> <a href="Funcao">Cadastrar
			Função</a>
	</div>
</body>
</html>