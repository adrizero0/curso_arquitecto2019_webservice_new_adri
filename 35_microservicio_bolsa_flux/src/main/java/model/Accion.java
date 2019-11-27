package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the acciones database table.
 * 
 */
@Entity
@Table(name="acciones")
@NamedQuery(name="Accion.findAll", query="SELECT a FROM Accion a")
public class Accion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String company;

	private double valor;

	public Accion() {
	}	

	public Accion(int id, String company, double valor) {
		super();
		this.id = id;
		this.company = company;
		this.valor = valor;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}