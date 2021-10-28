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

import pe.edu.upc.spring.model.Cupon;
import pe.edu.upc.spring.service.ICuponService;


@Controller
@RequestMapping("/cupon")
public class CuponController {

	@Autowired

	private ICuponService cupService;

	

	@RequestMapping("/bienvenido")

	public String irPaginaBienvenida() {

		return "bienvenido";

	}

		

	@RequestMapping("/")

	public String irPaginaListadoCupones(Map<String, Object> model) {

		model.put("listaCupones", cupService.listar());

		return "listCupon";

	}

	

	@RequestMapping("/irRegistrar")

	public String irPaginaRegistrar(Model model) {

		model.addAttribute("cupon", new Cupon());

		return "cupon";

	}

	

	@RequestMapping("/registrar")

	public String registrar(@ModelAttribute Cupon objCupon, BindingResult binRes, Model model)

			throws ParseException

	{

		if (binRes.hasErrors())

			return "cupon";

		else {

			boolean flag = cupService.insertar(objCupon);

			if (flag)

				return "redirect:/cupon/listar";

			else {

				model.addAttribute("mensaje", "Ocurrio un error");

				return "redirect:/cupon/irRegistrar";

			}

		}

	}

	@RequestMapping("/modificar/{id}")

	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)

		throws ParseException 

	{

		Optional<Cupon> objCupon = cupService.listarId(id);

		if (objCupon == null) {

			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");

			return "redirect:/cupon/listar";

		}

		else {

			model.addAttribute("cupon", objCupon);

			return "cupon";

		}

	}

	

	@RequestMapping("/eliminar")

	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {

		try {

			if (id!=null && id>0) {

				cupService.eliminar(id);

				model.put("listaCupones", cupService.listar());

			}

		}

		catch(Exception ex) {

			System.out.println(ex.getMessage());

			model.put("mensaje","Ocurrio un roche");

			model.put("listaCupones", cupService.listar());

			

		}

		return "listCupon";

	}

	

	@RequestMapping("/listar")

	public String listar(Map<String, Object> model) {

		model.put("listaCupones", cupService.listar());

		return "listCupon";
	}	 
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("cupon", new Cupon());
		return "buscar";
	}
	
	/*CREO QUE LO BORRAMOS*/
	

	
}
