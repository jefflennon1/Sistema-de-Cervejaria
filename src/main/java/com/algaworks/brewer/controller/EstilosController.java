package com.algaworks.brewer.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Estilo;
import com.algaworks.brewer.service.CadastroEstiloService;
import com.algaworks.brewer.service.exception.NomeEstiloJaCadastradoException;

@Controller
public class EstilosController {
		
	@Autowired
	CadastroEstiloService cadastroEstiloService;
	
		@RequestMapping("/estilos/novo")
		public ModelAndView  novo(Estilo estilo) {
			ModelAndView mv = new ModelAndView("estilo/CadastroEstilo");
			
			return mv;		
		}
		
		
		@RequestMapping(value="/estilos/novo", method = RequestMethod.POST)
		public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result , Model model, RedirectAttributes attributes ) {
				if(result.hasErrors()) {
					return novo(estilo);
				}
				 try {
				cadastroEstiloService.salvar(estilo);
				 }catch(NomeEstiloJaCadastradoException e) {
					 result.rejectValue("nome", e.getMessage(), e.getMessage());
					 return novo(estilo);
				 }
			attributes.addFlashAttribute("mensagem" , "Estilo adicionado com sucesso");
			return new ModelAndView("redirect:/estilos/novo");
		}
		
		@RequestMapping(value="/estilos", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE})
		public @ResponseBody ResponseEntity<?> salvarEstiloRapido(@RequestBody @Valid Estilo estilo, BindingResult result) {
			if(result.hasErrors()) {
				return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
			}
		
			try {
			estilo=	cadastroEstiloService.salvar(estilo);
				
			}catch (NomeEstiloJaCadastradoException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
		 
		 return ResponseEntity.ok(estilo);
		// A anotação @RequestBody vai pegar o corpo da requisição e transformar no objeto ESTILO.
		 //ResponseEntity manipula a resposta.
		 //É necessário usar uma biblioteca auxiliar para transformar em objeto do tipo ESTILo, o spring não consegue fazer isso sozinho. A boblioteca que vou utilizar é a JACKSON (está declara no pom.xml)
		}
		
}
