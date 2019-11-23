package daos;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Reserva;

public interface DaoReservas extends JpaRepository<Reserva, Integer> {	
	
}
