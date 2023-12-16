package com.estoque.estoque.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.estoque.estoque.model.ProdutosModel;
import com.estoque.estoque.model.VendedorModel;
import com.estoque.estoque.model.dto.ProdutosDto;
import com.estoque.estoque.model.dto.VendedorDto;
import com.estoque.estoque.repositories.ProdutosRepository;
import com.estoque.estoque.repositories.VendedorRepository;
import com.estoque.estoque.service.exceptions.DuplicateObjectException;
import com.estoque.estoque.service.exceptions.ObjectnotFoundException;

@Service
public class ProdutosService {
	@Autowired
	ProdutosRepository produtosRepository;

	@Autowired
	VendedorRepository vendedorRepository;

	public ProdutosModel getById(Integer id) {
		return produtosRepository.findById(id)
				.orElseThrow(() -> new ObjectnotFoundException("Produto não encontrado ID:" + id));
	}

	public ProdutosModel create(ProdutosDto produtoDto) {
		Optional<List<ProdutosModel>> produto = produtosRepository.findByNome(produtoDto.getNome());
		List<ProdutosModel> lista = produto.get().stream()
				.filter((x) -> (x.getVendedor().getId()).equals(produtoDto.getVendedor())).collect(Collectors.toList());

		if (!lista.isEmpty()) {
			throw new DuplicateObjectException("Produto ja cadastrado, Nome do Produto: " + produtoDto.getNome()
					+ ", ID vendedor: " + produtoDto.getVendedor());
		}
		return produtosRepository.save(dtoToObject(produtoDto));
	}

	public List<ProdutosModel> getAll() {
		return produtosRepository.findAll();
	}

	public void delete(Integer id) {
		getById(id);
		produtosRepository.deleteById(id);
	}

	public ProdutosModel updateProduto(Integer id, ProdutosDto produtoDto) {
		getById(id);
		produtoDto.setId(id);
		return produtosRepository.save(dtoToObject(produtoDto));
	}

	public ProdutosModel dtoToObject(ProdutosDto produtoDto) {
		ProdutosModel object = new ProdutosModel(produtoDto.getId(), produtoDto.getNome(), produtoDto.getPreco(),
				produtoDto.getDesconto(), produtoDto.getQuantidadeEmEstoque(), produtoDto.getTiposProdutosEnums());

		VendedorModel vendedor = vendedorRepository.findById(produtoDto.getVendedor()).orElseThrow(
				() -> new ObjectnotFoundException("Vendedor não encontrado ID: " + produtoDto.getVendedor()));
		object.setVendedor(vendedor);

		return object;
	}
}
