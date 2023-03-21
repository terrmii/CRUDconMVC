<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="java.util.ArrayList" %>
<%@ page import ="utilidades.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Polideportivo</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div>
	
	<form action="usuarios" method="post">
				 <table style="width: 20%">
                           <tr>
                                    <td>Nombre</td>
                                    <td><input type="text" name="nombre" /></td>
                           </tr>
                 </table>
                 <input type="submit" value="Insertar Usuario" />
               
	</form>
	
	  			<%	
                 ArrayList<Usuario> usuarios = (ArrayList<Usuario>)request.getAttribute("VisualizarUsuarios");
                 %>
                 
                 	</div>
	
		                 <table class="table table-striped">
	
	 			<%
  		         for(Usuario usuario : usuarios){
                 %>

                 <tr>
                 <td><%out.println(usuario.getId()); %></td>
                 <td><%out.println(usuario.getNombre()); %></td>
                 </tr>
                 </table>
                 <%} %>
                 
                 
                 
                 <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
</body>
</html>