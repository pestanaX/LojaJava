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
	<h3>Area do Cliente</h3>
	<div>
		<p>Ola ${clienteLogado.getPrimeiroNome()}</p>
	</div>
	<br>
	<div></div>
	<div id="Menu">
		<ul id="MenuPrincipal">
			<li>Perfil
				<ul>
					<li><a href="Dados">Meus Dados</a></li>					
					<li><a href="mostraEndereco?id=${clienteLogado.getIdCliente()}">Endereço</a></li> 
				</ul>
			</li>
			<li>Pedidos				
			<ul>
					<li><a href="">Abertos</a></li>
					<li><a href="">Fechados</a></li>
					<li><a href="">Pendentes</a></li>

				</ul>
			</li>
		</ul>
	</div>
</body>
</html>