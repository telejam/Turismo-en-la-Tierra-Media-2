package tierramedia;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import dao.ItinerarioDAO;

public class Itinerario {
	private ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();
	private Usuario usuario;
	private double tiempoDeVisita = 0;
	private double costoDeVisita = 0;

	public Itinerario(Usuario usuario) {
		this.usuario = usuario;
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
				+ "\n\n-------------------------------------------------------------------\n";
	}

	

	

	public void agregar(Ofertable ofertable) throws SQLException {
		ItinerarioDAO dao = new ItinerarioDAO(); 
	  
		String tipo;
		if (ofertable.obtenerContenido().size()>1) {
			tipo = "P";
		}  else { 
			tipo = "A";
		}
		dao.insert(ofertable.getId(), tipo,  usuario.getId(), usuario.getNombre(), ofertable.obtenerCosto(), ofertable.obtenerDuracion());

		 for (Atraccion atraccion : ofertable.obtenerContenido()) {
		      atracciones.add(atraccion);
	    }

	    this.tiempoDeVisita += ofertable.obtenerDuracion();
	    this.costoDeVisita +=ofertable.obtenerCosto();

		
	}
   
}

