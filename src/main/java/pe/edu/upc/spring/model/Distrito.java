package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="Distrito")
	
public class Distrito implements Serializable {
private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDistrito; 
	
	@Column(name="nombre_Distrito", nullable=false, length=30)
	private String nombre;

	public Distrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Distrito(int idDistrito, String nombre) {
		super();
		this.idDistrito = idDistrito;
		this.nombre = nombre;
	}

	public int getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 

}
