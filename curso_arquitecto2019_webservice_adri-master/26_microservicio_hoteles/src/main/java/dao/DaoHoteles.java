package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Hotel;

public interface DaoHoteles extends JpaRepository<Hotel, Integer> {

	@Query("Select h From Hotel h Where h.disponible=1")
	List<Hotel> findAllDisponible();
}
