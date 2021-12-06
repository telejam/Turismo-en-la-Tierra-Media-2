package tierramedia;

import java.util.Comparator;

public class ComparadorOfertables implements Comparator<Ofertable>{
	
	@Override
	public int compare(Ofertable oferta1, Ofertable oferta2) {
		int comparacion;
		if (oferta1.obtenerContenido().size() > 1 && oferta2.obtenerContenido().size() == 1) 
			comparacion = -1;

		else if (oferta1.obtenerContenido().size() == 1 && oferta2.obtenerContenido().size() > 1) 
			comparacion = 1;
		
		else {
			comparacion = -Double.compare(oferta1.obtenerCosto(), oferta2.obtenerCosto());
			if (comparacion == 0) {
				comparacion = -Double.compare(oferta1.obtenerDuracion(), oferta2.obtenerDuracion());
			}
		}
		return comparacion;
	}

}
