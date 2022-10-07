package br.com.alura.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.dao.CategoriaDao;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.ConnectionFactory;
import br.com.alura.modelo.Produto;

public class TestaListagemCategorias {

	public static void main(String[] args) throws SQLException {
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			
		CategoriaDao categoriaDao = new CategoriaDao(connection);
		List<Categoria> categorias = categoriaDao.listarComProdutos();
		categorias.forEach(c -> {
			System.out.println(c.getNome());
			for(Produto produto : c.getProdutos()) {
				System.out.println(c.getNome() + " - " + produto.getNome());
			}
		});	
		}
	}
}
