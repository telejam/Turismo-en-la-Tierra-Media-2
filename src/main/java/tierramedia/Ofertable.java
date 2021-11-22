package tierramedia;

import java.util.List;

public interface Ofertable {
	public int getId();
	public double obtenerCosto();
	public double obtenerDuracion();
	public boolean hayCupo();
	public void restarCupo();
	public List<Atraccion> obtenerContenido();
}
