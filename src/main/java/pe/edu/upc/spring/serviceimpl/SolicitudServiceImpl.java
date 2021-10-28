package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Solicitud;
import pe.edu.upc.spring.repository.ISolicitudRepository;
import pe.edu.upc.spring.service.ISolicitudService;

@Service
public class SolicitudServiceImpl implements ISolicitudService {
	@Autowired
	private ISolicitudRepository dSolicitud;
	
	@Override 
	@Transactional
	public boolean insertar(Solicitud solicitud) {
		Solicitud objSolicitud = dSolicitud.save(solicitud); 
			if(objSolicitud == null)
				return false; 
			else 
				return true;
	}

	@Override 
	@Transactional
	public void eliminar(int idSolicitud) {
		dSolicitud.deleteById(idSolicitud);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Solicitud> listarId(int idSolicitud) {
		return dSolicitud.findById(idSolicitud);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Solicitud> listar() {
		return dSolicitud.findAll();
	}
	
	@Override 
	@Transactional
	public boolean modificar(Solicitud solicitud) {
		boolean flag=false; 
		try { 
			dSolicitud.save(solicitud);
			flag=true;
		} 
		
		catch(Exception ex) { 
			System.out.println("Sucedio un error al modificar");
		} 
		return flag; 
	} 
}
