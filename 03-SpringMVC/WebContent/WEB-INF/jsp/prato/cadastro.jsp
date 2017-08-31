<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:template title="Cadastro de Prato">
	<jsp:attribute name="scripts">
		<p>Aqui vai os scripts...</p>
	</jsp:attribute>
	<jsp:body>
		<br>
		<h1>Cadastro de Prato</h1>
		<form action="cadastrar" method="post">
			<div class="form-group">
				<label for="id-nome">Nome</label>
				<input type="text" name="nome" id="id-nome"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="id-preco">Preço</label>
				<input type="text" name="preco" id="id-preco"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="id-peso">Peso</label>
				<input type="text" name="peso" id="id-peso"
					class="form-control">
			</div>
			<input type="submit" value="Cadastrar"
					class="btn btn-primary">
		</form>
	</jsp:body>
</tag:template>


