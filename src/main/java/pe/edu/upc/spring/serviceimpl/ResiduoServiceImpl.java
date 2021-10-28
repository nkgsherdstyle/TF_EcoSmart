package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Residuo;
import pe.edu.upc.spring.repository.IResiduoRepository;
import pe.edu.upc.spring.service.IResiduoService;

@Service
public class ResiduoServiceImpl implements IResiduoService {
	
	@Autowired
	private IResiduoRepository dResiduo;
	
	@Override 
	@Transactional
	public boolean insertar(Residuo residuo) {
		Residuo objResiduo = dResiduo.save(residuo); 
			if(objResiduo == null)
				return false; 
			else 
				return true;
	}

	@Override 
	@Transactional
	public void eliminar(int idResiduo) {
		dResiduo.deleteById(idResiduo);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Residuo> listarId(int idResiduo) {
		return dResiduo.findById(idResiduo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Residuo> listar() {
		return dResiduo.findAll();
	}
	
	@Override 
	@Transactional
	public boolean modificar(Residuo residuo) {
		boolean flag=false; 
		try { 
			dResiduo.save(residuo);
			flag=true;
		} 
		
		catch(Exception ex) { 
			System.out.println("Sucedio un error al modificar");
		} 
		return flag; 
	} 
}
