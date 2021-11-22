<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Endereço do Fornecidor</title>
</head>
<body>
	<h3>Alterar a Endereco -${endereco.descricaoCategoria} </h3>
	<div id="idFormulario">
		<form action="alterarEnderecoFornecidor" method="post">
			<div>
			    <input type="hidden" name="idCategoria" value="${categoria.idCategoria}" />
				<label for="descricao">Categoria </label> <input type="text"
					name="descricaoCategoria" id="descricaoCategoria" value="${categoria.descricaoCategoria} "/>
			      <input type="hidden"
					name="criadoPor" id="criadoPor" value="${categoria.criadoPor}"/>
			</div>
			<div>
				           
			</div>
			<div>
				<input type="submit" value="Alterar">
			</div>

		</form>
		<div>
			<a href="ProcurarCategoria">Procurar</a> <a
				href="ListaCategoria">Listar Categoria</a>
		</div>
	</div>

</body>
</html>