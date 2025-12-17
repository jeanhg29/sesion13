<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITAM: Usuarios</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Usuarios</h1>
	<br>
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Codigo</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Área</th>
			<th>Contraseña</th>
			<th>Activo</th>
			<th>Acciones</th>
		</tr>

		<c:forEach items="${listaUsuarios}" var="u">
		<tr>
			<td>${u.idUsuario}</td>
			<td>${u.codigo}</td>
			<td>${u.nombre}</td>
			<td>${u.apellido}</td>
			<td>${u.area}</td>
			<td>${u.contrasena}</td>
			<td>${u.activo }</td>

			<td>
				<div class="contenedor-botones">
					<form action="SvUsuarios" method="POST">
						<input type="hidden" name="accion" value="vista-editar">
						<input type="hidden" name="codigo" value="${u.codigo}">
						<button type="submit" class="btn btn-warning">Editar</button>
					</form>
					<form action="SvUsuarios" method="POST">
						<input type="hidden" name="accion" value="eliminar">
						<input type="hidden" name="id" value="${u.idUsuario}">
						<button type="submit" class="btn btn-danger">Eliminar</button>
					</form>
				</div>
			</td>

		</tr>
		</c:forEach>

	</table>
	<br>
	<h1>Crear usuario</h1>
	<br>
	<form action="SvUsuarios" method="POST">
		<input type="hidden" name="accion" value="crear">
		<p>
			<label for="codigo" class="form-label">Código:</label>
			<input type="text" name="codigo" id="codigo" class="form-control">
		</p>
		<p>
			<label for="nombre" class="form-label">Nombre:</label>
			<input type="text" name="nombre" id="nombre" class="form-control">
		</p>
		<p>
			<label for="apellido" class="form-label">Apellido:</label>
			<input type="text" name="apellido" id="apellido" class="form-control">
		</p>
		<p>
			<label for="area" class="form-label">Área:</label>
			<input type="text" name="area" id="area" class="form-control">
		</p>
		<p>
			<label for="contrasena" class="form-label">Contraseña:</label>
			<input type="text" name="contrasena" id="contrasena" class="form-control">
		</p>
		<button type="submit" class="btn btn-primary my-2">Crear Usuario</button>
	</form>
	<br>
	<a href="dashboard.jsp" class="btn btn-primary my-2">Regresar a Dashboard</a>
</div>
</body>
<style>
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
	}
	.contenedor-botones {
		display: flex; /* Pone los elementos uno al lado del otro */
		gap: 10px;     /* Añade 10px de espacio entre los elementos del flex */
	}
</style>
</html>