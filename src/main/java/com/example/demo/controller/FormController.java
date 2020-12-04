package com.example.demo.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Estudiante;
import com.example.demo.service.IEstudianteService;

@Controller
public class FormController {

	@Autowired
	IEstudianteService estudianteService;
	
	@GetMapping("/")
	public String form(Map<String, Object> model) {
		Estudiante estudiante = new Estudiante();
		model.put("estudiante", estudiante);
		model.put("titulo", "Formulario de estudiantes");
		return "form";
	}
	
	
	@PostMapping("/")
	public String guarda(@Valid Estudiante estudiante, BindingResult resul, RedirectAttributes flash) {
		if (resul.hasErrors()) {
			return "form";
		}
		estudianteService.guardar(estudiante);
		flash.addFlashAttribute("success", "Estudiante guardado con exito");
		//return "redirect:/list";
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Model model){
		model.addAttribute("estudiantes", estudianteService.listAllEstudiantes());
		model.addAttribute("titulo", "Listadp de estudiantes");
		model.addAttribute("encabezado", "Listado de estudiantes");
		return "list";
	}

}
