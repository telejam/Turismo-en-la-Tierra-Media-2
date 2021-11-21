package tierramedia;

import java.util.List;


public abstract class Promocion implements Ofertable {

	protected int id;
	protected String nombre;
	protected List<Atraccion> atracciones;

	public Promocion(int id, String nombre, List<Atraccion> atraccionesPromo) {
		this.id = id;
		this.nombre = nombre;
		this.atracciones = atraccionesPromo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean hayCupo() {
		boolean cupo = true;
		for (Atraccion atraccion : this.atracciones) {
			if( !atraccion.hayCupo()) {
				cupo = false;
			}
			
		}
		return cupo;
	}

	public void restarCupo() {
		for (Atraccion atraccion : this.atracciones) {
			atraccion.restarCupo();
		}
	}
	
	public double obtenerDuracion() {

		double sumaTiempos = 0;
		for (Atraccion atraccion : this.atracciones) {
			sumaTiempos += atraccion.obtenerDuracion();
		}
		return sumaTiempos;
	}
	

	public List<Atraccion> obtenerContenido() {
          return atracciones;
	}
}


