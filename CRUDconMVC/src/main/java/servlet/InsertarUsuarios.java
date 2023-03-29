package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestores.GestorBBDD;
import utilidades.Usuario;

/**
 * Servlet implementation class InsertarUsuarios
 */
@WebServlet("/InsertarUsuarios")
public class InsertarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertarUsuarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recibir los datos de la pagina principal
		String nombre = (String) request.getParameter("nombre");
		String contrasena = (String) request.getParameter("contrasena");
		String idRol = (String) request.getParameter("rol"); 
		
		// crear un usuario
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setContrasena(contrasena);
		usuario.setIdRol(idRol);

		// insertar el usuario en la base de datos
		GestorBBDD bbdd = new GestorBBDD();
		bbdd.insertarUsuarios(usuario);

		response.sendRedirect(request.getContextPath() + "/VerUsuarios");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
