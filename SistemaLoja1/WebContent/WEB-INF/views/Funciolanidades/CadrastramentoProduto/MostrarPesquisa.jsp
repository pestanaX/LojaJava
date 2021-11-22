<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Resultado da Pesquisa</h3>
	<table>
		<tr>
			<td>Descriçao</td>
			<td>Preço</td>
			<td>Quantidade</td>
			<td>Criador</td>
			<td>Modificador</td>
		</tr>
		<c:forEach items="${produto}" var="produto1">
			<tr>
			<tr>
				<td>${produto.descricaoProduto}</td>
				<td>${produto.preco}</td>
				<td>${produto.quantidade}</td>
				<td>${produto.criadoPor}</td>
				<td>${produto.modificadoPor}</td>
				<th><a href="mostraProduto?id=${produto.idProduto}">Editar<a></th>
				<th>Apagar</th>
				<th><a href="adicionarImagem?id=${produto.idProduto}">Adicionar Imagem<a></th>
			</tr>

			</tr>
		</c:forEach>
	</table>
</body>
</html>