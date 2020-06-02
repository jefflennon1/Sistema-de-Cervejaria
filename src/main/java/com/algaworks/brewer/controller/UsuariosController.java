package com.algaworks.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Grupos;
import com.algaworks.brewer.model.Usuario;
import com.algaworks.brewer.service.CadastroUsuarioService;

@Controller
public class UsuariosController {

	@Autowired
	CadastroUsuarioService cadastroUsuarioService;
	
	@RequestMapping("/usuarios/novo")
	public ModelAndView novo(Usuario usuario) {
		ModelAndView mv = new ModelAndView("/usuario/CadastroUsuario");
		mv.addObject("grupos", Grupos.values());
		return mv;
	}
	
	
	@RequestMapping(value = "/usuarios/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Usuario usuario, Model model, BindingResult result, RedirectAttributes attributes  ) {
		if(result.hasErrors()) {
			return novo(usuario);
		}
		
		cadastroUsuarioService.salvar(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");
		return new ModelAndView("redirect:/usuarios/novo");
	}
}
