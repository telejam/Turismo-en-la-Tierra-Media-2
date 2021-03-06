package tierramedia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import dao.FactoryDAO;

public class Promotor{

	List<Atraccion> atracciones;
	List<Usuario> usuarios;
	PaquetePromociones paquetePromociones;
	List<Ofertable> ofertas = new ArrayList<Ofertable>(); 

	public Promotor() throws SQLException {
		atracciones = FactoryDAO.getAtraccionDAO().findAll();
		usuarios = FactoryDAO.getUsuarioDAO().findAll();
		paquetePromociones = new PaquetePromociones(atracciones);
	}
	
	public void iniciar() throws SQLException {
		
		for (Promocion promocion : paquetePromociones.getPromociones()) {
			ofertas.add((Ofertable) promocion);
		}

		for (Atraccion atraccion : atracciones) {
			ofertas.add((Ofertable) atraccion);
		}
		
    	Collections.sort(ofertas, new ComparadorOfertables());
// verificar ordenamiento
//    	for(Ofertable oferta : ofertas) {
//    		System.out.println("=========================\n"+oferta+"\n=======================");
//    	}

		for (Usuario usuario : usuarios) {

			System.out.println("Nombre de visitante: " + usuario.getNombre().toUpperCase() + "\n");

			for (Ofertable oferta : ofertas) {
				procesar(oferta, usuario);
			}

			System.out.println("Muchas gracias " + usuario.getNombre());
			System.out.println("\nQue disfrute su visita a la Tierra Media.");
			System.out.println("\n=========================================\n");
		
		}
	}

	private void procesar(Ofertable oferta, Usuario usuario) throws SQLException {
		Scanner entrada = null;

		//		verificar Ya Cargada
		if (!usuario.estaCargada(oferta)) {
			//		verificar Cupo
			if (oferta.hayCupo()) {
				//		verificar Usuario Presupuesto
				if (usuario.getPresupuesto() >= oferta.obtenerCosto()) {
					//		verificar Usuario Tiempo
					if (usuario.getTiempo() >= oferta.obtenerDuracion()) {
						//		sugerir
						System.out.println(oferta);
						
						entrada = new Scanner(System.in);
						String respuesta = "";
						
						while (!respuesta.equals("S") && !respuesta.equals("N")) {
							System.out.println("\n?Acepta sugerencia? Ingrese S o N");
							respuesta = (entrada.nextLine()).toUpperCase();
						}

						//		si acepta Sugerencia agregar Al Itinerario
						if (respuesta.equals("S")) {
							System.out.println("?Sugerencia Aceptada!");
							usuario.agregar(oferta);
							oferta.restarCupo();
							
						}else {
							System.out.println("?Sugerencia Rechazada!");
						}
						System.out.println("\n------------------------------------------\n");
					}
				}
			}
		}
	}

}
