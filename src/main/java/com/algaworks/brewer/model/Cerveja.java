package com.algaworks.brewer.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.algaworks.brewer.validation.Sku;

@Entity
@Table(name = "cerveja")
public class Cerveja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	
	@Sku
	@NotBlank(message = "SKU é obrigatório")
	private String sku;

	
	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	
	@Size(min = 1, max = 50, message = "O tamanho da descrição deve estar entre 1 e 50")
	private String descricao;

	
	@NotNull(message ="É necessário informar o valor da cerveja")
	@DecimalMin(value = "0.50", message = "O valor da cerveja deve ser maior que R$0,50")
	@DecimalMax(value = "9999.99", message = "O valor da cerveja deve ser menor que R$9.999,99")
	private BigDecimal valor;

	
	@NotNull(message = "É necessário informar teor Alcóolico")
	@DecimalMax(value="100.0")
	@Column(name = "teor_alcoolico")
	private BigDecimal teorAlcoolico;

	
	@NotNull(message = "A comissão é obrigatória")
	@DecimalMax(value = "999.999")
	@DecimalMin(value = "0.01")
	private BigDecimal comissao;

	
	@Max(value = 9999)
	@Min( value = 1 , message = "Preencha o estoque")
	@NotNull(message="Preencha o estoque!")
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;

	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "A origem é obrigatória")
	private Origem origem;

	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O sabor é obrigatório")
	private Sabor sabor;

	
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	@NotNull(message = "O estilo é obrigatório")
	private Estilo estilo;
	
	
	@PrePersist @PreUpdate
	private void prePersistUpdate() {
		sku = sku.toUpperCase();
		descricao = descricao.toUpperCase();
		nome = nome.toUpperCase();
	}

	
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}