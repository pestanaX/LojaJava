<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostra Endereço </title>
</head>
<body>
        <h3>Endereço do Fornecidor</h3>
        
        <p>Estado : ${dadosEndereco.estado}</p>
        <p>Muncipio : ${dadosEndereco.municipio}</p>
        <p>Bairro : ${dadosEndereco.bairro}</p>
        <p>Rua : ${dadosEndereco.rua}</p>
        <p>Numero Da Casa:${dadosEndereco.numeroDaCasa}</p>
        <p><a href="mostraEnderecoFornecidor?id=${dadosEndereco.id}">Alterar Endereço<a></p>
				
</body>
</html>