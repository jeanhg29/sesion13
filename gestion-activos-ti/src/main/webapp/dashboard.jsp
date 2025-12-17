<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
    <div class="container">
	<h1>Dashboard de ITAM</h1>
	<h2>Hola, ${usuario.nombre} ${usuario.apellido} ${usuario.area}</h2>
	<p>Este es tu panel de control</p>
	<a class="btn btn-primary my-2" href="SvUsuarios">Gestionar Usuarios</a>
	<a class="btn btn-primary my-2" href="SvActivos">Gestionar Activos</a>
	<a href="SvLogout">Cerrar Sesión</a>
	</div>
</body>
</html>