<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<tag:template title="Lista de Cerveja">
	<h1>Lista de Cervejas</h1>
	<c:if test="${not empty msg }">
		<div class="alert alert-success">${msg}</div>
	</c:if>
	<table class="table">
		<tr>
			<th>Nome</th>
			<th>Preço</th>
			<th>Tipo</th>
			<th>Validade</th>
			<th></th>
		</tr>
		<c:forEach items="${lista }" var="c">
			<tr>
				<td>${c.nome }</td>
				<td>${c.preco }</td>
				<td>${c.tipo }</td>
				<td>
					<fmt:formatDate value="${c.validade.time}" pattern="dd/MM/yyyy"/>
				</td>
				<td>
					<c:url var="link" value="/cerveja/editar/${c.codigo }"/>
					<a href="${link}" class="btn btn-primary btn-sm">Editar</a>
					<button onclick="idExcluir.value = ${c.codigo}" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#exampleModal">
  						Deletar
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Deseja realmente excluir?
      </div>
      <div class="modal-footer">
      	<c:url value="/cerveja/excluir" var="action"/>
      	<form action="${action }" method="post">
      		<input type="hidden" name="codigo" id="idExcluir">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Não</button>
	        <button type="submit" class="btn btn-danger">Sim</button>
        </form>
      </div>
    </div>
  </div>
</div>
	
</tag:template>