package dao;

public class FactoryDAO {
	public static AtraccionDAO getAtraccionDAO() {
		return new AtraccionDAO();
	}
	
	public static ItinerarioDAO getItinerarioDAO() {
		return new ItinerarioDAO();
	}
	
	public static PromocionDAO getPromocionDAO() {
		return new PromocionDAO();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO();
	}
	
	
}
