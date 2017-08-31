<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title" required="true" %>
<%@ attribute name="scripts" fragment="true" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title }</title>

<link rel="stylesheet" type="text/css"
href="<c:url value="/resources/css/bootstrap.min.css"/>"/>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" 
        	href="<c:url value="/"></c:url>">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" 
        	href="<c:url value="/prato/cadastrar"></c:url>">Cadastrar</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" 
        	href="<c:url value="/prato/listar"></c:url>">Listar</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
	<div class="container">
		<jsp:doBody/>
	</div>
	<p>Todos os direitos reservados.</p>


<script type="text/javascript"
src="<c:url value="/resources/js/jquery-3.2.1.min.js"/>">
</script>
<script type="text/javascript"
src="<c:url value="/resources/js/bootstrap.min.js"/>">
</script>

<jsp:invoke fragment="scripts"></jsp:invoke>

</body>
</html>