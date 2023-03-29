package gestores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import utilidades.Conector;
import utilidades.Usuario;
import utilidades.Rol;

public class GestorBBDD extends Conector{

	Conector con = new Conector();
	PreparedStatement ps;

	public ArrayList<Usuario> visualizarUsuarios(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			try {
				con.conectar();
				Rol rol = new Rol();
				ps = con.getCon().prepareStatement("SELECT * from usuarios");
				ResultSet res = ps.executeQuery();
				while (res.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(res.getInt(1));
					usuario.setNombre(res.getString(2));
					usuario.setContrasena(res.getString(3));
					usuario.setIdRol(res.getInt(4));
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
			ps = con.getCon().prepareStatement("INSERT INTO usuarios (nombre, contrasena) VALUES (?, ?)");
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getContrasena());
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

	public void modificarUsuario(String id, String nombre, String modificar) throws ClassNotFoundException {
        try {
            con.conectar();
            ps = con.getCon().prepareStatement("UPDATE usuarios SET "+modificar+" = ? WHERE id = ?");
            ps.setString(1, nombre);
            ps.setString(2, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
