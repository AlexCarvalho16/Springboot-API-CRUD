package com.estoque.estoque.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.estoque.estoque.model.ProdutosModel;
import com.estoque.estoque.model.VendedorModel;

import jakarta.validation.constraints.NotNull;

public class VendedorDto {

	private Integer id;
	@NotNull(message = "nome requerido!")
	private String nome;
	private List<ProdutosModel> produtos = new ArrayList<ProdutosModel>();

	public VendedorDto() {
	}

	public VendedorDto(VendedorModel vendedorObject) {
		this.id = vendedorObject.getId();
		this.nome = vendedorObject.getNome();
		this.produtos = vendedorObject.getProdutos();
	}

	public VendedorDto(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ProdutosModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutosModel> produtos) {
		this.produtos = produtos;
	}

}
