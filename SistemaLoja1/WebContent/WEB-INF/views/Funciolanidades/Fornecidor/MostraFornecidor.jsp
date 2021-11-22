<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Alterar o Fornecidor -${fornecidor.nomeDoFornecidor} </h3>
	<div id="idFormulario">
		<form action="alterarFornecidor" method="post">
			<div>
			    <input type="hidden" name="idFornecidor" value="${fornecidor.idFornecidor}" />
				<label for="descricao">Fornecidor </label> <input type="text"
					name="nomeDoFornecidor" id="nomeDoFornecidor" value="${fornecidor.nomeDoFornecidor} "/>
			      <input type="hidden"
					name="criadoPor" id="criadoPor" value="${fornecidor.criadoPor}"/>
			</div>
			<div>
				           
			</div>
			<div>
				<input type="submit" value="Alterar">
			</div>

		</form>
		<div>
			<a href="ProcurarFornecidor">Procurar</a> <a
				href="ListaFornecidor">Listar Categoria</a>
		</div>
	</div>

</body>
</html>