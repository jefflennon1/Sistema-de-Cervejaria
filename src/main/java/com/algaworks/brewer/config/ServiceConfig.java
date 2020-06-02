package com.algaworks.brewer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.algaworks.brewer.service.CadastroCervejaService;
import com.algaworks.brewer.service.CadastroCidadeService;

import com.algaworks.brewer.service.CadastroEstiloService;
import com.algaworks.brewer.service.CadastroUsuarioService;

@Configuration
@ComponentScan(basePackageClasses = {CadastroCervejaService.class, CadastroCidadeService.class,CadastroEstiloService.class, CadastroUsuarioService.class} )
public class ServiceConfig {

	
		
}
