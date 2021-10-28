package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Solicitud;

public interface ISolicitudService {
	public boolean insertar(Solicitud solicitud); 
	public boolean modificar(Solicitud solicitud); 
	public void eliminar(int idSolicitud); 
	public Optional<Solicitud> listarId(int Solicitud); 
	List<Solicitud> listar();  
}
