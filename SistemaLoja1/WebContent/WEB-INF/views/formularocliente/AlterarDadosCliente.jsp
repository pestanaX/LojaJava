<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Alteraçao Dados</h3>
	<div>
		<p>Primeiro Nome : ${clienteLogado.getPrimeiroNome()}</p>
		<p>SobreNome: ${clienteLogado.getSobreNome()}</p>
	</div>
	<div id="idFormulario">
		<form action="alterarCliente" method="post">
			<div>
				<input type="hidden" name="idCliente"
					value="${clienteLogado.getIdCliente()}" /> 
					<input type="hidden"
					name="primeiroNome" value="${clienteLogado.getPrimeiroNome()}" />

				<input type="hidden" name="sobreNome"
					value="${clienteLogado.getSobreNome()}" />
				
				 <label for="Email">Email</label>
				<input type="text" name="email" id="email"
					value="${clienteLogado.getEmail()} " />
			</div>
			<div>
				<label for="criador">Senha Antiga</label> <input type="text"
					name="senhaAntiga" id="criador" />
			</div>
			<div>
				<label for="criador">Senha Nova</label> <input type="text"
					name="senhaNova" id="criador" />
			</div>
			<div>
				<label for="criador">Confirmar Senha</label> <input type="text"
					name="senha" id="criador" />
			</div>
			<div>
				<input type="submit" value="Alterar">
			</div>

		</form>
		<div>
</body>
</html>