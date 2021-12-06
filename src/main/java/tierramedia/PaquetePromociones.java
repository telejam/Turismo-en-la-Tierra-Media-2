package tierramedia; 

import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.List;

import dao.FactoryDAO;

public class PaquetePromociones {

	private List<Promocion> promociones = new ArrayList<Promocion>();
	private List<PromoParcial> parciales;
		
	public PaquetePromociones(List<Atraccion> lista) throws SQLException {
		cargarPromociones(lista);
	}

	private void cargarPromociones(List<Atraccion> lista) throws SQLException { 

		parciales = FactoryDAO.getPromocionDAO().findAll();
		List<Integer> idIncluidas;
		List<Integer> idGratuitas;
		List<Atraccion> pasarAtracciones;
		List<Atraccion> listaAPagar;
		List<Atraccion> listaAtraccionesGratuitas;

		for (PromoParcial promo : parciales) {

			idIncluidas = FactoryDAO.getPromocionDAO().findIdIncluidas(promo.getId());
			
			pasarAtracciones = new ArrayList<Atraccion>();
			for (int id : idIncluidas) {
				for (Atraccion atraccion : lista) {
					if (atraccion.getId() == id) {
						pasarAtracciones.add(atraccion);
					}
				}
			}
			
			if (promo.getTipo().equals("%")) {

				promociones.add(new PromocionPorcentual(
						promo.getId(),
						promo.getNombre(),
						pasarAtracciones, 
						promo.getValor()
				));

			} else if (promo.getTipo().equals("$")) {

				promociones.add(new PromocionAbsoluta(
					promo.getId(),
					promo.getNombre(),
					pasarAtracciones, 
					promo.getValor()
				));

			} else { 

				listaAPagar = new ArrayList<Atraccion>();
				listaAPagar.addAll(pasarAtracciones);
				
				idGratuitas = FactoryDAO.getPromocionDAO().findIdGratuitas(promo.getId());
				
				listaAtraccionesGratuitas = new ArrayList<Atraccion>();
				for (int id : idGratuitas) {
					for (Atraccion atraccion : lista) {
						if (atraccion.getId() == id) {
							listaAtraccionesGratuitas.add(atraccion);
						}
					}
				}

				
				pasarAtracciones.addAll(listaAtraccionesGratuitas);

				
				promociones.add(new PromocionAxB(
						promo.getId(),
						promo.getNombre(),
						pasarAtracciones, 
						listaAPagar
				));

			}

		}


	}


	public List<Promocion> getPromociones() {
		return promociones;
	}

}
