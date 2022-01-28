package br.com.fuctura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.fuctura.entity.Filme;
import br.com.fuctura.util.JPAUtil;

public class FilmeRepositorio {

	public void persist(Filme filme) {
		EntityManagerFactory fabrica = JPAUtil.getFabrica();

		EntityManager em = fabrica.createEntityManager();

		EntityTransaction transacao = em.getTransaction();

		transacao.begin();
		em.persist(filme);
		transacao.commit();

		em.close();
	}

	public Filme find(Filme filme) {
		EntityManagerFactory fabrica = JPAUtil.getFabrica();

		EntityManager em = fabrica.createEntityManager();

		Filme retorno = em.find(Filme.class, filme.getCodigo());

		em.close();

		return retorno;
	}

	public void remove(Filme filme) {

		EntityManagerFactory fabrica = JPAUtil.getFabrica();

		EntityManager em = fabrica.createEntityManager();
		
		Filme filmeManaged = em.find(Filme.class, filme.getCodigo()); //find
		
		EntityTransaction transacao = em.getTransaction();

		transacao.begin();
		em.remove(filmeManaged);
		transacao.commit();

		em.close();

	}
	
	public Filme update(Filme filme) {
		EntityManagerFactory fabrica = JPAUtil.getFabrica();

		EntityManager em = fabrica.createEntityManager();
		
		Filme filmeManaged = em.find(Filme.class, filme.getCodigo()); //find
		
		EntityTransaction transacao = em.getTransaction();

		transacao.begin();
		
		filmeManaged.setDuracao(filme.getDuracao());
		
		transacao.commit();

		em.close();
		
		return filmeManaged;
	}
	
	public void update2(Filme filme) {
		EntityManagerFactory fabrica = JPAUtil.getFabrica();

		EntityManager em = fabrica.createEntityManager();
		
		EntityTransaction transacao = em.getTransaction();

		transacao.begin();
		
		em.merge(filme);
		
		transacao.commit();

		em.close();
		
	}
	
	//find = encontrar , all = todos
	public List<Filme> findAll() {
		EntityManagerFactory fabrica = JPAUtil.getFabrica();
		EntityManager em = fabrica.createEntityManager();
		
		Query consulta = em.createQuery("select f from Filme f");
		
		List<Filme> resultadoDaConsulta = consulta.getResultList();
		
		return resultadoDaConsulta;
		
	}
	
	
}
