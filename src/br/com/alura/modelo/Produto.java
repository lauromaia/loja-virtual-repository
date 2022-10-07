package br.com.alura.modelo;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	
	public Produto(int id, String nome, String descricao) {
		this.descricao = descricao;
		this.id = id;
		this.nome = nome;
	}
	
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return String.format("O produto é: %d, %s, %s", this.id, this.nome, this.descricao);
	}
}
