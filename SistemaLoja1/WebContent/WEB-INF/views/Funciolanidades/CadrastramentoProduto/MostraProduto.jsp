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
	<h3>Cadastro de Produto</h3>
	<div id="idFormulario">
		<form:form action="alterarProduto" method="post" modelAttribute="obj">

			<div>

				<form:hidden path="idProduto" value="${produto.idProduto}" />

			</div>

			<form:label path="Categoria">Categoria</form:label>
			<div>
				<form:select path="categoria.idCategoria">
					<c:forEach items="${categoria}" var="categoria1">
						<form:option value="${categoria1.idCategoria }"
							label="${categoria1.descricaoCategoria}" />
					</c:forEach>
				</form:select>

			</div>

			<div>
				<label for="descricaoProduto">Descricao do Produto</label>
				<form:input path="descricaoProduto"
					value="${produto.descricaoProduto}" />
				<form:errors path="descricaoProduto" />
			</div>
			<div>
				<label for="preco">Preço </label>
				<form:input path="preco" value="${produto.preco}" />
				<form:errors path="preco" />
			</div>

			<div>
				<label for="criadoPor">Criador</label>
				<form:hidden path="criadoPor" value="${produto.criadoPor}" />
				<form:errors path="criadoPor" />
			</div>
			<div>
				<input type="submit" value="Alterar">
			</div>
		</form:form>
</body>
</html>