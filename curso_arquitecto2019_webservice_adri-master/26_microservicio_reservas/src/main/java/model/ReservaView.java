package model;

public class ReservaView {
	private Reserva reserva;
	private int plazas;
	public ReservaView(Reserva reserva, int plazas) {
		super();
		this.reserva = reserva;
		this.plazas = plazas;
	}
	public ReservaView() {
		super();
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	
}
