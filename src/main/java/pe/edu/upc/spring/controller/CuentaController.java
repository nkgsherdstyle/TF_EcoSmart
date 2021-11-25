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

import pe.edu.upc.spring.model.Cuenta; 
import pe.edu.upc.spring.model.Recolector;

import pe.edu.upc.spring.service.ICuentaService;
import pe.edu.upc.spring.service.IRecolectorService;



@Controller
@RequestMapping("/cuenta")
public class CuentaController {
	@Autowired

	private ICuentaService cueService;

	
	@Autowired

	private IRecolectorService recoService;

	
	
	@RequestMapping("/bienvenido")

	public String irPaginaBienvenida() {

		return "bienvenido";

	}

		

	@RequestMapping("/")

	public String irPaginaListadoCuentas(Map<String, Object> model) {

		model.put("listaCuentas", cueService.listar());

		return "listCuenta";

	}

	

	@RequestMapping("/irRegistrar")

	public String irPaginaRegistrar(Model model) {

		model.addAttribute("cuenta", new Cuenta());
		model.addAttribute("recolector", new Recolector());
		
		model.addAttribute("listaRecolectores", recoService.listar());
		
		return "cuenta";

	}

	

	@RequestMapping("/registrar")

	public String registrar(@ModelAttribute Cuenta objCuenta, BindingResult binRes, Model model)

			throws ParseException

	{

		if (binRes.hasErrors())

			return "cuenta";

		else {

			boolean flag = cueService.insertar(objCuenta);

			if (flag)

				return "redirect:/cuenta/listar";

			else {

				model.addAttribute("mensaje", "Ocurrio un error");

				return "redirect:/cuenta/irRegistrar";

			}

		}

	}

	@RequestMapping("/modificar/{id}")

	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)

		throws ParseException 

	{

		Optional<Cuenta> objCuenta = cueService.listarId(id);

		if (objCuenta == null) {

			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");

			return "redirect:/cuenta/listar";

		}

		else {
			model.addAttribute("listaRecolectores", recoService.listar());

			if (objCuenta.isPresent())
				objCuenta.ifPresent(o -> model.addAttribute("cuenta", o));

			return "cuenta";

		}

	}

	

	@RequestMapping("/eliminar")

	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {

		try {

			if (id!=null && id>0) {

				cueService.eliminar(id);

				model.put("listaCuentas", cueService.listar());

			}

		}

		catch(Exception ex) {

			System.out.println(ex.getMessage());

			model.put("mensaje","Ocurrio un roche");

			model.put("listaCuentas", cueService.listar());

			

		}

		return "listCuenta";

	}

	

	@RequestMapping("/listar")

	public String listar(Map<String, Object> model) {

		model.put("listaCuentas", cueService.listar());

		return "listCuenta";

	}	
}
