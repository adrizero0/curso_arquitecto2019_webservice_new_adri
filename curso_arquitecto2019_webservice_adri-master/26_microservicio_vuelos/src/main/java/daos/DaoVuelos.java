package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Vuelo;

public interface DaoVuelos extends JpaRepository<Vuelo, Integer> {
	
	@Query ("SELECT v FROM Vuelo v WHERE v.plazas>=?1")
	List<Vuelo> findVuelosByDisponibilidad(int plazas);
	
}
