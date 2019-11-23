<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	
	pageEncoding="ISO-8859-1" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<html>
<head>
<title>Reserva</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1" >

</head>
<body>
	<center>
            <h1>Reserva</h1>
            <br/><br/>
		<form  action="doReserva" method="post">
			<select name="idvuelo">
				<option value="0">Todos</option>
				<c:forEach var="t" items="${requestScope.temas}">
					<option value="${t.idTema}">${t.tema}</option>				
				</c:forEach>				
			</select>
			
			<div class="form-group">
				<label>Usuario:</label>
				<f:input path="usuario" class="form-control" style="width:30%" placeholder="Usuario" autocomplete="name"/>
			</div>
		
			<br/><br/>
			<input type="submit" value="Ver libros"/>
			
		</form>
		<br/><br/>
		<c:set var="libros" value="${requestScope.libros}"/>   
		<c:choose>
			<c:when test="${!empty libros}">
		
				<table border="1">
				    <tr><th>Titulo</th><th>Autor</th><th>Precio</th></tr>		    	
				    	<c:forEach var="lib" items="${libros}">
				    		<tr>
				    			<td>${lib.titulo}</td>
								<td>${lib.autor}</td>
								<td>${lib.precio}</td>
								
							</tr>		    	
				    	</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h2>No hay libros</h2>
			</c:otherwise>
		</c:choose>
		<br/><br/>
		<a href="toMenu">Volver</a>
	
	</center>

</body>
</html>