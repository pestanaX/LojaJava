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
	<h3>Alterar o Endereco</h3>
	<div id="idFormulario">
		<form:form action="alterarEndereco" method="post" modelAttribute="obj">
			<input type="hidden" name="id" value="${endereco.id}" />

			<div>
				<label for="Estado">Estado</label>
				<form:input path="estado" value="${endereco.estado}" />
				<form:errors path="estado" />
			</div>
			<div>
				<label for="Municipio">Municipio</label>
				<form:input path="municipio" value="${endereco.municipio}" />
				<form:errors path="municipio" />
			</div>
			<div>
				<label for="Bairro">Bairro</label>
				<form:input path="bairro" value="${endereco.bairro}" />
				<form:errors path="bairro" />
			</div>

			<div>
				<label for="Rua">Rua</label>
				<form:input path="rua" value="${endereco.rua}" />
				<form:errors path="rua" />
			</div>
			<div>
				<label for="Numero">Numero</label>
				<form:input path="numeroDaCasa" value="${endereco.numeroDaCasa}" />
				<form:errors path="numeroDaCasa" />
			</div>
			<div>
				<label for="Complementar">Complementar</label>
				<form:input path="complementar" value="${endereco.complementar}" />
				<form:errors path="complementar" />
			</div>
			<div>
				<label for="criador">CPF</label>
				<form:input path="cpf" value="${endereco.cpf}" />
				<form:errors path="cpf" />
			</div>
			<div>
				<label for="criador">Celular</label>
				<form:input path="celular" value="${endereco.celular}" />
				<form:errors path="celular" />
			</div>
			<div>
				<label for="criador">Telefone</label>
				<form:input path="telefone" value="${endereco.telefone}" />
				<form:errors path="telefone" />
			</div>
			
			<div>
				<form:hidden path="Cliente.idCliente"
					value="${endereco.cliente.idCliente}" />
			</div>
			<div>
				<input type="submit" value="Alterar">
			</div>
		</form:form>
</body>
</html>