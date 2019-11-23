package service;

import java.util.List;

import model.Vuelo;

public interface ServiceVuelos {
	List<Vuelo> getVuelosDisponibles(int plazas);
	boolean actualizarVuelo(int idVuelo, int plazas);
}