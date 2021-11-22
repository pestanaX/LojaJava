<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Alterar a Funcionalidade -${funcao.descricao} </h3>
	<div id="idFormulario">
		<form action="alterarFuncao" method="post">
			<div>
			    <input type="hidden" name="id_funcao" value="${funcao.id_funcao}" />
				<label for="descricao">Funcionalidade</label> <input type="text"
					name="descricao" id="descricao" value="${funcao.descricao} "/>
			</div>
			<div>
				<label for="criador">Criador</label> <input type="text"
					name="criador" id="criador"  value ="${funcao.criador }"/>              
			</div>
			<div>
				<input type="submit" value="Alterar">
			</div>

		</form>
		<div>
			<a href="ProcurarFuncao">Procurar</a> <a
				href="ListaFuncionalidades">Listar Funções</a>
		</div>
	</div>

</body>
</html>