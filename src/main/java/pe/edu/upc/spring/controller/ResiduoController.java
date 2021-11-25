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


import pe.edu.upc.spring.model.Residuo; 
import pe.edu.upc.spring.model.Categoria;
import pe.edu.upc.spring.model.Reciclador;

import pe.edu.upc.spring.service.ICategoriaService;
import pe.edu.upc.spring.service.IRecicladorService;
import pe.edu.upc.spring.service.IResiduoService;



@Controller

@RequestMapping("/residuo")
public class ResiduoController {
	@Autowired

	private IResiduoService resService;
	
	@Autowired
	private ICategoriaService catService;
	
	@Autowired
	private IRecicladorService recService; 
	
	@RequestMapping("/bienvenido")

	public String irPaginaBienvenida() {

		return "bienvenido";

	}

		

	@RequestMapping("/")

	public String irPaginaListadoResiduos(Map<String, Object> model) {

		model.put("listaResiduos", resService.listar());

		return "listResiduo";

	}

	

	@RequestMapping("/irRegistrar")

	public String irPaginaRegistrar(Model model) {

		model.addAttribute("residuo", new Residuo());
		model.addAttribute("categoria", new Categoria());
		model.addAttribute("reciclador", new Reciclador()); 
		
		
		model.addAttribute("listaCategorias", catService.listar());	 
		model.addAttribute("listaRecicladores", recService.listar());	
		return "residuo";

	}

	

	@RequestMapping("/registrar")

	public String registrar(@ModelAttribute Residuo objResiduo, BindingResult binRes, Model model)

			throws ParseException

	{

		if (binRes.hasErrors())
		{		
			model.addAttribute("listaCategorias", catService.listar());	 
			model.addAttribute("listaRecicladores", recService.listar());	
			return "residuo";
		}
		else {

			boolean flag = resService.insertar(objResiduo);

			if (flag)

				return "redirect:/residuo/listar";

			else {

				model.addAttribute("mensaje", "Ocurrio un error");

				return "redirect:/residuo/irRegistrar";

			}

		}

	}

	@RequestMapping("/modificar/{id}")

	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)

		throws ParseException 

	{

		Optional<Residuo> objResiduo = resService.listarId(id);

		if (objResiduo == null) {

			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");

			return "redirect:/residuo/listar";

		}

		else {
			model.addAttribute("listaCategorias", catService.listar());	
			model.addAttribute("listaRecicladores", recService.listar());
			
			
			if (objResiduo.isPresent())
				objResiduo.ifPresent(o -> model.addAttribute("residuo", o));
			return "residuo";

		}

	}

	

	@RequestMapping("/eliminar")

	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {

		try {

			if (id!=null && id>0) {

				resService.eliminar(id);

				model.put("listaResiduos", resService.listar());

			}

		}

		catch(Exception ex) {

			System.out.println(ex.getMessage());

			model.put("mensaje","Ocurrio un roche");

			model.put("listaResiduos", resService.listar());

			

		}

		return "listResiduo";

	}

	

	@RequestMapping("/listar")

	public String listar(Map<String, Object> model) {

		model.put("listaResiduos", resService.listar());

		return "listResiduo";

	}	
	
	
	
}
