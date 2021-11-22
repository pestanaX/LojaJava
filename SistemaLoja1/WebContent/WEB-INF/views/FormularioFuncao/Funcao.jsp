<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Funcionalidades do Sistema</title>
</head>
<body>
	<h3>Cadastro de Funcionalidades</h3>
	<div id="idFormulario">
	        <form:form action="adicionarFuncionalidades" method="post" modelAttribute="obj" >
			<div>
				<label for= "descricao">Funcionalidade</label>					
					<form:input path= "descricao"/>
					<form:errors path= "descricao"/>
			</div>
			<div>
				<label for="criador">Criador</label>					
					<form:input path="criador"/>
					<form:errors path="criador"/>
			</div>
			<div>
				<input type="submit" value="Gravar">
			</div>			

		</form:form>
		<div>
			<a href="ProcurarFuncao">Procurar</a> <a href="ListaFuncionalidades">Listar
				Funções</a>
		
	</div>

</body>
</html>