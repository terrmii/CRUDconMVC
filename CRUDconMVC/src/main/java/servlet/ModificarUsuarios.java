package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestores.GestorBBDD;

/**
 * Servlet implementation class ModificarUsuarios
 */
@WebServlet("/ModificarUsuarios")
public class ModificarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String modificar = (String) request.getParameter("valores");
//		String id = (String) request.getParameter("id");
//		String nuevoValor = (String) request.getParameter("textomodificar");
//		
//		GestorBBDD bbdd = new GestorBBDD();
//		bbdd.modificarCliente(id, modificar, nuevoValor);
//		
		
		String id = request.getParameter("idU");
        String nombre = request.getParameter("textomodificar");
        GestorBBDD bbdd = new GestorBBDD();
            try {
				bbdd.modificarCliente(id, nombre);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
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
