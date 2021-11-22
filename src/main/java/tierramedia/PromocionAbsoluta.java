package tierramedia;

import java.text.DecimalFormat;
import java.util.List;

public class PromocionAbsoluta extends Promocion {
	
	private double precioFijo;
	
	public PromocionAbsoluta(int id, String nombre, List<Atraccion> atracciones, double valor) {
		super(id, nombre, atracciones);
		this.precioFijo = valor;
	}

	public double obtenerCosto() {
		return this.precioFijo;
	}
	
	@Override
	public String toString() {
		DecimalFormat f = new DecimalFormat("#.##");
		String listaAtracciones = "";
		for (Atraccion atraccion : atracciones) {
			listaAtracciones += "    -" + atraccion.getNombre() + ", " + f.format(atraccion.obtenerCosto()) + " monedas de oro\n";
		}
		return "Promoción: " + this.nombre + "\n-Atracciones incluidas: \n" + listaAtracciones +
				"\n-Duración: " + f.format(this.obtenerDuracion()) + " horas \n-Precio: " + f.format(this.obtenerCosto()) + " monedas de oro\n";
	}
}
