package com.estoque.estoque.model;

import java.io.Serializable;

import com.estoque.estoque.model.enums.TiposProdutosEnums;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProdutosModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	@JsonIgnore
	private VendedorModel vendedor;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private double preco;
	private double desconto;
	private int quantidadeEmEstoque;
	@Column(nullable = false)
	private TiposProdutosEnums tiposProdutosEnums;

	public ProdutosModel() {
	}

	public ProdutosModel(String nome, double preco, double desconto, int quantidadeEmEstoque,
			TiposProdutosEnums tiposProduto) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.tiposProdutosEnums = tiposProduto;
	}

	public ProdutosModel(Integer id, String nome, double preco, double desconto, int quantidadeEmEstoque,
			TiposProdutosEnums tiposProduto) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
		this.quantidadeEmEstoque = quantidadeEmEstoque;
		this.tiposProdutosEnums = tiposProduto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public VendedorModel getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorModel vendedor) {
		this.vendedor = vendedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public TiposProdutosEnums getTiposProdutosEnums() {
		return tiposProdutosEnums;
	}

	public void setTiposProdutosEnums(Integer codigoTipo) {
		this.tiposProdutosEnums = TiposProdutosEnums.toEnum(codigoTipo);
	}
}
