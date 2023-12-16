package com.estoque.estoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoque.estoque.model.VendedorModel;

public interface VendedorRepository extends JpaRepository<VendedorModel, Integer> {
	public List<VendedorModel> findByNome(String nome);
}
