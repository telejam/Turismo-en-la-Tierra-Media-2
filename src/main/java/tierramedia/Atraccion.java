package tierramedia;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Atraccion implements Ofertable{
	
	protected int id;
	private String nombre;
	private double costoDeVisita;
	private double tiempoDeVisita;
	private int cupoDiarioDePersonas;
	
	public Atraccion(int id, String name, double price, double time, int limit) {
		this.id = id;
		this.nombre = name;
		this.costoDeVisita = price;
		this.tiempoDeVisita = time;
		this.cupoDiarioDePersonas = limit;
	}
	
	@Override
	public double obtenerCosto() {
		return this.costoDeVisita;
	}
	
	@Override
    public double obtenerDuracion() {
		return this.tiempoDeVisita;
	}
    
    public String getNombre() {
		return this.nombre;
	}

	@Override
    public List<Atraccion> obtenerContenido(){
        List<Atraccion> contenido = new ArrayList<Atraccion>();
        contenido.add(this);
        return contenido;
    }

	@Override
	public boolean hayCupo() {
		return this.cupoDiarioDePersonas>0;
	}
	
    public int restarCupo() {
        if(this.hayCupo()){
            this.cupoDiarioDePersonas -= 1;
        } else {
            System.out.println("Operación no permitida por falta de cupo");
        }

        return this.cupoDiarioDePersonas;
    }
    
    public int getId() {
		return this.id;
	}

    
	@Override
	public String toString() {
		DecimalFormat f = new DecimalFormat("#.##");
		return "Atracción: " + this.nombre + 
				"\n-Duración: " + f.format(obtenerDuracion()) + " horas \n-Precio: " + f.format(obtenerCosto()) + " monedas de oro";
	}
}