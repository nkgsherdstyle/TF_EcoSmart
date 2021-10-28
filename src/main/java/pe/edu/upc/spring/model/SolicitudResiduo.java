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
@Table(name="SolicitudResiduo")
	
public class SolicitudResiduo implements Serializable {
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSolicitudResiduo;  
	
	@Column(name="precio", nullable= true , columnDefinition = "DECIMAL(3,1)")
	private float precio;
	

	@ManyToOne
	@JoinColumn(name="idSolicitud", nullable = false)
	private Solicitud solicitud;
	
	@ManyToOne
	@JoinColumn(name="idResiduo", nullable = false)
	private Residuo residuo;

	public SolicitudResiduo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SolicitudResiduo(int idSolicitudResiduo, float precio, Solicitud solicitud, Residuo residuo) {
		super();
		this.idSolicitudResiduo = idSolicitudResiduo;
		this.precio = precio;
		this.solicitud = solicitud;
		this.residuo = residuo;
	}

	public int getIdSolicitudResiduo() {
		return idSolicitudResiduo;
	}

	public void setIdSolicitudResiduo(int idSolicitudResiduo) {
		this.idSolicitudResiduo = idSolicitudResiduo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Solicitud getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	public Residuo getResiduo() {
		return residuo;
	}

	public void setResiduo(Residuo residuo) {
		this.residuo = residuo;
	}

	
}
