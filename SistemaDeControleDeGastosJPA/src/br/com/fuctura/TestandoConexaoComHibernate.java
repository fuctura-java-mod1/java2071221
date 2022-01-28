package br.com.fuctura;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import br.com.fuctura.entity.Filme;
import br.com.fuctura.repository.FilmeRepositorio;
import br.com.fuctura.util.JPAUtil;

public class TestandoConexaoComHibernate {

	public static void main(String[] args) {
		// ctrl + espaço - auto complete
		EntityManagerFactory fabrica =  JPAUtil.getFabrica();
		
		fabrica = JPAUtil.getFabrica();
		fabrica = JPAUtil.getFabrica();
		fabrica = JPAUtil.getFabrica();
		fabrica = JPAUtil.getFabrica();
		
		System.out.println("Conectado com sucesso!");

		//como salvar filme?
		Filme filme = new Filme();
		filme.setNome("Turma da Mônica");
		filme.setDuracao(120);
		filme.setLinkDoVideoNoYoutube("yt/12389");
		
		Filme filme2 = new Filme();
		filme2.setNome("Homem Aranha");
		filme2.setDuracao(210);
		filme2.setLinkDoVideoNoYoutube("yt/12389");
		
		FilmeRepositorio filmeRepositorio = new FilmeRepositorio();
		
		filmeRepositorio.persist(filme);
		filmeRepositorio.persist(filme2);
		
		System.out.println("Registro inserido com sucesso!");
		
		Filme buscaDoFilme = filmeRepositorio.find(filme2);
		
		System.out.println("O nome do filme encontrado é: " + buscaDoFilme.getNome() );
		
		
		System.out.println("Duracao do filme antes: " + filme.getDuracao());
		filme.setDuracao(200);
		filmeRepositorio.update2(filme);
		System.out.println("Duracao do filme depois: " + filme.getDuracao());
		
		filmeRepositorio.remove(filme);
		System.out.println("Filme excluído");
		
		List<Filme> resultado = filmeRepositorio.findAll();
		
		exibirFilme(resultado);
		
		fabrica.close();
		
	}
	
	public static void exibirFilme(List<Filme> filmes) {
		for (Filme filme : filmes) {
			System.out.println("Nome: " + filme.getNome());
			System.out.println("Duração: " + filme.getDuracao());
		}
	}
	
}
