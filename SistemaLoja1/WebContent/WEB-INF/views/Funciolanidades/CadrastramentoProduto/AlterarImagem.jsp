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
	<h3>Imagem do Produto</h3>    
	<div id="idFormulario">
		<form:form action="imagemAlterar" method="post"
			enctype="multipart/form-data">
			
			<input type="hidden" name="id" value="${imagem.idImagem}">
			<input type="hidden" name="idProduto" value="${imagem.produto.idProduto}">
			
			<table>
				<tr>
					<td>Imagem Principal do Produto</td>
					<td><input type="file" name="file" id="file" required="" /></td>
				</tr>
				<tr>
					<td>Segundo Imagem do Produto</td>
					<td><input type="file" name="file1" id="file" required="" /></td>
				</tr>
				<tr>
					<td>Terceira Imagem do Produto</td>
					<td><input type="file" name="file2" id="file" required="" /></td>
				</tr>
				<tr>
					<td>Quarta Imagem do Produto</td>
					<td><input type="file" name="file3" id="file" required="" /></td>
				</tr>
			</table>
			<div>
				<input type="submit" value="Alterar">
			</div>
		</form:form>
</body>
</html>