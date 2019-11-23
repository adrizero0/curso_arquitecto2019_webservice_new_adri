package service;

import java.util.List;

import model.Contacto;

public interface ServiceContacto {
	List<Contacto> recuperarcontactos();
	Contacto buscarPorEmail(String email);
	void eliminarPorId(int idContacto);
	void altaContacto(Contacto contacto);
	
}
