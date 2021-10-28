package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.spring.model.Cuenta;

public interface ICuentaService {

	public boolean insertar(Cuenta cuenta); 
	public boolean modificar(Cuenta cuenta); 
	public void eliminar(int idCuenta); 
	public Optional<Cuenta> listarId(int idCuenta); 
	
	List<Cuenta> listar(); 
}
