package service;

import model.Cliente;

public interface ServiceClientes {
	Cliente getCliente(String user, String pass);
	void eliminarCliente(int dni);
	void guardarCliente(Cliente c);
}
