package com.algaworks.brewer.model;

public enum Grupos {

	ADM("Administrador"),
	VENDEDOR("Vendedor");
	
	
	private String descricao;
	
	Grupos(String descricao){
		this.setDescricao(descricao);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
