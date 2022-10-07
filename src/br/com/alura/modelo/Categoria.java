package br.com.alura.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void adicionaProduto(Produto produto) {
		this.produtos.add(produto);
	}
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	
	
	

}
