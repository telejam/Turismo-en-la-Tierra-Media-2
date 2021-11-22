package tierramedia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ItinerarioDAO {
	public int insert(int id_oferta, String tipo_oferta, int id_usuario,String nombre, double costo_total,double duracion_total) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO itinerario  (id_oferta, tipo_oferta,  id_usuario, nombre, costo_total, duracion_total) VALUES (?, ?, ?, ?, ?, ? )";
		PreparedStatement itinerarios = connection.prepareStatement(sql);
		itinerarios.setInt(1, id_oferta);
		itinerarios.setString(2, tipo_oferta);
		itinerarios.setInt(3, id_usuario);
		itinerarios.setString(4, nombre);
		itinerarios.setDouble(5, costo_total);
		itinerarios.setDouble(6, duracion_total);

		int rows = itinerarios.executeUpdate();
		
		return rows;
	}
}