package br.com.alura.test;

import java.sql.SQLException;

import br.com.alura.modelo.ConnectionFactory;

public class TestaLimiteConexoes {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for(int i = 1; i < 20; i++) {
		connectionFactory.recuperarConexao();
		System.out.println("Conexão número: " + i);
		}
	}

}
