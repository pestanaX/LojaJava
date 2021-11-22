<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Cadastro de Usuario</h3>
	<div id="idFormulario">
		<form:form action="adicionarUsuario" method="post"
			modelAttribute="obj">
			<div>
				<label for="nome">Nome Completo</label>
				<form:input path="nomeUsuario" />
				<form:errors path="nomeUsuario" />
			</div>
			<div>
				<label for="criador">UserName</label>
				<form:input path="userName" />
				<form:errors path="userName" />
			</div>
			<div>
				<label for="criador">Senha</label>
				<form:input path="senha" />
				<form:errors path="senha" />
			</div>
			<div>
				<label for="criador">Criador</label>
				<form:input path="criador" />
				<form:errors path="criador" />
			</div>
			<div>
				<c:forEach items="${funcoes}" var="funcao1">
					<p>
						<form:checkbox path="funcaoAdministrador" items="${funcao1}" value ="${funcao1} }" />
						<label for="nome">"${funcao1.descricao}"</label>
					</p>
				</c:forEach>
			</div>
			<div>
				<input type="submit" value="Gravar">
			</div>
		</form:form>
		<div>
			<a href="ProcurarFuncao">Procurar Usuario</a> <a href="ListaUsuario">
				Listar de Usuario </a>
		</div>
</body>
</html>