<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="utilidades.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Polideportivo</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div>

		<form method="get" action="InsertarUsuarios">
			<table style="width: 20%">
				<tr>
					<td>Nombre</td>
					<td><input type="text" name="nombre" /></td>
				</tr>
			</table>
			<input type="submit" value="Insertar Usuario" />

		</form>

		<%
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("VisualizarUsuarios");
		%>

	</div>

	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Nombre</th>
				<th scope="col">Acciones</th>


			</tr>
		</thead>

		<%
		for (Usuario usuario : usuarios) {
		%>

		<tr>
			<td>
				<%
				out.println(usuario.getId());
				%>
			</td>
			<td>
				<%
				out.println(usuario.getNombre());
				%>
			</td>
			<td><a
				href="/CRUDconMVC/EliminarUsuarios?id=<%out.println(usuario.getId());%>">Eliminar</a>

				<a class="ml-2"
				href="/CRUDconMVC/ModificarUsuarios?id=<%out.println(usuario.getId());%>">Modificar</a>
			</td>
		</tr>

		<%
		}
		%>
	</table>



</body>
</html>