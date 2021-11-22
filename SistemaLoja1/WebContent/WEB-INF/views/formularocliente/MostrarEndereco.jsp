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
	<h3>Endereço</h3>
	<p>Estado :${endereco.estado }</p>
	<p>Municipio :${endereco.municipio}</p>
	<p>Bairro :${endereco.bairro }</p>
	<p>Rua :${endereco.rua }</p>
	<p>Complementar :${endereco.estado }</p>
	<p>Celular :${endereco.celular }</p>
	<p>Telefone :${endereco.telefone }</p>
	<div>
		<a href="alterarEndereco?id=${endereco.id}">Alterar Endereço<a>
	</div>
</body>
</html>