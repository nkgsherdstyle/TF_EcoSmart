package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Distrito;

import pe.edu.upc.spring.model.Recolector;

public interface IRecolectorService {
	public boolean insertar(Recolector recolector); 
	public boolean modificar(Recolector recolector); 
	public void eliminar(int idRecolector); 
	public Optional<Recolector> listarId(int idRecolector); 
	
	List<Recolector> listar(); 
	List<Recolector> findByApellidoAndNombre(String Apellido, String Nombre) throws Exception;
	List<Recolector> findByApellidoStartingWithAndNombreStartingWith(String Apellido, String Nombre) throws Exception;
	List<Recolector> findByDistrito(Distrito distrito) throws Exception;
}
