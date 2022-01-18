package fuctura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import fuctura.model.Cliente;
import fuctura.repository.ClienteRepositorio;

public class Aplicacao {

	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		String URL = "jdbc:oracle:thin:@localhost:1521:xe";
		String usuario = "fuctura";
		String senha = "123";
		
		Connection conexao = DriverManager
					.getConnection(URL, usuario, senha);
		
		System.out.println("Conectado com sucesso!");
		
		ClienteRepositorio clienteRepo = new ClienteRepositorio();
		
		//pedir pra o usuário digitar os dados
		
		String nome = "Roberto";
		String cpf = "123";
		String email = "r@gmail.com";
		int idade = 10;
		
		Cliente cliente = new Cliente(nome, cpf, idade, email);
		
		//como enviar os dados digitados para dentro do método inserir?
		clienteRepo.inserirComPreparatedStatement(conexao, cliente);
		
		System.out.println("Registro inserido com sucesso!");
		
	}
	

	
}
