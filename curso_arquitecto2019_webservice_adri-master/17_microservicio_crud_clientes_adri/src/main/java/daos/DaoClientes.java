package daos;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Cliente;

public interface DaoClientes extends JpaRepository<Cliente, Integer> {

	Cliente findClienteByUsuarioAndPassword(String usuario, String password);
}
