package com.estoque.estoque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class VendedorModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, unique = true)
	private String nome;
	@OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ProdutosModel> produtos = new ArrayList<ProdutosModel>();

	public VendedorModel() {
	}

	public VendedorModel(String nome) {
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

	public void setProduto(List<ProdutosModel> produtos) {
		this.produtos = produtos;
	}

	public void addProduto(ProdutosModel produtos) {
		this.produtos.add(produtos);
	}

}
