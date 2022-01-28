package br.com.fuctura.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	//singleton	
	private static EntityManagerFactory fabrica = null;
	
	public static EntityManagerFactory getFabrica() {	
		if(fabrica == null) {
			System.out.println("Instanciando fabrica");
			fabrica = Persistence.createEntityManagerFactory("Fuctura-PU");
		} 
		
		return fabrica;
	}
}
