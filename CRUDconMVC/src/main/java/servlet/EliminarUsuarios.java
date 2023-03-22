package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestores.GestorBBDD;

/**
 * Servlet implementation class EliminarUsuarios
 */
@WebServlet("/EliminarUsuarios")
public class EliminarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//guardar el ID
		String id = (String) request.getParameter("id");
		
		//eliminar el usuario de la base de datos
		GestorBBDD bbdd = new GestorBBDD();
		bbdd.eliminarUsuarios(id);
		
		//volver a la pagina principal
		response.sendRedirect(request.getContextPath() + "/VerUsuarios");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
