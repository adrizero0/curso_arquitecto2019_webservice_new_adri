package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DaoClientes;
import model.Cliente;
@Service
public class ServiceClientesImpl implements ServiceClientes {
	@Autowired
	DaoClientes daoClientes;
	@Override
	public Cliente getCliente(String user, String pass) {
		return daoClientes.findByUsuarioAndPassword(user, pass);
	}

	@Override
	public void eliminarCliente(int dni) {
		if (daoClientes.existsById(dni)) {
			daoClientes.deleteById(dni);
		}

	}

	@Override
	public void guardarCliente(Cliente c) {
		if (!daoClientes.existsById(c.getIdCliente())) {
			daoClientes.save(c);
		}

	}

}
