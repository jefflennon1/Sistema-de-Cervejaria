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

import com.algaworks.brewer.model.Cidade;
import com.algaworks.brewer.model.Estado;
import com.algaworks.brewer.service.CadastroCidadeService;

@Controller
public class CidadesController {
	
	
	@Autowired
	private CadastroCidadeService cadastroCidadeService;

	@RequestMapping("/cidades/nova")
	public ModelAndView nova(Cidade cidade) {
		ModelAndView mv = new ModelAndView("cidade/CadastroCidade");
		mv.addObject("estados", Estado.values());
		
		return mv;
	}
	
  
	  @RequestMapping(value = "/cidades/nova"  ,method =  RequestMethod.POST)
		public ModelAndView salvar(@Valid Cidade cidade, BindingResult result, Model model, RedirectAttributes attributes) {
		
		  if(result.hasErrors()) {
			  return nova(cidade);
		  }
		  
		  
		cadastroCidadeService.salvar(cidade);
		attributes.addFlashAttribute("mensagem" , "Cidade adiconada com sucesso!");
		return new ModelAndView("redirect:/cidades/nova");
	}
}
