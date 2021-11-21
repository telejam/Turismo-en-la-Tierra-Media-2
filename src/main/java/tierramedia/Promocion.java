package tierramedia;

import java.util.List;

import tierramedia.Atraccion;
import tierramedia.Ofertable;


public abstract class Promocion implements Ofertable {
    protected int id;
	protected String nombre;
	protected List<Atraccion> atracciones;
	
     promocionDAO dao=new promocionDAO();
     
	public Promocion(int id,String nombre, List<Atraccion> atraccionesPromo) {
		this.id=id;
		this.nombre = nombre;
		this.atracciones= atraccionesPromo;
		
	}

	public String getNombre() { // metodo para tomar nombre de la promocion de la db 
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean hayCupo() {
		boolean cupo = true;
		for (Atraccion atraccion : this.atracciones) {
			if( !atraccion.hayCupo()) {
				cupo = false;
			}
			
		}
		return cupo;
	}
	@Override
	public double obtenerDuracion() {

		double sumaTiempos = 0;
		for (Atraccion atraccion : this.atracciones) {
			sumaTiempos += atraccion.obtenerDuracion();
		}
		return sumaTiempos;
	}
	@Override
	public List<Atraccion> obtenerContenido() {

          return atracciones;

	}
	
}
