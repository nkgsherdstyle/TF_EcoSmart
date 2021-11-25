package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Categoria;
import pe.edu.upc.spring.service.ICategoriaService;



@Controller

@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired

	private ICategoriaService catService;

	

	@RequestMapping("/bienvenido")

	public String irPaginaBienvenida() {

		return "bienvenido";

	}

		

	@RequestMapping("/")

	public String irPaginaListadoCategorias(Map<String, Object> model) {

		model.put("listaCategorias", catService.listar());

		return "listCategoria";

	}

	

	@RequestMapping("/irRegistrar")

	public String irPaginaRegistrar(Model model) {

		model.addAttribute("categoria", new Categoria());

		return "categoria";

	}

	

	@RequestMapping("/registrar")

	public String registrar(@ModelAttribute Categoria objCategoria, BindingResult binRes, Model model)

			throws ParseException

	{

		if (binRes.hasErrors())

			return "categoria";

		else {

			boolean flag = catService.insertar(objCategoria);

			if (flag)

				return "redirect:/categoria/listar";

			else {

				model.addAttribute("mensaje", "Ocurrio un error");

				return "redirect:/categoria/irRegistrar";

			}

		}

	}

	@RequestMapping("/modificar/{id}")

	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)

		throws ParseException 

	{

		Optional<Categoria> objCategoria = catService.listarId(id);

		if (objCategoria == null) {

			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");

			return "redirect:/categoria/listar";

		}

		else {

			model.addAttribute("categoria", objCategoria);

			return "categoria";

		}

	}

	

	@RequestMapping("/eliminar")

	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {

		try {

			if (id!=null && id>0) {

				catService.eliminar(id);

				model.put("listaCategorias", catService.listar());

			}

		}

		catch(Exception ex) {

			System.out.println(ex.getMessage());

			model.put("mensaje","Ocurrio un roche");

			model.put("listaCategorias", catService.listar());

			

		}

		return "listCategoria";

	}

	

	@RequestMapping("/listar")

	public String listar(Map<String, Object> model) {

		model.put("listaCategorias", catService.listar());

		return "listCategoria";

	}	
}
