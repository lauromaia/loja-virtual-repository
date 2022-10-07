package br.com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.modelo.Produto;

public class ProdutoDao {
	private Connection connection;
	
	

	public ProdutoDao(Connection connection) {
		this.connection = connection;

	}

	public void salvar(Produto produto) throws SQLException {String sql = "INSERT INTO PRODUTO(nome, descricao) VALUE (?, ?)";

	try (PreparedStatement ptsm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
		ptsm.setString(1, produto.getNome());
		ptsm.setString(2, produto.getDescricao());

		ptsm.execute();

		try (ResultSet rst = ptsm.getGeneratedKeys()) {
			while (rst.next()) {
				produto.setId(rst.getInt(1));
				System.out.println("Foi criado o produto " + produto.getNome() + ", de ID " + produto.getId());
			}
		}
	}
	}

	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList();
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
		try (PreparedStatement ptsm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ptsm.execute();
			
			try(ResultSet rst = ptsm.getResultSet()){
				while(rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));
					produtos.add(produto);
				}
			}
		}
		return produtos;
		
	}

}