package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Distrito;
import pe.edu.upc.spring.model.Reciclador;


@Repository

public interface IRecicladorRepository  extends JpaRepository<Reciclador, Integer>{
 
	List<Reciclador> findByApellidoAndNombre(String apellido, String nombre);
	
	@Query("select r from Reciclador r where r.apellido like ?1% and r.nombre like ?2%")
	List<Reciclador> findByApellidoStartingWithAndNombreStartingWith(String apellido, String nombre);
	
	List<Reciclador> findByDistrito(Distrito distrito);

}
