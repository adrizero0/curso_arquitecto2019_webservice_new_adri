package model;

public class Vuelo {
	
	private int idvuelo;

	private String company;

	private String fecha;

	private int plazas;

	private double precio;

	public Vuelo() {
	}

	public Vuelo(int idvuelo, String company, String fecha, int plazas, double precio) {
		super();
		this.idvuelo = idvuelo;
		this.company = company;
		this.fecha = fecha;
		this.plazas = plazas;
		this.precio = precio;
	}

	public int getIdvuelo() {
		return this.idvuelo;
	}

	public void setIdvuelo(int idvuelo) {
		this.idvuelo = idvuelo;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getPlazas() {
		return this.plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}