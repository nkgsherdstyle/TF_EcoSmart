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

import pe.edu.upc.spring.model.SolicitudResiduo;
import pe.edu.upc.spring.service.ISolicitudResiduoService;


@Controller
@RequestMapping("/solicitudresiduo")
public class SolicitudResiduoController {
	@Autowired

	private ISolicitudResiduoService solService;

	

	@RequestMapping("/bienvenido")

	public String irPaginaBienvenida() {

		return "bienvenido";

	}

		

	@RequestMapping("/")

	public String irPaginaListadoSolicitudResiduos(Map<String, Object> model) {

		model.put("listaSolicitudResiduos", solService.listar());

		return "listSolicitudResiduo";

	}

	

	@RequestMapping("/irRegistrar")

	public String irPaginaSolicitudResiduo(Model model) {

		model.addAttribute("solicitudresiduo", new SolicitudResiduo());

		return "solicitudresiduo";

	}

	

	@RequestMapping("/registrar")

	public String registrar(@ModelAttribute SolicitudResiduo objSolicitudResiduo, BindingResult binRes, Model model)

			throws ParseException

	{

		if (binRes.hasErrors())

			return "solicitudresiduo";

		else {

			boolean flag = solService.insertar(objSolicitudResiduo);

			if (flag)

				return "redirect:/solicitudresiduo/listar";

			else {

				model.addAttribute("mensaje", "Ocurrio un error");

				return "redirect:/solicitudresiduo/irRegistrar";

			}

		}

	}

	@RequestMapping("/modificar/{id}")

	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)

		throws ParseException 

	{

		Optional<SolicitudResiduo> objSolicitudResiduo = solService.listarId(id);

		if (objSolicitudResiduo == null) {

			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");

			return "redirect:/cuenta/listar";

		}

		else {

			model.addAttribute("solicitudresiduo", objSolicitudResiduo);

			return "solicitudresiduo";

		}

	}

	

	@RequestMapping("/eliminar")

	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {

		try {

			if (id!=null && id>0) {

				solService.eliminar(id);

				model.put("listaSolicitudResiduos", solService.listar());

			}

		}

		catch(Exception ex) {

			System.out.println(ex.getMessage());

			model.put("mensaje","Ocurrio un roche");

			model.put("listaSolicitudResiduos", solService.listar());

			

		}

		return "listSolicitudResiduo";

	}

	

	@RequestMapping("/listar")

	public String listar(Map<String, Object> model) {

		model.put("listaSolicitudResiduos", solService.listar());

		return "listSolicitudResiduo";

	}	
}
