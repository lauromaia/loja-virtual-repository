package br.com.alura.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.dao.ProdutoDao;
import br.com.alura.modelo.ConnectionFactory;
import br.com.alura.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {
		Produto produto = new Produto("SOFÁ", "SOFÁ CAMA");
		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			ProdutoDao produtoDao = new ProdutoDao(connection);
			produtoDao.salvar(produto);
			List<Produto> listaProdutos = produtoDao.listar();
			listaProdutos.forEach(p -> System.out.println(p));
		}
	}
}
