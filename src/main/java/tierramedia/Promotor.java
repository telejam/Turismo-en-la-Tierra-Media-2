package tierramedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Promotor{

	PaqueteAtracciones paqueteAtracciones = new PaqueteAtracciones();
	UsuarioDAO daoUsuarios = new UsuarioDAO();
	PaquetePromociones paquetePromociones = new PaquetePromociones(paqueteAtracciones.getAtracciones());
	List<Ofertable> ofertas = new ArrayList<Ofertable>(); 

	public void iniciar() {
		
		for (Promocion promocion : paquetePromociones.getPromociones()) {
			ofertas.add((Ofertable) promocion);
		}

		for (Atraccion atraccion : paqueteAtracciones.getAtracciones()) {
			ofertas.add((Ofertable) atraccion);
		}
		
    	Collections.sort(ofertas, new ComparadorOfertables());

		for (Usuario usuario : daoUsuarios.findAll()) {

			System.out.println("Nombre de visitante: " + usuario.getNombre().toUpperCase() + "\n");

			for (Ofertable oferta : ofertas) {
				procesar(oferta, usuario);
			}
		
		
		
		
		}
	}

	private void procesar(Ofertable oferta, Usuario usuario) {
		Scanner entrada= null;

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
							System.out.println("\n¿Acepta sugerencia? Ingrese S o N");
							respuesta = (entrada.nextLine()).toUpperCase();
						}

						//		si acepta Sugerencia agregar Al Itinerario
						if (respuesta.equals("S")) {
							System.out.println("¡Sugerencia Aceptada!");
							usuario.agregar(oferta);
							oferta.restarCupo();
							
						}else {
							System.out.println("¡Sugerencia Rechazada!");
						}
						System.out.println("\n-------------------------------------------------------------------\n");
					}
				}
			}
		}
		entrada.close(); 
	}

}
