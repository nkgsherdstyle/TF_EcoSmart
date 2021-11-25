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
@Table(name="Reciclador")
	
public class Reciclador implements Serializable {
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReciclador; 
	
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
	
	
	/*@Column(name="Calificacion", nullable=false)
	private Integer calificacion;*/
	
	/*@Column(name="Puntos", nullable=false, columnDefinition = "DECIMAL(4,1)")
	private Float punto;*/
	
	@Column(name="Tipo", nullable=false, length=15) 
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="idDistrito", nullable = false)
	private Distrito distrito;

	public Reciclador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reciclador(int idReciclador, String usuario, String contrasena, String nombre, String apellido, Integer dni,
			Integer celular, String email, String direccion, Integer calificacion, Float punto, String tipo,
			Distrito distrito) {
		super();
		this.idReciclador = idReciclador;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.celular = celular;
		this.email = email;
		this.direccion = direccion;
	/*	this.calificacion = calificacion;
		this.punto = punto;*/
		this.tipo = tipo;
		this.distrito = distrito;
	}

	public int getIdReciclador() {
		return idReciclador;
	}

	public void setIdReciclador(int idReciclador) {
		this.idReciclador = idReciclador;
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

	/*public Integer getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}

	public Float getPunto() {
		return punto;
	}

	public void setPunto(Float punto) {
		this.punto = punto;
	}*/

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
	
	
}
