package tierramedia;

public class Usuario {
	private int id;
	private String nombre;
	private double presupuesto;
	private double tiempoDisponible;
	private Itinerario itinerario = new Itinerario();
	
	public Usuario(int id, String nombre, double presupuesto, double tiempoDisponible) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
	}
	
	public void agregarAItinerario(Ofertable ofertable) {		
		usuario.reducirTiempo(ofertable.obtenerDuracion());
		usuario.reducirPresupuesto(ofertable.obtenerCosto());
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
		return "Usuario [nombre= " + nombre + ", presupuesto= " + presupuesto + ", tiempoDisponible= " + tiempoDisponible
				+ "]\n";
	}
	
}