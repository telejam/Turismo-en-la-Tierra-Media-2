package tierramedia;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import dao.FactoryDAO;

public class Itinerario {
	private ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
	private Usuario usuario;
	private double tiempoDeVisita = 0;
	private double costoDeVisita = 0;

	public Itinerario(Usuario usuario) throws SQLException {
		this.usuario = usuario;
		atracciones = FactoryDAO.getItinerarioDAO().findByIdUsuario(usuario.getId());
	}




	public boolean estaCargada(Ofertable ofertable) {
		boolean esta = false;
		for (Atraccion atraccion : ofertable.obtenerContenido()) {
			if (atracciones.contains(atraccion)) {
				esta = true;
			}
		}
		return esta;
	}

 
	@Override
	public String toString() {
		DecimalFormat f = new DecimalFormat("#.##");
		String listaAtracciones = "";
		String mensaje = "Este es su Itinerario:  " + usuario.getNombre() + "\n\n";
		for (Atraccion atraccion : atracciones) {
			listaAtracciones += " " + atraccion.getNombre() + " " + f.format(atraccion.obtenerDuracion()) + " horas\n";
		}
		if (listaAtracciones.equals("")) {
			mensaje += "Usted no ha elegido ninguna oferta. ";
		} else {
			mensaje += listaAtracciones + "\n\n Su Costo total: " + f.format(this.costoDeVisita ) + " monedas de oro "
					+ "\n\n Su Tiempo total: " + f.format(this.tiempoDeVisita ) + " horas.";
		}
		return mensaje + "\n\nQue disfrute su visita a la Tierra Media."
				+ "\n\n-----------------------------------------\n";
	}

	

	

	public void agregar(Ofertable ofertable) throws SQLException {
		String tipo;

		if (ofertable.obtenerContenido().size()>1) {
			tipo = "P";
		}  else { 
			tipo = "A";
		}
		FactoryDAO.getItinerarioDAO().insert(ofertable.getId(), tipo, usuario.getId());

		for (Atraccion atraccion : ofertable.obtenerContenido()) {
			atracciones.add(atraccion);
	    }

	    this.tiempoDeVisita += ofertable.obtenerDuracion();
	    this.costoDeVisita +=ofertable.obtenerCosto();

		
	}
   
}

