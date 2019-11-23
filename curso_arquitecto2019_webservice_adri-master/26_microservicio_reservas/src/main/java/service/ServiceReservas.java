package service;

import java.util.List;

import model.Reserva;

public interface ServiceReservas {
	List<Reserva> getReservas();
	boolean reservar(Reserva reserva);
}