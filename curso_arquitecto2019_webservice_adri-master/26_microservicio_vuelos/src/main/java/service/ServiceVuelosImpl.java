package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import daos.DaoVuelos;
import model.Vuelo;

@Service("sVuelos")
public class ServiceVuelosImpl implements ServiceVuelos {
	@Autowired
	DaoVuelos daoVuelos;

	@Override
	public List<Vuelo> getVuelosDisponibles(int plazas) {
		return daoVuelos.findVuelosByDisponibilidad(plazas);
	}

	@Transactional
	@Override
	public boolean actualizarVuelo(int idVuelo, int plazas) {
		boolean estado=false;
		Vuelo vuelo= daoVuelos.findById(idVuelo).orElse(null);
		if(vuelo!=null&&vuelo.getPlazas()>=plazas) {			
			vuelo.setPlazas(vuelo.getPlazas()-plazas);
			daoVuelos.flush();
			estado=true;
		}
		return estado;
	}	

}
