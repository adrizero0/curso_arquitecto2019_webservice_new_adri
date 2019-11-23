package daos;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Contacto;

public interface DaoContactos extends JpaRepository<Contacto, Integer>{
	Contacto findContactoByEmail(String email);
}
