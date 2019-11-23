package service;

import model.Cliente;

public interface ServiceCliente {
	Cliente autenticar(String usuario, String password);
	void alta(Cliente cliente);
	void eliminar(int dni);
	boolean buscarPorDni(int dni);
}