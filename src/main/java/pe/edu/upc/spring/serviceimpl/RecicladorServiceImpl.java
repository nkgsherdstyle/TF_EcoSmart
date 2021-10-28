package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Distrito;
import pe.edu.upc.spring.model.Reciclador;
import pe.edu.upc.spring.repository.IRecicladorRepository;
import pe.edu.upc.spring.service.IRecicladorService;


@Service
public class RecicladorServiceImpl implements IRecicladorService{
	@Autowired
	private IRecicladorRepository dReciclador;
	
	@Override 
	@Transactional
	public boolean insertar(Reciclador reciclador) {
		Reciclador objReciclador = dReciclador.save(reciclador); 
			if(objReciclador == null)
				return false; 
			else 
				return true;
	}

	@Override 
	@Transactional
	public void eliminar(int idReciclador) {
		dReciclador.deleteById(idReciclador);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Reciclador> listarId(int idReciclador) {
		return dReciclador.findById(idReciclador);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Reciclador> listar() {
		return dReciclador.findAll();
	}
	
	@Override 
	@Transactional
	public boolean modificar(Reciclador reciclador) {
		boolean flag=false; 
		try { 
			dReciclador.save(reciclador);
			flag=true;
		} 
		
		catch(Exception ex) { 
			System.out.println("Sucedio un error al modificar");
		} 
		return flag; 
	} 
	
	@Override
	@Transactional(readOnly = true)
	public List<Reciclador> findByApellidoStartingWithAndNombreStartingWith(String Apellido, String Nombre)
			throws Exception {
		return  dReciclador.findByApellidoStartingWithAndNombreStartingWith(Apellido, Nombre);
	}
	 
	@Override
	@Transactional(readOnly = true)
	public List<Reciclador> findByApellidoAndNombre(String Apellido, String Nombre) throws Exception {
	
		return  dReciclador.findByApellidoAndNombre(Apellido, Nombre);
	}
	 
	@Override
	@Transactional(readOnly = true)
	public List<Reciclador> findByDistrito(Distrito distrito) throws Exception {
		return  dReciclador.findByDistrito(distrito);
	}
}
