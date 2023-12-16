package com.estoque.estoque.model.dto;

import com.estoque.estoque.model.ProdutosModel;
import com.estoque.estoque.model.enums.TiposProdutosEnums;

import jakarta.validation.constraints.NotNull;

public class ProdutosDto {

	private Integer id;
	@NotNull(message = "vendedor requerido!")
	private Integer vendedor;
	@NotNull(message = "nome requerido!")
	private String nome;
	@NotNull(message = "preço requerido!")
	private double preco;
	private double desconto;
	private int quantidadeEmEstoque;
	@NotNull(message = "tipo do produto requerido!")
	private TiposProdutosEnums tiposProdutosEnums;

	public ProdutosDto() {
	}

	public ProdutosDto(Integer vendedor, String nome, double preco, TiposProdutosEnums tiposProdutosEnums) {
		super();
		this.vendedor = vendedor;
		this.nome = nome;
		this.preco = preco;
		this.tiposProdutosEnums = tiposProdutosEnums;
		this.desconto = 0;
		this.quantidadeEmEstoque = 0;
	}

	public ProdutosDto(Integer vendedor, String nome, double preco, TiposProdutosEnums tiposProdutosEnums,
			double desconto, int quantidade) {
		super();
		this.vendedor = vendedor;
		this.nome = nome;
		this.preco = preco;
		this.tiposProdutosEnums = tiposProdutosEnums;
		this.desconto = desconto;
		this.quantidadeEmEstoque = quantidade;
	}

	public ProdutosDto(ProdutosModel produtoObject) {
		this.id = produtoObject.getId();
		this.nome = produtoObject.getNome();
		this.vendedor = produtoObject.getVendedor().getId();
		this.preco = produtoObject.getPreco();
		this.tiposProdutosEnums = produtoObject.getTiposProdutosEnums();
		this.desconto = produtoObject.getDesconto();
		this.quantidadeEmEstoque = produtoObject.getQuantidadeEmEstoque();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVendedor() {
		return vendedor;
	}

	public void setVendedor(Integer vendedor) {
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
