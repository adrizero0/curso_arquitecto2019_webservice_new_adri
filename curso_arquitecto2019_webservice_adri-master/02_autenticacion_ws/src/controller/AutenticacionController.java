package controller;

import factories.FactoryDao;
import javabeans.Cliente;
import modelo.DaoClientes;

public class AutenticacionController {
	
	public boolean autenticar(String usuario, String password) {
		DaoClientes gestion=FactoryDao.getDaoClientes();
		return gestion.autenticar(usuario, password);
	}
	
	public Cliente obtenerCliente(String user, String pwd) {
		DaoClientes daoClientes=FactoryDao.getDaoClientes();
		return daoClientes.getCliente(user, pwd);
	}
}
