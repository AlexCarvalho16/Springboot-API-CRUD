package com.estoque.estoque.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estoque.estoque.model.VendedorModel;
import com.estoque.estoque.model.dto.VendedorDto;
import com.estoque.estoque.repositories.ProdutosRepository;
import com.estoque.estoque.repositories.VendedorRepository;
import com.estoque.estoque.service.exceptions.DuplicateObjectException;
import com.estoque.estoque.service.exceptions.EntityHasDependenciesException;
import com.estoque.estoque.service.exceptions.ObjectnotFoundException;

@Service
public class VendedorService {
	@Autowired
	ProdutosRepository produtosRepository;

	@Autowired
	VendedorRepository vendedorRepository;

	public VendedorModel getById(Integer id) {
		return vendedorRepository.findById(id)
				.orElseThrow(() -> new ObjectnotFoundException("Vendedor não encontrado ID: " + id));
	}

	public List<VendedorModel> getAll() {
		return vendedorRepository.findAll();
	}

	public VendedorModel create(VendedorDto vendedorDto) {
		List<VendedorModel> listaVendedores = vendedorRepository.findByNome(vendedorDto.getNome());
		if (!listaVendedores.isEmpty()) {
			throw new DuplicateObjectException("Vendedores já cadastrado: " + vendedorDto.getNome());
		}

		return vendedorRepository.save(dtoToObject(vendedorDto));
	}

	public void deleteById(Integer id) {
		VendedorModel vendedor = getById(id);

		if (!vendedor.getProdutos().isEmpty()) {
			throw new EntityHasDependenciesException("Vendedor possui dependências");
		}

		vendedorRepository.deleteById(id);
	}

	public VendedorModel dtoToObject(VendedorDto vendedorDto) {
		VendedorModel vendedor = new VendedorModel();
		BeanUtils.copyProperties(vendedorDto, vendedor);

		return vendedor;
	}

	public VendedorModel updateVendedor(Integer id, VendedorDto vendedoresDto) {
		getById(id);
		vendedoresDto.setId(id);
		return create(vendedoresDto);
	}

}
