package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.spring.model.Transaccion;

public interface ITransaccionService {
	public boolean insertar(Transaccion transaccion); 
	public boolean modificar(Transaccion transaccion); 
	public void eliminar(int idTransaccion); 
	public Optional<Transaccion> listarId(int idTransaccion); 
	
	List<Transaccion> listar(); 
}
