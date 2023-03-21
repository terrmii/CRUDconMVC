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

	public ArrayList<Usuario> visualizarCliente(){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			try {
				con.conectar();
				ps = con.getCon().prepareStatement("SELECT * from usuarios");
				ResultSet res = ps.executeQuery();
				while (res.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(res.getInt("Id"));
					usuario.setNombre(res.getString("nombre"));

					usuarios.add(usuario);
				}
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
	
//	public ArrayList<Usuario> verUsuarios(){
//		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
//        try {
//        	con.conectar();
//            PreparedStatement verU = con.getCon().prepareStatement("SELECT * FROM usuarios");
//            verU.execute();
//            
//            ResultSet resultado = verU.executeQuery();
//            
//            while(resultado.next()) {
//                Usuario usuario = new Usuario();
//                
//                usuario.setId(resultado.getInt("Id"));
//                usuario.setNombre(resultado.getString("nombre"));
//                
//                usuarios.add(usuario);
//            }
//            con.cerrar();
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return usuarios;
//	}

	

}
