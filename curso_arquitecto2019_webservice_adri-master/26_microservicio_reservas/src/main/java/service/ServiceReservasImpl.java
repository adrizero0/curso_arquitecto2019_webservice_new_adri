package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.DaoReservas;
import model.Reserva;

@Service("sReservas")
public class ServiceReservasImpl implements ServiceReservas {
	@Autowired
	DaoReservas daoReservas;	

	@Override
	public boolean reservar(Reserva reserva) {
		daoReservas.saveAndFlush(reserva);
		return true;
	}

	@Override
	public List<Reserva> getReservas() {
		return daoReservas.findAll();
	}

}
