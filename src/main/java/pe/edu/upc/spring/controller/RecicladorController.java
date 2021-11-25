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

import pe.edu.upc.spring.model.Reciclador;
import pe.edu.upc.spring.model.Distrito; 


import pe.edu.upc.spring.service.IDistritoService;
import pe.edu.upc.spring.service.IRecicladorService;


@Controller
@RequestMapping("/reciclador")
public class RecicladorController {
	@Autowired

	private IRecicladorService recService;

	@Autowired

	private IDistritoService disService;
	
	

	@RequestMapping("/bienvenido")

	public String irPaginaBienvenida() {

		return "bienvenido";

	}

		

	@RequestMapping("/")

	public String irPaginaListadoRecicladores(Map<String, Object> model) {

		model.put("listaRecicladores", recService.listar());

		return "listReciclador";

	}

	

	@RequestMapping("/irRegistrar")

	public String irPaginaRegistrar(Model model) {

		model.addAttribute("reciclador", new Reciclador());
		model.addAttribute("distrito", new Distrito()); 
		
		model.addAttribute("listaDistritos", disService.listar());
		return "reciclador"; 

	}

	

	@RequestMapping("/registrar")

	public String registrar(@ModelAttribute Reciclador objReciclador, BindingResult binRes, Model model)

			throws ParseException

	{

		if (binRes.hasErrors())

			return "reciclador";

		else {

			boolean flag = recService.insertar(objReciclador);

			if (flag)

				return "redirect:/reciclador/listar";

			else {

				model.addAttribute("mensaje", "Ocurrio un error");

				return "redirect:/reciclador/irRegistrar";

			}

		}

	}

	@RequestMapping("/modificar/{id}")

	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)

		throws ParseException 

	{

		Optional<Reciclador> objReciclador = recService.listarId(id);

		if (objReciclador == null) {

			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");

			return "redirect:/reciclador/listar";

		}

		else { 
			
			model.addAttribute("listaDistritos", disService.listar());

			if (objReciclador.isPresent())
				objReciclador.ifPresent(o -> model.addAttribute("reciclador", o));

			return "reciclador";

		}

	}

	

	@RequestMapping("/eliminar")

	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {

		try {

			if (id!=null && id>0) {

				recService.eliminar(id);

				model.put("listaRecicladores", recService.listar());

			}

		}

		catch(Exception ex) {

			System.out.println(ex.getMessage());

			model.put("mensaje","Ocurrio un roche");

			model.put("listaRecicladores", recService.listar());

			

		}

		return "listReciclador";

	}

	

	@RequestMapping("/listar")

	public String listar(Map<String, Object> model) {

		model.put("listaRecicladores", recService.listar());

		return "listReciclador";
	}	 
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) 
	{
		model.addAttribute("reciclador", new Reciclador());
		return "buscarReciclador";
	}
	
	
}
