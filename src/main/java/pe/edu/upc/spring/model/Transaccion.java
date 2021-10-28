package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Transaccion implements Serializable { 
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTransaccion;
	
	@Column(name="Nombre", nullable=false, length=20) 
	private String nombre;
	
	@Column(name="Fecha", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date Fecha;
	
	@Column(name="tipo_Pago", nullable=false, length=20)
	private String tipoPago;
	
	@Column(name="tipo_Transaccion", nullable=false, length=20)
	private String tipoTransaccion;
	
	@Column(name="Ganancia", nullable=true, columnDefinition = "DECIMAL(3,1)")
	private Float ganancia;
	
	@ManyToOne
	@JoinColumn(name = "idCuenta", nullable = false)
	private Cuenta cuenta;

	public Transaccion() {
		super();

	}

	public Transaccion(int idTransaccion, String nombre, Date fecha, String tipoPago, String tipoTransaccion,
			Float ganancia, Cuenta cuenta) {
		super();
		this.idTransaccion = idTransaccion;
		this.nombre = nombre;
		Fecha = fecha;
		this.tipoPago = tipoPago;
		this.tipoTransaccion = tipoTransaccion;
		this.ganancia = ganancia;
		this.cuenta = cuenta;
	}

	public int getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Float getGanancia() {
		return ganancia;
	}

	public void setGanancia(Float ganancia) {
		this.ganancia = ganancia;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	
}
