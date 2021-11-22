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
	<h3>Cadastro de Cliente</h3>
	<div id="idFormulario">
		<form:form action="adicionarCliente" method="post"
			modelAttribute="obj">
			<div>
				<label for="nome">Primeiro Nome</label>
				<form:input path="primeiroNome" />
				<form:errors path="primeiroNome" />
			</div>
			<div>
				<label for="criador">SobreNome</label>
				<form:input path="sobreNome" />
				<form:errors path="sobreNome" />
			</div>
			<div>
				<label for="criador">Email</label>
				<form:input path="email" />
				<form:errors path="email" />
			</div>
			
			<div>
				<label for="criador">Senha</label>
				<form:input path="senha" />
				<form:errors path="senha" />
			</div>
			
			<div>
				<input type="submit" value="Gravar">
			</div>
		</form:form>		
</body>
</html>