package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tierramedia.Atraccion;

public class AtraccionDAO {
	public List<Atraccion> findAll() throws SQLException {
		String sql = "SELECT * FROM atracciones";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		while (resultados.next()) {
			atracciones.add(new Atraccion(
					resultados.getInt("id"),
					resultados.getString("nombre"),
					resultados.getDouble("costo"),
					resultados.getDouble("duracion"),
					resultados.getInt("cupo")
			));
		}
		return atracciones;
		
	}
}
