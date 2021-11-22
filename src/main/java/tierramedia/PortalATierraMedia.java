package tierramedia;

import java.sql.SQLException;

public class PortalATierraMedia {
	public static void main(String[] args) throws SQLException {
		System.out.println("Bienvenido a la Tierra Media");
		System.out.println("\n-------------------------------------------------------------------\n");
		
		Promotor promotor = new Promotor();
		
		promotor.iniciar();
	}
}
