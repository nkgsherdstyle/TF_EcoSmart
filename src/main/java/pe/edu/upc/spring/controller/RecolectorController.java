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

import pe.edu.upc.spring.model.Recolector;
import pe.edu.upc.spring.service.IRecolectorService;



@Controller
@RequestMapping("/recolector")
public class RecolectorController {
	@Autowired

	private IRecolectorService recoService;

	

	@RequestMapping("/bienvenido")

	public String irPaginaBienvenida() {

		return "bienvenido";

	}

		

	@RequestMapping("/")

	public String irPaginaListadoRecolectores(Map<String, Object> model) {

		model.put("listaRecolectores", recoService.listar());

		return "listRecolector";

	}

	

	@RequestMapping("/irRegistrar")

	public String irPaginaRegistrar(Model model) {

		model.addAttribute("recolector", new Recolector());

		return "recolector";

	}

	

	@RequestMapping("/registrar")

	public String registrar(@ModelAttribute Recolector objRecolector, BindingResult binRes, Model model)

			throws ParseException

	{

		if (binRes.hasErrors())

			return "recolector";

		else {

			boolean flag = recoService.insertar(objRecolector);

			if (flag)

				return "redirect:/recolector/listar";

			else {

				model.addAttribute("mensaje", "Ocurrio un error");

				return "redirect:/recolector/irRegistrar";

			}

		}

	}

	@RequestMapping("/modificar/{id}")

	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)

		throws ParseException 

	{

		Optional<Recolector> objRecolector = recoService.listarId(id);

		if (objRecolector == null) {

			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");

			return "redirect:/recolectorr/listar";

		}

		else {

			model.addAttribute("Recolector", objRecolector);

			return "recolector";

		}

	}

	

	@RequestMapping("/eliminar")

	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {

		try {

			if (id!=null && id>0) {

				recoService.eliminar(id);

				model.put("listaRecolectores", recoService.listar());

			}

		}

		catch(Exception ex) {

			System.out.println(ex.getMessage());

			model.put("mensaje","Ocurrio un roche");

			model.put("listaRecolector", recoService.listar());

			

		}

		return "listRecolector";

	}

	

	@RequestMapping("/listar")

	public String listar(Map<String, Object> model) {

		model.put("listaRecolectores", recoService.listar());

		return "listRecolector";
	}	 
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("recolector", new Recolector());
		return "buscar";
	}
	
}
