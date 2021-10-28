package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.spring.model.Distrito;
import pe.edu.upc.spring.model.Reciclador;



public interface IRecicladorService {
	public boolean insertar(Reciclador reciclador); 
	public boolean modificar(Reciclador reciclador); 
	public void eliminar(int idReciclador); 
	public Optional<Reciclador> listarId(int idReciclador); 
	List<Reciclador> listar();  
	
	
	List<Reciclador> findByApellidoAndNombre(String Apellido, String Nombre) throws Exception;
	List<Reciclador> findByApellidoStartingWithAndNombreStartingWith(String Apellido, String Nombre) throws Exception;
	List<Reciclador> findByDistrito(Distrito distrito) throws Exception;
}
