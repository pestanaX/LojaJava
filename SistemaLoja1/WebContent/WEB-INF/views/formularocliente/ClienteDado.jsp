<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Meus Dados</h3>
	<div>
		<p>Primeiro Nome : ${clienteLogado.getPrimeiroNome()}</p>
		<p>SobreNome: ${clienteLogado.getSobreNome()}</p>
		<p>Email: ${clienteLogado.getEmail()}</p>
	</div>
	<div>
		<a href="alterarDadosCliente?id=${clienteLogado.getIdCliente()}">Alterar Dados<a>
	</div>
</body>
</html>