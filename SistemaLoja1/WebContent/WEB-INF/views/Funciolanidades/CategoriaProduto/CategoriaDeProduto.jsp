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
	<h3>Cadastro de Categoria</h3>
	<div id="idFormulario">
		<form:form action="adicionarCategoria" method="post"
			modelAttribute="obj">
			<div>
				<label for="nome">Descricao da Categoria</label>
				<form:input path="descricaoCategoria" />
				<form:errors path="descricaoCategoria" />
			</div>
			<div>
				<label for="criador">Criador</label>
				<form:input path="criadoPor" />
				<form:errors path="criadoPor" />
			</div>
			
			<div>
				<input type="submit" value="Gravar">
			</div>
		</form:form>		
</body>
</html>