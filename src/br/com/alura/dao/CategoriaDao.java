package br.com.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;

public class CategoriaDao {
	
	
	private Connection connection;

	public CategoriaDao(Connection connection) throws SQLException {
		this.connection = connection;
	}
		public List listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		String sql = "SELECT ID, NOME FROM CATEGORIA";
		try(PreparedStatement ptsm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			ptsm.execute();
			
			try(ResultSet rst = ptsm.getResultSet()){
				while(rst.next()) {
					Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
					categorias.add(categoria);
				}
				}
			}
		return categorias;
	
	
	}
		
		public List listarComProdutos() throws SQLException {
			Categoria referencia = null;
			List<Categoria> categorias = new ArrayList<Categoria>();
			
			String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO FROM CATEGORIA C INNER JOIN PRODUTO P ON C.ID = P.CATEGORIA_ID";
			try(PreparedStatement ptsm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				ptsm.execute();
				
				try(ResultSet rst = ptsm.getResultSet()){
					while(rst.next()) {
						
						if(referencia == null || !referencia.getNome().equals(rst.getString(2)) ) {	
						Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
						referencia = categoria;
						categorias.add(categoria);
						
						}
						Produto produto = new Produto(rst.getInt(3), rst.getString(4), rst.getString(5));
						referencia.adicionaProduto(produto);
						
						
					
				}
			return categorias;
		
		
		}
			
			
			
		

}
		}
}

