package tierramedia;

public class PromoParcial {
	private int id;
	private String nombre;
	private String tipo;
	private double valor;

	public PromoParcial(int id, String nombre, String tipo, double valor) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setPrecio(double valor) {
		this.valor = valor;
	}

}
