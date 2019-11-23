package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.DaoClientes;
import model.Cliente;

@Service("sCliente")
public class ServiceClienteImpl implements ServiceCliente {
	@Autowired
	DaoClientes daoClientes;	
	
	@Override
	public Cliente autenticar(String usuario, String password) {
		return daoClientes.findClienteByUsuarioAndPassword(usuario, password);		
	}

	@Transactional
	@Override
	public void alta(Cliente cliente) {
		daoClientes.save(cliente);		
	}

	@Transactional
	@Override
	public void eliminar(int dni) {
		daoClientes.deleteById(dni);
	}

	@Override
	public boolean buscarPorDni(int dni) {
		return daoClientes.existsById(dni);
	}

}
