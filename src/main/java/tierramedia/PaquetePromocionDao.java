package tierramedia;

import java.sql.Connection;
import java.util.List;

public class PaquetePromocionDao implements PromoDAO {

		public <T> boolean insert(T t) {
			// TODO Auto-generated method stub
			return false;
		}

		public <T> boolean delete(T t) {
			// TODO Auto-generated method stub
			return false;
		}

		public <T> boolean update(T t) {
			// TODO Auto-generated method stub
			return false;
		}

		public <T> List<T> findAll() {
			// TODO Auto-generated method stub
			try {
				Connection conn = Conexion.getConexion();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return null;
		}



	
	
	
}
