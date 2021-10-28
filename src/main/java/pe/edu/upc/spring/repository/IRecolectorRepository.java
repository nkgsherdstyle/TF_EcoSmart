package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import pe.edu.upc.spring.model.Distrito;
import pe.edu.upc.spring.model.Recolector;

@Repository
public interface IRecolectorRepository extends JpaRepository<Recolector,Integer> {
	List<Recolector> findByLastNameAndFirstName(String apellido,String nombre);
	
	@Query("select g from Recolector g where g.apellido like ?1% and g.nombre like ?2%")
	List<Recolector> finByApellidoStartingWithAndNombreStartingWith(String apellido,String nombre);
	
	List<Recolector> findByDistrito(Distrito distrito); 

}
