<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<tag:template title="Cadastro de Petisco">
	
	<h2>Cadastro de Petisco</h2>

	<c:if test="${not empty msg }">
		<div class="alert alert-success">
			${msg }
		</div>
	</c:if>
	
	<c:url value="/petisco/cadastrar" var="action"/>
	<form:form action="${action}" method="post" commandName="petisco">
		<div class="form-group">
			<form:label path="nome">Nome</form:label>
			<form:input path="nome" cssClass="form-control"/>
			<form:errors path="nome" cssClass="text-danger"/>
		</div>
		<div class="form-group">
			<form:label path="valor">Valor</form:label>
			<form:input path="valor" cssClass="form-control"/>
			<form:errors path="valor" cssClass="text-danger"/>
		</div>
		<input type="submit" value="Cadastrar" class="btn btn-primary">
	</form:form>

</tag:template>