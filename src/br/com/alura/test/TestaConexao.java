package br.com.alura.test;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.modelo.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();

		Connection connection = connectionFactory.recuperarConexao();

		connection.close();
		System.out.println("DEU CERTO");
	}

}
