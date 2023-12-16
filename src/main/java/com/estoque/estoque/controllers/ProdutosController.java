package com.estoque.estoque.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.estoque.model.dto.ProdutosDto;
import com.estoque.estoque.service.ProdutosService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/produtos")
public class ProdutosController {
	@Autowired
	ProdutosService produtosService;

	@GetMapping
	public ResponseEntity<List<ProdutosDto>> getAllProdutos() {
		List<ProdutosDto> produtosDtos = produtosService.getAll().stream().map(x -> new ProdutosDto(x))
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(produtosDtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutosDto> getProdutoById(@PathVariable(value = "id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(new ProdutosDto(produtosService.getById(id)));
	}

	@PostMapping
	public ResponseEntity<Object> createProduto(@Valid @RequestBody ProdutosDto produtoDto) {
		produtoDto = new ProdutosDto(produtosService.create(produtoDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduto(@PathVariable(value = "id") Integer id) {
		produtosService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Produto deletado!");
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutosDto> updateProduto(@PathVariable(value = "id") Integer id,
			@Valid @RequestBody ProdutosDto produtoDto) {
		ProdutosDto produto = new ProdutosDto(produtosService.updateProduto(id, produtoDto));
		return ResponseEntity.status(HttpStatus.OK).body(produto);

	}

}
