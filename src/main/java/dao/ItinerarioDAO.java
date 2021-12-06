package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import tierramedia.Atraccion;


public class ItinerarioDAO {
	public int insert(int id_oferta, String tipo_oferta, int id_usuario) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "INSERT INTO itinerarios  (id_oferta, tipo_oferta,  id_usuario) VALUES (?, ?, ?)";
		PreparedStatement itinerario = connection.prepareStatement(sql);
		itinerario.setInt(1, id_oferta);
		itinerario.setString(2, tipo_oferta);
		itinerario.setInt(3, id_usuario);

		int rows = itinerario.executeUpdate();
		
		return rows;
	}

	public ArrayList<Atraccion> findByIdUsuario(int id_usuario) throws SQLException {
		Connection connection = ConnectionProvider.getConnection();
		String sql = "SELECT * FROM itinerarios  WHERE id_usuario = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id_usuario);

		ResultSet result = statement.executeQuery();
		
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();

		while (result.next()) {
			atracciones.add(toAtraccion(result));
		}

		return atracciones;
	}

	private Atraccion toAtraccion(ResultSet result) throws SQLException {

	    int id = result.getInt("id");
		String nombre = result.getString("nombre");
		double costo = result.getDouble("costo");
		double duracion = result.getDouble("duracion");
		int cupo = result.getInt("cupo");

//		String tipo;
//
//		if (ofertable.obtenerContenido().size()>1) {
//			tipo = "P";
//		}  else { 
//			tipo = "A";
//		}
//		FactoryDAO.getItinerarioDAO().insert(ofertable.getId(), tipo, usuario.getId());
//
//		for (Atraccion atraccion : ofertable.obtenerContenido()) {
//			atracciones.add(atraccion);
//	    }
//
//	    this.tiempoDeVisita += ofertable.obtenerDuracion();
//	    this.costoDeVisita +=ofertable.obtenerCosto();


		return new Atraccion(id, nombre, costo, duracion, cupo);
	}
}