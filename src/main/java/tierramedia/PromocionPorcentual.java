package tierramedia;

import java.text.DecimalFormat;
import java.util.List;

public class PromocionPorcentual extends Promocion  {
	
	private double porcentajeDeDescuento;
	
	public PromocionPorcentual( String nombre, List<Atraccion> atraccionesPromo,double porcentaje) {
		super(nombre,atraccionesPromo);
	    this. porcentajeDeDescuento=porcentaje;
	}
	
	@Override
	public double obtenerCosto() {
		double precio = 0;
		for (Atraccion atraccion : atracciones) {
			precio += atraccion.obtenerCosto();
		}

		return precio-(precio*(porcentajeDeDescuento/100));
	}
	
	@Override
	public String toString() {
		DecimalFormat f = new DecimalFormat("#.##");
		String listaAtracciones = "";
		for (Atraccion atraccion : atracciones) {
			listaAtracciones += "    -" + atraccion.getNombre() + ", " + f.format(atraccion.obtenerCosto()) + " monedas de oro\n";
		}
		return "Promoción: " + this.nombre + "\n-Atracciones incluidas: \n" + listaAtracciones +
				"\n-Duración: " + f.format(this.obtenerDuracion()) + " horas \n-Precio con descuento: " + f.format(obtenerCosto()) + " monedas de oro";
	}
}