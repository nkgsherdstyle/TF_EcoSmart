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

import pe.edu.upc.spring.model.Transaccion;
import pe.edu.upc.spring.service.ITransaccionService;


@Controller
@RequestMapping("/transaccion")
public class TransaccionController {
	@Autowired

	private ITransaccionService traService;

	

	@RequestMapping("/bienvenido")

	public String irPaginaBienvenida() {

		return "bienvenido";

	}

		

	@RequestMapping("/")

	public String irPaginaListadoTransacciones(Map<String, Object> model) {

		model.put("listaTransacciones", traService.listar());

		return "listTransaccion";

	}

	

	@RequestMapping("/irRegistrar")

	public String irPaginaRegistrar(Model model) {

		model.addAttribute("transaccion", new Transaccion());

		return "transaccion";

	}

	

	@RequestMapping("/registrar")

	public String registrar(@ModelAttribute Transaccion objTransaccion, BindingResult binRes, Model model)

			throws ParseException

	{

		if (binRes.hasErrors())

			return "transaccion";

		else {

			boolean flag = traService.insertar(objTransaccion);

			if (flag)

				return "redirect:/transaccion/listar";

			else {

				model.addAttribute("mensaje", "Ocurrio un error");

				return "redirect:/transaccion/irRegistrar";

			}

		}

	}

	@RequestMapping("/modificar/{id}")

	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)

		throws ParseException 

	{

		Optional<Transaccion> objTransaccion = traService.listarId(id);

		if (objTransaccion == null) {

			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");

			return "redirect:/transaccion/listar";

		}

		else {

			model.addAttribute("transaccion", objTransaccion);

			return "transaccion";

		}

	}

	

	@RequestMapping("/eliminar")

	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {

		try {

			if (id!=null && id>0) {

				traService.eliminar(id);

				model.put("listaTransacciones", traService.listar());

			}

		}

		catch(Exception ex) {

			System.out.println(ex.getMessage());

			model.put("mensaje","Ocurrio un roche");

			model.put("listaTransacciones", traService.listar());

			

		}

		return "listTransaccion";

	}

	

	@RequestMapping("/listar")

	public String listar(Map<String, Object> model) {

		model.put("listaTransacciones", traService.listar());

		return "listTransaccion";

	}	
}
