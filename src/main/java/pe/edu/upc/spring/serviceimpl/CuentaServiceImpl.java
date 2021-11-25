package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Cuenta; 
import pe.edu.upc.spring.service.ICuentaService;
import pe.edu.upc.spring.repository.ICuentaRepository;


@Service
public class CuentaServiceImpl implements ICuentaService {
	@Autowired
	private ICuentaRepository dCuenta;
	
	@Override 
	@Transactional
	public boolean insertar(Cuenta cuenta) {
			Cuenta objCuenta = dCuenta.save(cuenta); 
			if(objCuenta == null)
				return false; 
			else 
				return true;
	}

	@Override 
	@Transactional
	public void eliminar(int idCuenta) {
		dCuenta.deleteById(idCuenta);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cuenta> listarId(int idCuenta) {
		return dCuenta.findById(idCuenta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cuenta> listar() {
		return dCuenta.findAll();
	}
	
	@Override 
	@Transactional
	public boolean modificar(Cuenta cuenta) {
		boolean flag=false; 
		try { 
			dCuenta.save(cuenta);
			flag=true;
		} 
		
		catch(Exception ex) { 
			System.out.println("Sucedio un error al modificar");
		} 
		return flag;
	}
}
