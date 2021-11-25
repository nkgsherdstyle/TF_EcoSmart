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
@Table(name="Recolector")
	
public class Recolector implements Serializable {
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRecolector; 

	@Column(name="Usuario", nullable=false, length=30)
	private String usuario;
	
	@Column(name="Contrasena", nullable=false, length=60)
	private String contrasena;
	
	@Column(name="Nombre", nullable=false, length=20)
	private String nombre;
	
	@Column(name="Apellido", nullable=false, length=20)
	private String apellido;
	
	@Column(name="DNI", nullable=false, length=8)
	private Integer dni;
	
	@Column(name="Celular", nullable=false, length = 9)
	private Integer celular;
	
	@Column(name="Email", nullable=false, length=40)
	private String email;
	
	@Column(name="Direccion", nullable=false, length=50)
	private String direccion;
	
	
	/*@Column(name="Calificacion", nullable=false, columnDefinition = "DECIMAL(3,1)")
	private Float calificacion;*/
	
	@Column(name="Tipo", nullable=false, length=15) 
	private String tipo;
	
	/*@Column(name="Ganancia", nullable=false, columnDefinition = "DECIMAL(4,1)")
	private Float ganancia;*/
	
	@ManyToOne
	@JoinColumn(name="idDistrito", nullable = false)
	private Distrito distrito;

	public Recolector() {
		super();
	}

	public Recolector(int idRecolector, String usuario, String contrasena, String nombre, String apellido, Integer dni,
			Integer celular, String email, String direccion, Float calificacion, String tipo, Float ganancia,
			Distrito distrito) {
		super();
		this.idRecolector = idRecolector;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.celular = celular;
		this.email = email;
		this.direccion = direccion;
	/*	this.calificacion = calificacion;*/
		this.tipo = tipo;
	/*	this.ganancia = ganancia; */
		this.distrito = distrito;
	}

	public int getIdRecolector() {
		return idRecolector;
	}

	public void setIdRecolector(int idRecolector) {
		this.idRecolector = idRecolector;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/*public Float getCalificacion() {
		return calificacion;
	}*/

	/*public void setCalificacion(Float calificacion) {
		this.calificacion = calificacion;
	}*/

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

/*	public Float getGanancia() {
		return ganancia;
	}

	public void setGanancia(Float ganancia) {
		this.ganancia = ganancia;
	}*/

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

}
