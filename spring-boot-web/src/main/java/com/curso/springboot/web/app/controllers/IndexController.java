package com.curso.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

	@GetMapping({ "/index", "/", "", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework!!");
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Kike");
		usuario.setApellido("navarro");
		usuario.setEmail("kike@correo.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del Usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {

		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Kike", "navarro", "kike@correo.com"));
		usuarios.add(new Usuario("taty", "alfaro", "taty@correo.com"));
		usuarios.add(new Usuario("ory", "navarro", "ory@correo.com"));
		usuarios.add(new Usuario("cami", "navarro", "cami@correo.com"));
		
		model.addAttribute("titulo", "Listado de Usuarios: ");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}

}
