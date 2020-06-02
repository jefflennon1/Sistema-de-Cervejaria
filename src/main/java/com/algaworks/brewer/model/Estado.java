package com.algaworks.brewer.model;



public enum Estado {

	CE ("Ceará"),
	PB("Paraíba"),
	BA("Bahia");
	
	private String descricao;
	
	Estado(String descricao){
		this.setDescricao(descricao) ;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
