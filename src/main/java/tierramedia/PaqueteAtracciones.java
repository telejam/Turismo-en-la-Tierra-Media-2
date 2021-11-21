package tierramedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PaqueteAtracciones {
    private List<Atraccion> Atracciones =  new ArrayList<Atraccion>();
    private AtraccionesDAO atraccionesDAO = new AtraccionesDAO();
    
    public PaqueteAtracciones() throws SQLException  {
    	cargarAtracciones();
    }
    
    public List<Atraccion> getAtracciones() {
    	return this.Atracciones;
    }
    
    
    public void cargarAtracciones() throws SQLException  {
    	this.Atracciones = atraccionesDAO.findAll();
    	
    }
    
    public void ordenar() {
    	Collections.sort(Atracciones, new ComparadorOfertables());
    }
}