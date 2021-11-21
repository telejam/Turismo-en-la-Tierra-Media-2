package tierramedia;

import java.util.List;

public interface PromocionDAO {
	

		public <T> boolean insert(T t);
		
		public <T> boolean delete(T t);
		
		public <T> boolean update(T t);
		
		public <T> List<T> findAll();
		
		public int getId() {
			return id;
		}
		public void set(int id) {
			this.id = id;
		}
}
