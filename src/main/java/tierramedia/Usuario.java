package tierramedia;

import java.sql.SQLException;

public class Usuario {
	private int id;
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private Itinerario itinerario;
	
	public Usuario(int id, String nombre, double presupuesto, double tiempoDisponible) throws SQLException {
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.itinerario =  new Itinerario(this);
	}
	
	
	public void agregar(Ofertable ofertable) throws SQLException {		
		reducirTiempo(ofertable.obtenerDuracion());
		reducirPresupuesto(ofertable.obtenerCosto());
		itinerario.agregar(ofertable);
	}
	public boolean estaCargada(Ofertable ofertable) {		
		return itinerario.estaCargada(ofertable);
	}
	public void  reducirPresupuesto(double costoDeVisita) {
		this.presupuesto -= costoDeVisita;
	}

	public void reducirTiempo(double tiempoDeVisita) {
		this.tiempoDisponible -= tiempoDeVisita;
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

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempo() {
		return tiempoDisponible;
	}

	@Override
	public String toString() {
		return "Usuario [id= " + id + ", nombre= " + nombre + ", presupuesto= " + presupuesto + ", tiempoDisponible= " + tiempoDisponible
				+ "]\n";
	}
	
}
