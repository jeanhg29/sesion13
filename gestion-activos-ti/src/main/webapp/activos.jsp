<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITAM: Activos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Activos</h1>
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Tipo</th>
			<th>Marca</th>
			<th>Modelo</th>
			<th>N° Serie</th>
			<th>Estado</th>
			<th>Código Usuario</th>
			<th>Acciones</th>
		</tr>
		<c:forEach items="${listaActivos}" var="a">
		<tr>
			<td>${a.idActivo}</td>
			<td>${a.nombre}</td>
			<td>${a.tipo}</td>
			<td>${a.marca}</td>
			<td>${a.modelo}</td>
			<td>${a.numSerie}</td>
			<td>${a.estado.nombre}</td>
			<td>${a.usuario == null ? 'NO ASIGNADO' : a.usuario.codigo}</td>
			<td>
			    <div class="contenedor-botones">
                    <form action="SvActivos" method="POST">
                        <input type="hidden" name="accion" value="vista-editar">
                        <input type="hidden" name="codigo" value="${a.idActivo}">
                        <button type="submit" class="btn btn-warning">Editar</button>
                    </form>
                    <form action="SvActivos" method="POST">
                        <input type="hidden" name="accion" value="eliminar">
                        <input type="hidden" name="id" value="${a.idActivo}">
                        <button type="submit" class="btn btn-danger" ${a.estado.equals("Retirado") ? '' : 'disabled'}>Dar de baja</button>
                    </form>
                </div>
			</td>
		</tr>
		</c:forEach>
	</table>
	<h1>Crea Activo</h1>
	<form action="SvActivos" method="POST">
		<input type="hidden" name="accion" value="crear">
		<p>
			<label for="nombre" class="form-label">Nombre:</label>
			<input type="text" name="nombre" id="nombre" class="form-control">
		</p>
		<p>
			<label for="tipo" class="form-label">Tipo:</label>
			<input type="text" name="tipo" id="tipo" class="form-control">
		</p>
		<p>
			<label for="marca" class="form-label">Marca:</label>
			<input type="text" name="marca" id="marca" class="form-control">
		</p>
		<p>
			<label for="modelo" class="form-label">Modelo:</label>
			<input type="text" name="modelo" id="modelo" class="form-control">
		</p>
		<p>
			<label for="numSerie" class="form-label">N° Serie:</label>
			<input type="text" name="numSerie" id="numSerie" class="form-control">
		</p>
		<p>
			<label for="estado" class="form-label">Estado</label>
			<input type="text" name="estado" id="estado" class="form-control">
		</p>
		<p>
			<label for="codigo" class="form-label">Código</label>
			<input type="text" name="codigo" id="codigo" class="form-control">
		</p>
		<button type="submit" class="btn btn-primary my-2">Crear Activo</button>
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