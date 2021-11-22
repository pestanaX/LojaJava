<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listas de funcionaliades do sistema</title>
</head>
<body>

	<h3>Funcionalidade Para o ${Usuario.userName} </h3>
	<form:form action="FuncionalidadeUsuario" method="post" modelAttribute="Usuario">
		<table>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<c:forEach items="${funcoes}" var="funcao1">
				<tr>
					<td><from :checkbox  paths ="funcaoAdiministrador"  value ="${funcao1.descricao}"></td>					
					<th><a href="mostraFuncao?id=${funcao1.id_funcao}">Editar<a></th>
					<th>Apagar</th>
				</tr>
			</c:forEach>
		</table>
		<div>
			<input type="submit" value="Gravar">
		</div>
	</form:form>
	<div>
		<a href="ProcurarFuncao">Procurar</a> <a href="Funcao">Cadastrar
			Função</a>
	</div>
</body>
</html>