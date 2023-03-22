package gestores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import utilidades.Conector;
import utilidades.Usuario;

public class GestorBBDD extends Conector{

	Conector con = new Conector();
	PreparedStatement ps;

	public ArrayList<Usuario> visualizarUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			try {
				con.conectar();
				ps = con.getCon().prepareStatement("SELECT * from usuarios");
				ResultSet res = ps.executeQuery();
				while (res.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(res.getInt(1));
					usuario.setNombre(res.getString(2));

					usuarios.add(usuario);
				}
				con.cerrar();
				return usuarios;
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return usuarios;
	}
	
	public void insertarUsuarios(Usuario usuario){
		try {
			con.conectar();
			ps = con.getCon().prepareStatement(
					"INSERT INTO usuarios (nombre) VALUES (?)");
			ps.setString(1, usuario.getNombre());
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void eliminarUsuarios(String id){
		try {
			con.conectar();
			ps = con.getCon().prepareStatement(
					"DELETE FROM usuarios WHERE id = ?");
			ps.setString(1, id);
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
