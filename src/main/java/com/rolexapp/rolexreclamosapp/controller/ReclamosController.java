package com.rolexapp.rolexreclamosapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.rolexapp.rolexreclamosapp.models.Reclamos;
import com.rolexapp.rolexreclamosapp.models.Response;
import com.rolexapp.rolexreclamosapp.service.IReclamosService;



@Controller
@RequestMapping("/app")
@SessionAttributes("reclamos")
public class ReclamosController {
    @Value("${titlePage.param}")
	private String titlePage;
	
	@Autowired 
	private IReclamosService IpService;
	
	@GetMapping("/home")
	public String Home(Model model) {
		return "redirect:/";
	}
	
	@GetMapping("/reclamos")
	public String ListarReclamos(Model model) {
		model.addAttribute("titlePage", titlePage);
		Response<Reclamos> response = IpService.ObtenerListaReclamos();
		
		if (response.getEstado()) {
			model.addAttribute("ListaReclamos", response.getListData());
			return "reclamos";
		} else {
			model.addAttribute("respuesta", response.getMensaje());
			model.addAttribute("errores", response.getMensajeError());
			return "errores";
		}
	}
	
	@GetMapping("/form")
	public String FormularioReclamos(Model model) {
		model.addAttribute("titlePage", titlePage);

		Reclamos reclamos = new Reclamos();

		model.addAttribute("titlePage", titlePage);

		model.addAttribute("reclamos", reclamos);

		return "reclamosForm";
	}
	
	@PostMapping("/Nuevoform")
	public String CrearFormulario(@Validated Reclamos reclamos, BindingResult br, Model model, SessionStatus status) {
		model.addAttribute("titlePage", titlePage);
		if (br.hasErrors()) {
			return "reclamosForm";
		}
		model.addAttribute("titlePage", titlePage);
		Response<Reclamos> response = IpService.CrearReclamos(reclamos);

		if (response.getEstado()) {
			model.addAttribute("ListaReclamos", response.getListData());

			status.setComplete();
			return "redirect:/";
		} else {
			model.addAttribute("respuesta", response.getMensaje());
			model.addAttribute("errores", response.getMensajeError());

			status.setComplete();
			return "errores";
		}
	}
	@PostMapping("/Nuevoform2")
	public String CrearFormulario2(@Validated Reclamos reclamos, BindingResult br, Model model, SessionStatus status) {
		model.addAttribute("titlePage", titlePage);
		if (br.hasErrors()) {
			return "reclamosForm2";
		}
		model.addAttribute("titlePage", titlePage);
		Response<Reclamos> response = IpService.CrearReclamos(reclamos);

		if (response.getEstado()) {
			model.addAttribute("ListaReclamos", response.getListData());

			status.setComplete();
			return "redirect:/app/reclamos";		
		} else {
			model.addAttribute("respuesta", response.getMensaje());
			model.addAttribute("errores", response.getMensajeError());

			status.setComplete();
			return "errores";
		}
	}
	
	@GetMapping("/form2")
	public String FormularioReclamos2(Model model) {
		model.addAttribute("titlePage", titlePage);

		Reclamos reclamos = new Reclamos();

		model.addAttribute("titlePage", titlePage);

		model.addAttribute("reclamos", reclamos);

		return "reclamosForm2";
	}
	@GetMapping("/Editar/{id}")
	public String editarReclamos(@PathVariable int id, Model model) {
		
		model.addAttribute("titlePage", titlePage);
		Response<Reclamos> response = IpService.EditarReclamos(id);

		if (response.getEstado()) {			
			model.addAttribute("reclamos", response.getData());
			model.addAttribute("respuesta", "Se actualizó el pokemon");
			return "reclamosForm2";
		} else {
			model.addAttribute("respuesta", response.getMensaje());
			model.addAttribute("errores", response.getMensajeError());

			return "errores";
		}
	}
	
	

	@GetMapping("/Eliminar/{id}")
	public String eliminarReclamos(@PathVariable int id, Model model) {
		
		model.addAttribute("titlePage", titlePage);
		Response<Reclamos> response = IpService.EliminarReclamos(id);

		if (response.getEstado()) {
			model.addAttribute("titulo", "Spring Framework - "+response.getMensaje());	
			model.addAttribute("respuesta", response.getMensaje());
			return "redirect:/app/reclamos";
		} else {
			model.addAttribute("respuesta", response.getMensaje());
			model.addAttribute("errores", response.getMensajeError());

			return "errores";
		}		
	}
    
}
