<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="utilidades.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Polideportivo</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css">
</head>
<body>
	<div>

		<form method="get" action="InsertarUsuarios">
			<table style="width: 20%">
				<tr>
					<td>Nombre</td>
					<td><input type="text" name="nombre" /></td>
					<td>Contraseña</td>
					<td><input type="text" name="contrasena" /></td>
					<td>Rol</td>
					<td>
						<select name="roles" id="rol">
					   	    <option value="1">Administrador</option>
				 			<option value="2">Cliente</option>
						</select>
					</td>
					<td><input type="submit" value="Insertar Usuario"/></td>



				</tr>
			</table>
	
		</form>

	</div>

	<table class="table table-striped">
		<thead>
			<tr>
			
				<th scope="col">ID</th>
				<th scope="col">Nombre</th>
				<th scope="col">Contraseña</th>
				<th scope="col">Rol</th>
				<th scope="col">Eliminar</th>
				<th scope="col">Modificar</th>

			</tr>
		</thead>


		<c:forEach items="${VisualizarUsuarios}" var="usuario">
			<tr>
				<td>
					${usuario.id}
				</td>
				
				<td>
					${usuario.nombre}
				</td>
				<td>
					${usuario.contrasena}
				</td>
				<td>
					<c:forEach items ="${roles}" var="rol">
						<c:if test="${rol.id == usuario.idRol}">
						${rol.nombre}
						</c:if>
					</c:forEach>
				</td>
				
				<td>
					<a href="/CRUDconMVC/EliminarUsuarios?id=${usuario.id}">Eliminar</a>
				</td>
				<!-- Metodo para modificar los usuarios -->
				<td>	
				
					<form method="get" action="ModificarUsuarios">
								<label for="atributos">Que desea modificar: </label>
								<select name="valores" id="valores">
							    	<option value="nombre">Nombre</option>
							  		<option value="contrasena">Contraseña</option>
								</select>
						<input type="text" name="textomodificar" class = "ml-3" />
						<input type="hidden" name="idU" value="${usuario.id}">
						<input type="submit" value="Modificar Usuario"/>
					
					</form>
				</td>
				
			</tr>
		</c:forEach>
		
	</table>

</body>
</html>