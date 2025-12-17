<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITAM: Editar Usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Editar Usuario: ${usuario.codigo}</h1>
	<form action="SvUsuarios" method="POST">
		<input type="hidden" name="accion" value="editar">
		<p>
			<input type="hidden" name="id" id="id" value="${requestScope.usuario.idUsuario}">
		</p>
		<p>
			<label class="form-label" for="nombre">Nombre:</label>
			<input type="text" name="nombre" id="nombre" value="${requestScope.usuario.nombre}" class="form-control">
		</p>
		<p>
			<label class="form-label" for="apellido">Apellido:</label>
			<input type="text" name="apellido" id="apellido" value="${requestScope.usuario.apellido}" class="form-control">
		</p>
		<p>
			<label class="form-label" for="area">Área:</label>
			<input type="text" name="area" id="area" value="${requestScope.usuario.area}" class="form-control">
		</p>
		<p>
			<label class="form-label" for="contrasena">Contraseña:</label>
			<input type="text" name="contrasena" id="contrasena" value="${requestScope.usuario.contrasena}" class="form-control">
		</p>
		<button class="btn btn-primary" type="submit">Editar Usuario</button>
	</form>
</div>
</body>
</html>