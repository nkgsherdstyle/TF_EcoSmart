package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Categoria;
import pe.edu.upc.spring.repository.ICategoriaRepository;
import pe.edu.upc.spring.service.ICategoriaService;


@Service
public class CategoriaServiceImpl implements ICategoriaService {

	@Autowired
	private ICategoriaRepository dCategoria;
	
	@Override 
	@Transactional
	public boolean insertar(Categoria categoria) {
			Categoria objCategoria = dCategoria.save(categoria); 
			if(objCategoria == null)
				return false; 
			else 
				return true;
	}

	@Override 
	@Transactional
	public void eliminar(int idCategoria) {
		dCategoria.deleteById(idCategoria);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Categoria> listarId(int idCategoria) {
		return dCategoria.findById(idCategoria);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> listar() {
		return dCategoria.findAll();
	}
	
	@Override 
	@Transactional
	public boolean modificar(Categoria categoria) {
		boolean flag=false; 
		try { 
			dCategoria.save(categoria);
			flag=true;
		} 
		
		catch(Exception ex) { 
			System.out.println("Sucedio un error al modificar");
		} 
		return flag;
	}

}
