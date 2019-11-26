package daos;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Accion;

public interface DaoAcciones extends JpaRepository<Accion, Integer> {

}
