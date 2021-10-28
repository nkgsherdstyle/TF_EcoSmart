package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cuenta")


public class Cuenta implements Serializable { 
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCuenta; 
	
	@Column(name="numero_Cuenta", nullable=false)
	private int numeroCuenta;
	
	@Column(name ="contrasena_Cuenta", nullable=false) 
	private String contrasenaCuenta; 
	
	@ManyToOne
	@JoinColumn(name ="idRecolector", nullable=false) 
	private Recolector recolector ;

	public Cuenta() {
		super();
	}

	public Cuenta(int idCuenta, int numeroCuenta, String contrasenaCuenta, Recolector recolector) {
		super();
		this.idCuenta = idCuenta;
		this.numeroCuenta = numeroCuenta;
		this.contrasenaCuenta = contrasenaCuenta;
		this.recolector = recolector;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getContrasenaCuenta() {
		return contrasenaCuenta;
	}

	public void setContrasenaCuenta(String contrasenaCuenta) {
		this.contrasenaCuenta = contrasenaCuenta;
	}

	public Recolector getRecolector() {
		return recolector;
	}

	public void setRecolector(Recolector recolector) {
		this.recolector = recolector;
	}

	
}
