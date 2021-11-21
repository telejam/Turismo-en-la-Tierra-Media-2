package tierramedia;

import java.sql.*;
import java.util.*;

public class UsuarioDAO {

	public int insert(Usuario usuario) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO USUARIOS (NOMBRE, PRESUPUESTO, TIEMPO) VALUES (?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, usuario.getNombre());
		statement.setDouble(2, usuario.getPresupuesto());
		statement.setDouble(3, usuario.getTiempo());

		int rows = statement.executeUpdate();

		return rows;
		
	}
	
public int update(Usuario usuario) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "UPDATE USUARIOS SET NOMBRE=?, PRESUPUESTO = ?, TIEMPO= ? WHERE ID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);		
		statement.setString(1, usuario.getNombre());
		statement.setDouble(2, usuario.getPresupuesto());
		statement.setDouble(3, usuario.getTiempo());
		statement.setInt(4, usuario.getId());

		int rows = statement.executeUpdate();

		return rows;		
	}
	
	public int delete(Usuario usuario) throws SQLException {
		
		Connection connection = ConnectionProvider.getConnection();
		String sql = "DELETE FROM USUARIOS WHERE ID = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, usuario.getId());
		
		int rows = statement.executeUpdate();
		return rows;		
	}
		
	public List<Usuario> findAll() throws SQLException {

		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM USUARIOS";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		List<Usuario> todos = new LinkedList<Usuario>();

		while (result.next()) {
			todos.add(toUsuario(result));
		}
		return todos;
	}	
	
	private Usuario toUsuario(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String nombre = result.getString("nombre");
		double presupuesto = result.getDouble("presupuesto");
		double tiempoDisponible = result.getDouble("tiempoDisponible");

		return new Usuario(id,nombre,presupuesto,tiempoDisponible);
	}
}