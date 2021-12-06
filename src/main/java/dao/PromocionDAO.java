package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tierramedia.PromoParcial;

public class PromocionDAO {
	
	public List<PromoParcial> findAll() throws SQLException {
		String sql = "SELECT * FROM promociones";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		List<PromoParcial> promos = new ArrayList<PromoParcial>();
		while (resultados.next()) {
			promos.add(new PromoParcial(
					resultados.getInt("id"),
					resultados.getString("nombre"),
					resultados.getString("tipo"),
					resultados.getDouble("valor")
			));
		}
		return promos;
		
	}
	
	public List<Integer> findIdIncluidas(int id) throws SQLException {
		String sql = "SELECT * FROM atracciones_incluidas WHERE id_promocion = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id); 
		ResultSet resultados = statement.executeQuery();

		List<Integer> idIncluidas = new ArrayList<Integer>();
		
		while (resultados.next()) {
			idIncluidas.add(resultados.getInt("id_atraccion"));
		}
		return idIncluidas;
		
	}
	
	public List<Integer> findIdGratuitas(int id) throws SQLException {
		String sql = "SELECT * FROM atracciones_gratuitas WHERE id_promocion = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id); 
		ResultSet resultados = statement.executeQuery();
		
		List<Integer> idGratuitas = new ArrayList<Integer>();
		
		while (resultados.next()) {
			idGratuitas.add(resultados.getInt("id_atraccion"));
		}
		return idGratuitas;
		
	}
	
	
}
