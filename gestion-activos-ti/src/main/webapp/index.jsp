<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITAM</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Bienvenido a la plataforma ITAM</h1>
	<h2>Iniciar sesión</h2>
	<form action="SvLogin" method="POST" class="form">
		<p>
			<label for="usuario" class="form-label">Código:</label>
			<input type="text" name="codigo" id="usuario" class="form-control">
		</p>
		<p>
			<label for="contrasena" class="form-label">Contraseña:</label>
			<input type="password" name="contrasena" id="contrasena" class="form-control">
		</p>
		<button class="btn btn-primary" type="submit">Iniciar Sesión</button>
	</form>

	<p style="color:red;">${mensajeError}</p>
</div>
</body>
</html>