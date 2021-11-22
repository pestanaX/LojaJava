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
	<h3>Cadastro de Endereco</h3>
	<div id="idFormulario">
		<form:form action="adicionarEndereco" method="post"
			modelAttribute="obj">
			<p></p>
			
			<div>
				<label for="Estado">Estado</label>
				<form:input path="estado" />
				<form:errors path="estado" />
			</div>
			<div>
				<label for="Municipio">Municipio</label>
				<form:input path="municipio" />
				<form:errors path="municipio" />
			</div>
			<div>
				<label for="Bairro">Bairro</label>
				<form:input path="bairro" />
				<form:errors path="bairro" />
			</div>
			
			<div>
				<label for="Rua">Rua</label>
				<form:input path="rua" />
				<form:errors path="rua" />
			</div>
			<div>
				<label for="Numero">Numero</label>
				<form:input path="numeroDaCasa" />
				<form:errors path="numeroDaCasa" />
			</div>
			<div>
				<label for="Complementar">Complementar</label>
				<form:input path="complementar" />
				<form:errors path="complementar" />
			</div>
			<div>
				<label for="criador">CPF</label>
				<form:input path="cpf" />
				<form:errors path="cpf" />
			</div>
			<div>
				<label for="criador">Celular</label>
				<form:input path="celular" />
				<form:errors path="celular" />
			</div>
			<div>
				<label for="criador">Telefone</label>
				<form:input path="telefone" />
				<form:errors path="telefone" />
			</div>
			 <div>			
			 <input type="hidden" name="cliente.idCliente" value="${clienteLogado.getIdCliente()}" />	
			</div>		
						
			<div>
				<input type="submit" value="Gravar">
			</div>
		</form:form>		
</body>
</html>