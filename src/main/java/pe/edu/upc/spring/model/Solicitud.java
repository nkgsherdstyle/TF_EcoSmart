package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Table(name="Solicitud")
	
public class Solicitud implements Serializable {
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSolicitud;  
	 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="Fecha", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name="monto_Total", nullable=true, columnDefinition = "DECIMAL(5,2)")
	private Float montoTotal;
	

	
	@Column(name="Estado", nullable = false, length = 20)
	private String estado;

	@ManyToOne
	@JoinColumn(name="idReciclador", nullable = false)
	private Reciclador reciclador;
	 
	@ManyToOne
	@JoinColumn(name="idRecolector", nullable = false)
	private Recolector recolector;

	public Solicitud() {
		super();

	}

	public Solicitud(int idSolicitud, Date fecha, Float montoTotal, String estado, Reciclador reciclador,
			Recolector recolector) {
		super();
		this.idSolicitud = idSolicitud;
		this.fecha = fecha;
		this.montoTotal = montoTotal;
		this.estado = estado;
		this.reciclador = reciclador;
		this.recolector = recolector;
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Reciclador getReciclador() {
		return reciclador;
	}

	public void setReciclador(Reciclador reciclador) {
		this.reciclador = reciclador;
	}

	public Recolector getRecolector() {
		return recolector;
	}

	public void setRecolector(Recolector recolector) {
		this.recolector = recolector;
	}
	
}
