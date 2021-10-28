package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.spring.model.Residuo;

public interface IResiduoService {

	public boolean insertar(Residuo residuo); 
	public boolean modificar(Residuo residuo); 
	public void eliminar(int idResiduo); 
	public Optional<Residuo> listarId(int idResiduo);  
	List<Residuo> listar();
	
	
}
