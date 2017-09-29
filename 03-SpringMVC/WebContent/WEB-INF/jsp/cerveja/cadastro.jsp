<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:template title="Cadastro de Cerveja">
	<jsp:attribute name="scripts">
		<p>Aqui vai os scripts....</p>
	</jsp:attribute>
	<jsp:body>
		<h1>Cadastro de Cerveja</h1>
		<c:url value="/cerveja/cadastrar" var="action"/>
		<form:form action="${action }" method="post" commandName="cerveja">
			<div class="form-group">
				<form:label path="nome">Nome</form:label>
				<form:input path="nome" cssClass="form-control"/>
				<form:errors path="nome"/>	
			</div>
			<div class="form-group">
				<form:label path="fabricante.codigo">Fabricante</form:label>
				<form:select path="fabricante.codigo" cssClass="form-control">
					<!-- 
						<form:options itens="${fabricantes }">
						</form:options>
					 -->
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="preco">Preço</form:label>
				<form:input path="preco" cssClass="form-control"/>
				<form:errors path="preco"/>	
			</div>
			<div class="form-group">
				<form:label path="tipo">Tipo</form:label>
				<form:input path="tipo" cssClass="form-control"/>
				<form:errors path="tipo"/>		
			</div>
			<div class="form-group">
				<form:label path="validade">Validade</form:label>
				<form:input path="validade" cssClass="form-control"/>
				<form:errors path="validade"/>		
			</div>
			<input type="submit" value="Cadastrar"
				class="btn btn-primary">
		</form:form>
	</jsp:body>
</tag:template>

