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

import com.estoque.estoque.model.VendedorModel;
import com.estoque.estoque.model.dto.VendedorDto;
import com.estoque.estoque.service.VendedorService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/vendedores")
public class VendedorController {

	@Autowired
	VendedorService vendedorService;

	@GetMapping
	public ResponseEntity<List<VendedorDto>> getAllVendedores() {
		List<VendedorDto> vendedorDtos = vendedorService.getAll().stream().map(x -> new VendedorDto(x))
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(vendedorDtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<VendedorDto> getVendedorById(@PathVariable(value = "id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(new VendedorDto(vendedorService.getById(id)));
	}

	@PostMapping
	public ResponseEntity<VendedorDto> createVendedor(@Valid @RequestBody VendedorDto vendedorDto) {
		vendedorDto = new VendedorDto(vendedorService.create(vendedorDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(vendedorDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteVendedorById(@PathVariable(value = "id") Integer id) {
		vendedorService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Vendedor deletado");
	}

	@PutMapping("/{id}")
	public ResponseEntity<VendedorDto> updateVendedor(@PathVariable(value = "id") Integer id,
			@Valid @RequestBody VendedorDto vendedoresDto) {
		VendedorDto vendedor = new VendedorDto(vendedorService.updateVendedor(id, vendedoresDto));
		return ResponseEntity.status(HttpStatus.OK).body(vendedor);
	}

}
