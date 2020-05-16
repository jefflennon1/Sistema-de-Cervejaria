package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.brewer.model.Cliente;

@Controller
public class ClientesController {

	
	@RequestMapping("/clientes/novo")
	public String novoCli() {
		return "cliente/CadastroCliente";
	}
	
	
	@RequestMapping(value="/clientes/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(Cliente cliente, Model model) {
		
		return new ModelAndView("redirect:/clientes/novo");
	}
}
