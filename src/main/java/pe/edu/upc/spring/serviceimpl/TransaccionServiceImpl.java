package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Transaccion;
import pe.edu.upc.spring.repository.ITransaccionRepository;
import pe.edu.upc.spring.service.ITransaccionService;

@Service
public class TransaccionServiceImpl implements ITransaccionService {

	@Autowired
	private ITransaccionRepository dTransaccion;
	
	@Override 
	@Transactional
	public boolean insertar(Transaccion transaccion) {
		Transaccion objTransaccion = dTransaccion.save(transaccion); 
			if(objTransaccion == null)
				return false; 
			else 
				return true;
	}

	@Override 
	@Transactional
	public void eliminar(int idTransaccion) {
		dTransaccion.deleteById(idTransaccion);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Transaccion> listarId(int idTransaccion) {
		return dTransaccion.findById(idTransaccion);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Transaccion> listar() {
		return dTransaccion.findAll();
	}
	
	@Override 
	@Transactional
	public boolean modificar(Transaccion transaccion) {
		boolean flag=false; 
		try { 
			dTransaccion.save(transaccion);
			flag=true;
		} 
		
		catch(Exception ex) { 
			System.out.println("Sucedio un error al modificar");
		} 
		return flag; 
	} 
}
