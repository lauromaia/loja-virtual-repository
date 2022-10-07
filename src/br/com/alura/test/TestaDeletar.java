package br.com.alura.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.modelo.ConnectionFactory;

public class TestaDeletar {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setString(1, "3");
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount();
		System.out.println("Foram excluídas " + linhasModificadas + " linhas.");
		
		
		connection.close();
	}

}
