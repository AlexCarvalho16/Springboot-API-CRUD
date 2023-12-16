package com.estoque.estoque.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoque.estoque.model.ProdutosModel;

public interface ProdutosRepository extends JpaRepository<ProdutosModel, Integer> {
	public Optional<List<ProdutosModel>> findByNome(String nome);

}
