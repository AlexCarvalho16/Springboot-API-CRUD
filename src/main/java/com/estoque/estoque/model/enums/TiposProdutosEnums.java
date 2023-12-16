package com.estoque.estoque.model.enums;

public enum TiposProdutosEnums {
	INFORMATICA(0, "Informática"), MOVEIS(1, "Móveis"), BRINQUEDOS(2, "Brinquedos"), ANIMAIS(3, "Animais"),
	COMIDAS(4, "Comidas");

	private Integer codigo;
	private String descricao;

	TiposProdutosEnums(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TiposProdutosEnums getTiposProdutosEnums() {
		return this;
	}

	public static TiposProdutosEnums toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		for (TiposProdutosEnums x : TiposProdutosEnums.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Tipo inválido inválido");
	}

}
