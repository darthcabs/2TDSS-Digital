<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:template title="Cadastro de Fabricante">
	<jsp:attribute name="scripts">
		<p>Aqui vai os scripts....</p>
	</jsp:attribute>
	<jsp:body>
		<h1>Cadastro de Fabricante</h1>
		<c:url value="/fabricante/cadastrar" var="action"/>
		<form:form action="${action }" method="post" commandName="fabricante">
			<div class="form-group">
				<form:label path="nome">Nome</form:label>
				<form:input path="nome" cssClass="form-control"/>
				<form:errors path="nome"/>	
			</div>
			<input type="submit" value="Cadastrar" class="btn btn-primary">
		</form:form>
	</jsp:body>
</tag:template>