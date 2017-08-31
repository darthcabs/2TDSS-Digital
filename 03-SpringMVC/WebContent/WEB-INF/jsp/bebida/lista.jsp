<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:template title="Lista de Bebidas">
	<jsp:body>
		<h2>Lista de Bebidas</h2>
		<br>
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Preço</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista }" var="b">
					<tr>
						<td>${b.nome }</td>
						<td>${b.preco }</td>
					</tr>
				</c:forEach>				
			</tbody>
		</table>
	</jsp:body>
</tag:template>