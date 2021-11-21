package tierramedia; //////////////////////////////este es maven 

import java.beans.Statement;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;///////////////////////////////este es maven 
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PaquetePromociones {

	private List<Promocion> promociones = new ArrayList<Promocion>();

	public PaquetePromociones(List<Atraccion> lista) {
		cargarPromociones(lista);

	}

	public void cargarPromociones(List<Atraccion> lista) implements PromocionDAO {//// revisar que le llega a cargarPromociones uml 



		public List<Atraccion> findIncluidas(int id) {
			String sql = "SELECT * FROM Atracciones_incluidas WHERE id=?";
			Statement.setInt(1, id);/////////////////////////////////////////////////////////////////////////////////////// 
			Connection conn = Conexion.getConexion();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			List<Atraccion> atracciones = new ArrayList<Atraccion>();
			while (resultados.next()) {
				Atraccion atraccion=findatraccionbyid(resultados.getInt("id_atraccion"));

				atracciones.add(atraccion);
			}
			return atracciones;
			
		}
		
		
			
		public List<promociones> lista findAll() {
			try {
				String sql = "SELECT * FROM promociones";
				Connection conn = Conexion.getConexion();
				PreparedStatement statement = conn.prepareStatement(sql);
				ResultSet resultados = statement.executeQuery();
				List<Promocion> promociones = new ArrayList<Promocion>();
				while(resultados.next()) {


					if (resultados.getString("tipo").equals("%")) {



promociones.add(new PromocionPorcentual(resultados.getInt("id"),resultados.getString("nombre"),findIncluidas(resultados.getInt("id")),
					resultados.getInt("valor");

					}else if (resultados.getString("tipo").equals("$")) {

promociones.add(new PromocionAbsoluta(resultados.getInt("id"),resultados.getString("nombre"),findIncluidas(resultados.getInt("id")),
			resultados.getInt("valor"));

					} else { 

						for (String  idAtraccion : listaAtraccionesGratuitas) {
							for (Atraccion atraccion : lista) {
								if (atraccion.getId()==idAtraccion)) {
									pasarAtracciones.add(atraccion);
								}
							}
						}
 promociones.add(new PromocionAxB(resultados.getInt("id"),resultados.getString("nombre"), findIncluidas(resultados.getInt("id")),
		 pasarAtracciones,resultados.getInt("valor"));

					}

				}


			}
		} catch(Exception e) {
			throw new Exception(e);
		}
	}


	public void ordenar() {
		Collections.sort(promociones, new ComparadorOfertables());
	}

	public List<Promocion> getPromociones() {
		return promociones;
	}

}
