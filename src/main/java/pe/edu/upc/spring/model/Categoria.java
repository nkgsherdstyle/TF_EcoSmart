package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="Categoria")
	
public class Categoria implements Serializable {
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategoria;  
	
	@Column(name="Nombre", nullable=false, length=10)
	private String nombre;
	
	@Column(name="precio_Kilo", nullable=false, columnDefinition = "DECIMAL(3,2)")
	private Float precioKilo;

	public Categoria() {
		super();

	}

	public Categoria(int idCategoria, String nombre, Float precioKilo) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.precioKilo = precioKilo;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecioKilo() {
		return precioKilo;
	}

	public void setPrecioKilo(Float precioKilo) {
		this.precioKilo = precioKilo;
	}

}
