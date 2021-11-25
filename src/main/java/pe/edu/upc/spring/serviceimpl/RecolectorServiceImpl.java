package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Distrito;
import pe.edu.upc.spring.model.Recolector;
import pe.edu.upc.spring.repository.IRecolectorRepository;
import pe.edu.upc.spring.service.IRecolectorService;

@Service
public class RecolectorServiceImpl implements IRecolectorService {
	@Autowired
	private IRecolectorRepository dRecolector;
	
	@Override 
	@Transactional
	public boolean insertar(Recolector recolector) {
		Recolector objRecolector = dRecolector.save(recolector); 
			if(objRecolector == null)
				return false; 
			else 
				return true;
	}

	@Override 
	@Transactional
	public void eliminar(int idRecolector) {
		dRecolector.deleteById(idRecolector);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Recolector> listarId(int idRecolector) {
		return dRecolector.findById(idRecolector);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Recolector> listar() {
		return dRecolector.findAll();
	}
	
	@Override 
	@Transactional
	public boolean modificar(Recolector recolector) {
		boolean flag=false; 
		try { 
			dRecolector.save(recolector);
			flag=true;
		} 
		
		catch(Exception ex) { 
			System.out.println("Sucedio un error al modificar");
		} 
		return flag; 
	}  
	
	@Override
	@Transactional(readOnly=true)
	public List<Recolector> findByApellidoAndNombre(String Apellido, String Nombre) throws Exception {
		return dRecolector.findByApellidoAndNombre(Apellido, Nombre);
		}
	
	
	@Override
	@Transactional(readOnly=true)
	public List<Recolector> findByApellidoStartingWithAndNombreStartingWith(String Apellido, String Nombre) throws Exception {
		return dRecolector.finByApellidoStartingWithAndNombreStartingWith(Apellido, Nombre);
	}

	
	@Override
	@Transactional(readOnly=true)
	public List<Recolector> findByDistrito(Distrito distrito) throws Exception {
		return dRecolector.findByDistrito(distrito);
	}

	
}
