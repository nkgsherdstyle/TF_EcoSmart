package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.spring.model.Cupon;

public interface ICuponService {

	public boolean insertar(Cupon cupon); 
	public boolean modificar(Cupon cupon); 
	public void eliminar(int idCupon); 
	public Optional<Cupon> listarId(int idCupon); 
	
	List<Cupon> listar(); 
	
	List<Cupon>findByNameCoupon (String nameCupon) throws Exception;
}
