package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.spring.model.SolicitudResiduo;

public interface ISolicitudResiduoService {

	public boolean insertar(SolicitudResiduo solicitudresiduo); 
	public boolean modificar(SolicitudResiduo solicitudresiduo); 
	public void eliminar(int idSolicitudResiduo); 
	public Optional<SolicitudResiduo> listarId(int SolicitudResiduo); 
	List<SolicitudResiduo> listar();  
}
