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


@Entity 
@Table(name="Cupon")
	
public class Cupon implements Serializable {
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCupon; 
	
	@Column(name="nombre_Cupon", nullable=false, length=50)
	private String nombreCupon;
	
	@Column(name="fecha_Expiracion", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date fechaExpiracion;
	
	@Column(name="Codigo", nullable=false, length=10)
	private String codigo;
	
	@Column(name="Punto", nullable=false)
	private Integer punto;
	
	@ManyToOne
	@JoinColumn(name="idReciclador", nullable = true)
	private Reciclador reciclador;

	public Cupon() {
		super();

	}

	public Cupon(int idCupon, String nombreCupon, Date fechaExpiracion, String codigo, Integer punto,
			Reciclador reciclador) {
		super();
		this.idCupon = idCupon;
		this.nombreCupon = nombreCupon;
		this.fechaExpiracion = fechaExpiracion;
		this.codigo = codigo;
		this.punto = punto;
		this.reciclador = reciclador;
	}

	public int getIdCupon() {
		return idCupon;
	}

	public void setIdCupon(int idCupon) {
		this.idCupon = idCupon;
	}

	public String getNombreCupon() {
		return nombreCupon;
	}

	public void setNombreCupon(String nombreCupon) {
		this.nombreCupon = nombreCupon;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getPunto() {
		return punto;
	}

	public void setPunto(Integer punto) {
		this.punto = punto;
	}

	public Reciclador getReciclador() {
		return reciclador;
	}

	public void setReciclador(Reciclador reciclador) {
		this.reciclador = reciclador;
	}
	
	
}




