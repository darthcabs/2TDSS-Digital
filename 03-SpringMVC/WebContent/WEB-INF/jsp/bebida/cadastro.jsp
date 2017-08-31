<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:template title="Cadastro de Bebida">
	<jsp:body>
		<h2>Cadastro de Bebida</h2>
		<br>
		<form method="post" action="cadastrar">
			<div class="form-group">
				<label class="control-label" for="id-nome">Nome</label>
				<input type="text" id="id-nome" name="nome" class="form-control">
			</div>
			<div class="form-group">
				<label class="control-label" for="id-preco">Preço</label>
				<input type="text" id="id-preco" name="preco" class="form-control">
			</div>
			<div class="form-group">
				<input type="submit" value="Cadastrar" class="btn btn-default">
			</div>
		</form>
	</jsp:body>
</tag:template>