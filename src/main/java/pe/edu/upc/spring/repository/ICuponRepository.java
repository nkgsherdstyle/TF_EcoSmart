package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Cupon;



@Repository
public interface ICuponRepository extends JpaRepository<Cupon,Integer>{
		List<Cupon> findByNameCupon (String nombreCupon);

}
