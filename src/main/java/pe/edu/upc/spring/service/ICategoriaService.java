package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Categoria;

public interface ICategoriaService {

	
	public boolean insertar(Categoria categoria); 
	public boolean modificar(Categoria categoria); 
	public void eliminar(int idCategoria); 
	public Optional<Categoria> listarId(int idCategoria); 
	List<Categoria> listar(); 
}
