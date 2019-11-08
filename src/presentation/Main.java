package presentation;

import java.util.ArrayList;
import java.util.List;

import metier.Annonce;
import metier.Personne;
import service.Iservice;
import service.ServiceImpl;

public class Main {

	public static void init() {
		ServiceImpl.base.add(new Personne(1, "Nozerand", "Cédric", "cednoz", "azerty", "20/10/1993"));
		ServiceImpl.base.add(new Personne(2, "Mauret", "Jean", "jeamau", "azerty", "10/12/2000"));
		ServiceImpl.base.add(new Personne(3, "Hibert", "Marie", "marhib", "azerty", "08/02/1969"));
	}
	
	public static void main(String[] args) {
		Iservice service = new ServiceImpl();
		init();
		
		System.out.println("Avant ajout");
		System.out.println(ServiceImpl.base);
		
		System.out.println("------------------------------------------");
		Personne personne = new Personne(4, "Parot", "Sandrine", "sanpar", "azerty", "29/10/1969");
		System.out.println("Etape 1");
		service.creerPersonne(ServiceImpl.base, personne);
		System.out.println(ServiceImpl.base);
		
		System.out.println("------------------------------------------");
		System.out.println("Etape 2");
		System.out.println(service.getPersonne(ServiceImpl.base, 2));
		
		System.out.println("------------------------------------------");
		System.out.println("Etape 3");
		service.deletePersonne(ServiceImpl.base, 2);
		System.out.println(ServiceImpl.base);
		
		System.out.println("------------------------------------------");
		System.out.println("Etape 4");
		service.updatePersonne(ServiceImpl.base, personne, "tata", "toto", "30/05/1994");
		System.out.println(ServiceImpl.base);
		
		System.out.println("------------------------------------------");
		System.out.println("Etape 5");
		System.out.println(service.findAllPersonnes());
		
		System.out.println("------------------------------------------");
		System.out.println("Etape 6");
		System.out.println(service.getPersonneId(ServiceImpl.base, ServiceImpl.base.get(1)));
		
		System.out.println("------------------------------------------");
		System.out.println("Etape 7");
		service.affichePersonnes();
		
		List<Annonce> annonces = new ArrayList<Annonce>();
		annonces.add(new Annonce(1, "annonce 1", "test", 30.0F));
		annonces.add(new Annonce(2, "annonce 2", "test2", 40.0F));
		annonces.add(new Annonce(3, "annonce 3", "test3", 50.0F));
		
		personne.setAnnonces(annonces);
		service.creerAnnonce(personne, annonces.get(1));
		
		System.out.println("------------------------------------------");
		System.out.println("Etape 8");
		System.out.println(service.getAnnonce(personne, 2));
		
		service.deleteAnnonce(personne, 2);
		
		System.out.println("------------------------------------------");
		System.out.println("Etape 9");
		service.updateAnnonce(personne, annonces.get(2), "nouveau intitulé", "nouveau detail", 120.0F);
		System.out.println(service.getAnnonce(personne, 2));
		
		System.out.println("------------------------------------------");
		System.out.println("Etape 10");
		System.out.println(service.findAllAnnonce(personne));
	}
}
