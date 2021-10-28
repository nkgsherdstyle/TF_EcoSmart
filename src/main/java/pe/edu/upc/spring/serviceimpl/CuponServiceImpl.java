package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.edu.upc.spring.model.Cupon;
import pe.edu.upc.spring.repository.ICuponRepository;
import pe.edu.upc.spring.service.ICuponService;


@Service
public class CuponServiceImpl implements ICuponService {
 
	@Autowired
	private ICuponRepository dCupon;
	
	@Override 
	@Transactional
	public boolean insertar(Cupon cupon) {
			Cupon objCupon = dCupon.save(cupon); 
			if(objCupon == null)
				return false; 
			else 
				return true;
	}

	@Override 
	@Transactional
	public void eliminar(int idCupon) {
		dCupon.deleteById(idCupon);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cupon> listarId(int idCupon) {
		return dCupon.findById(idCupon);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cupon> listar() {
		return dCupon.findAll();
	}
	
	@Override 
	@Transactional
	public boolean modificar(Cupon cupon) {
		boolean flag=false; 
		try { 
			dCupon.save(cupon);
			flag=true;
		} 
		
		catch(Exception ex) { 
			System.out.println("Sucedio un error al modificar");
		} 
		return flag; 
	}
	@Override
	@Transactional(readOnly=true)
	public List<Cupon> findByNameCupon(String nombreCupon) throws Exception {
		return dCupon.findByNameCupon(nombreCupon);
	}
}
