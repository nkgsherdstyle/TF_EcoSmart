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

import pe.edu.upc.spring.model.Solicitud; 
import pe.edu.upc.spring.model.Recolector; 
import pe.edu.upc.spring.model.Reciclador;

import pe.edu.upc.spring.service.IRecicladorService;
import pe.edu.upc.spring.service.IRecolectorService;
import pe.edu.upc.spring.service.ISolicitudService;


@Controller
@RequestMapping("/solicitud")
public class SolicitudController {
	@Autowired

	private ISolicitudService soService;

	@Autowired

	private IRecolectorService recoService; 
	 
	@Autowired

	private IRecicladorService recService;

	@RequestMapping("/bienvenido")

	public String irPaginaBienvenida() {

		return "bienvenido";

	}

		

	@RequestMapping("/")

	public String irPaginaListadoSolicitudes(Map<String, Object> model) {

		model.put("listaSolicitudes", soService.listar());
		
		return "listSolicitud";

	}

	

	@RequestMapping("/irRegistrar")

	public String irPaginaRegistrar(Model model) {

		model.addAttribute("solicitud", new Solicitud());
		model.addAttribute("reciclador", new Reciclador()); 
		model.addAttribute("recolector", new Recolector()); 
		
		model.addAttribute("listaRecolectores", recoService.listar()); 
		model.addAttribute("listaRecicladores", recService.listar());
		
		return "solicitud";

	}

	

	@RequestMapping("/registrar")

	public String registrar(@ModelAttribute Solicitud objSolicitud, BindingResult binRes, Model model)

			throws ParseException

	{

		if (binRes.hasErrors())

			return "solicitud";

		else {

			boolean flag = soService.insertar(objSolicitud);

			if (flag)

				return "redirect:/solicitud/listar";

			else {

				model.addAttribute("mensaje", "Ocurrio un error");

				return "redirect:/solicitud/irRegistrar";

			}

		}

	}

	@RequestMapping("/modificar/{id}")

	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)

		throws ParseException 

	{

		Optional<Solicitud> objSolicitud = soService.listarId(id);

		if (objSolicitud == null) {

			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");

			return "redirect:/solicitud/listar";

		}

		else {
			
			
			model.addAttribute("listaRecolectores", recoService.listar());	
			model.addAttribute("listaRecicladores", recService.listar());
			
			if (objSolicitud.isPresent())
				objSolicitud.ifPresent(o -> model.addAttribute("solicitud", o)); 
			
			return "solicitud";

		}

	}

	

	@RequestMapping("/eliminar")

	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {

		try {

			if (id!=null && id>0) {

				soService.eliminar(id);

				model.put("listaSolicitudes", soService.listar());

			}

		}

		catch(Exception ex) {

			System.out.println(ex.getMessage());

			model.put("mensaje","Ocurrio un roche");

			model.put("listaSolicitudes", soService.listar());

			

		}

		return "listSolicitud";

	}

	

	@RequestMapping("/listar")

	public String listar(Map<String, Object> model) {

		model.put("listaSolicitudes", soService.listar());

		return "listSolicitud";

	}	
}
