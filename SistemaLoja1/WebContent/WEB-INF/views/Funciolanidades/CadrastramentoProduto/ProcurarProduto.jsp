<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <h3> Pesquisar Produto</h3>
        <form action="procurarProduto" method="get">
			<div>
				<label for="descricaoProduto">Descrição Do Produto</label> <input type="text"
					name="descricao" id="descricao" />
			</div>
			<div>
				<label for="Codigo">Codigo Do Produto</label> <input type="text"
					name="codigo" id="codigo" />
			</div>
			<div>
				<input type="submit" value="Pesquisar">
			</div>
			
		</form>
		<div>
			<a href="Produto">Cadastrar Produto</a>				
		</div>
	</div>

</body>
</html>