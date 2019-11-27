package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DaoAcciones;
import model.Accion;

@Service("sAccion")
public class AccionServiceImpl implements AccionService {
	@Autowired
	DaoAcciones daoAcciones;
	
	@Override
	public List<Accion> getAcciones() {
		return daoAcciones.findAll();
	}
}
