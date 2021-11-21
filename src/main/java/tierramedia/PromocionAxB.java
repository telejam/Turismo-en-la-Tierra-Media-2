package tierramedia;

import java.text.DecimalFormat;
import java.util.List;

public class PromocionAxB extends Promocion {
	
	private  List<Atraccion> atraccionesAPagar;
	
	public PromocionAxB(String nombre, List<Atraccion> atracciones, List<Atraccion> atraccionesAPagar) {
		super(nombre, atracciones);
		this.atraccionesAPagar = atraccionesAPagar;
	}

	@Override
	public double obtenerCosto() {
		double precio = 0;
		for (Atraccion atraccion : atraccionesAPagar) {
			precio += atraccion.obtenerCosto();
		}

		return precio;
	}

	@Override
	public String toString() {
		DecimalFormat f = new DecimalFormat("#.##");
		String listaAtracciones = "";
		String listaAtraccionesAPagar = "";
		for (Atraccion atraccion : atracciones) {
			listaAtracciones += "    -" + atraccion.getNombre() + ", " + f.format(atraccion.obtenerCosto()) + " monedas de oro\n";
		}
		for (Atraccion atraccion : atraccionesAPagar) {
			listaAtraccionesAPagar += "    -" + atraccion.getNombre() + ", " + f.format(atraccion.obtenerCosto()) + " monedas de oro\n";
		}
		return "Promoción: " + this.nombre + "\n-Atracciones incluidas: \n" + listaAtracciones +
				"\n Solo paga por: \n" + listaAtraccionesAPagar +
				"\n-Duración: " + f.format(this.obtenerDuracion()) + " horas \n-Precio: " + f.format(this.obtenerCosto()) + " monedas de oro\n";
	}
	
	

}
