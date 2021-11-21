package tierramedia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ItinerarioDAO {
	public int insert(int id_oferta, String tipo_oferta, int id_usuario,String nombre, double costo_total,double duracion_total) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO itinerario  (id_oferta, tipo_oferta,  id_usuario, nombre, costo_total, duracion_total) VALUES (?, ?, ?, ?, ?, ? )";
		PreparedStatement itinerario = connection.prepareStatement(sql);
		itinerario.setInt(1, id_oferta);
		itinerario.setString(2, tipo_oferta);
		itinerario.setInt(3, id_usuario);
		itinerario.setString(4, nombre);
		itinerario.setDouble(5, costo_total);
		itinerario.setDouble(6, duracion_total);

		int rows = itinerario.executeUpdate();
		
		return rows;
	}
}