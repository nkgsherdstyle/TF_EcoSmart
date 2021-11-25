package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.SolicitudResiduo;
import pe.edu.upc.spring.repository.ISolicitudResiduoRepository;
import pe.edu.upc.spring.service.ISolicitudResiduoService;


@Service
public class SolicitudResiduoServiceImpl implements ISolicitudResiduoService {
	@Autowired
	private ISolicitudResiduoRepository dSolicitudResiduo;
	
	@Override 
	@Transactional
	public boolean insertar(SolicitudResiduo solicitudresiduo) {
		SolicitudResiduo objSolicitudResiduo = dSolicitudResiduo.save(solicitudresiduo); 
			if(objSolicitudResiduo == null)
				return false; 
			else 
				return true;
	}

	@Override 
	@Transactional
	public void eliminar(int idSolicitudResiduo) {
		dSolicitudResiduo.deleteById(idSolicitudResiduo);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<SolicitudResiduo> listarId(int idSolicitudResiduo) {
		return dSolicitudResiduo.findById(idSolicitudResiduo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SolicitudResiduo> listar() {
		return dSolicitudResiduo.findAll();
	}
	
	@Override 
	@Transactional
	public boolean modificar(SolicitudResiduo solicitudresiduo) {
		boolean flag=false; 
		try { 
			dSolicitudResiduo.save(solicitudresiduo);
			flag=true;
		} 
		
		catch(Exception ex) { 
			System.out.println("Sucedio un error al modificar");
		} 
		return flag; 
	} 
}
