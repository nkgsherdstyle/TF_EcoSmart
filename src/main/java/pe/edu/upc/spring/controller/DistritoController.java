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

import pe.edu.upc.spring.model.Distrito;
import pe.edu.upc.spring.service.IDistritoService;

@Controller
@RequestMapping("/distrito")
public class DistritoController {
	@Autowired

	private IDistritoService disService;

	

	@RequestMapping("/bienvenido")

	public String irPaginaBienvenida() {

		return "bienvenido";

	}

		

	@RequestMapping("/")

	public String irPaginaListadoDistritos(Map<String, Object> model) {

		model.put("listaDistritos", disService.listar());

		return "listDistrito";

	}

	

	@RequestMapping("/irRegistrar")

	public String irPaginaRegistrar(Model model) {

		model.addAttribute("distrito", new Distrito());

		return "distrito";

	}

	

	@RequestMapping("/registrar")

	public String registrar(@ModelAttribute Distrito objDistrito, BindingResult binRes, Model model)

			throws ParseException

	{

		if (binRes.hasErrors())

			return "distrito";

		else {

			boolean flag = disService.insertar(objDistrito);

			if (flag)

				return "redirect:/distrito/listar";

			else {

				model.addAttribute("mensaje", "Ocurrio un error");

				return "redirect:/distrito/irRegistrar";

			}

		}

	}

	@RequestMapping("/modificar/{id}")

	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)

		throws ParseException 

	{

		Optional<Distrito> objDistrito = disService.listarId(id);

		if (objDistrito == null) {

			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");

			return "redirect:/distrito/listar";

		}

		else {

			model.addAttribute("distrito", objDistrito);

			return "distrito";

		}

	}

	

	@RequestMapping("/eliminar")

	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {

		try {

			if (id!=null && id>0) {

				disService.eliminar(id);

				model.put("listaDistritos", disService.listar());

			}

		}

		catch(Exception ex) {

			System.out.println(ex.getMessage());

			model.put("mensaje","Ocurrio un roche");

			model.put("listaDistritos", disService.listar());

			

		}

		return "listDistrito";

	}

	

	@RequestMapping("/listar")

	public String listar(Map<String, Object> model) {

		model.put("listaDistritos", disService.listar());

		return "listDistrito";

	}
}
