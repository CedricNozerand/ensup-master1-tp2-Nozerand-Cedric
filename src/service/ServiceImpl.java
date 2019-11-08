package service;

import java.util.ArrayList;
import java.util.List;

import metier.Annonce;
import metier.Personne;

public class ServiceImpl implements Iservice{

	public static List<Personne> base = new ArrayList<Personne>();
	
	@Override
	public int creerPersonne(List<Personne> list, Personne personne) {
		list.add(personne);
		return 1;
	}

	@Override
	public Personne getPersonne(List<Personne> list, int idPersonne) {
		for(Personne p : list) {
			if(p.getPersonneId() == idPersonne) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void deletePersonne(List<Personne> list, int idPersonne) {
		for(Personne p : list) {
			if(p.getPersonneId() == idPersonne) {
				list.remove(p);
				break;
			}
		}
	}

	@Override
	public void updatePersonne(List<Personne> list, Personne p, String nom, String prenom, String dateNaissance) {
		for(Personne personne : list) {
			if(personne.getPersonneId() == p.getPersonneId()) {
				personne.setNom(nom);
				personne.setPrenom(prenom);
				personne.setDateDeNaissance(dateNaissance);
				break;
			}
		}
	}

	@Override
	public List<Personne> findAllPersonnes() {
		return (List<Personne>)base;
	}

	@Override
	public int getPersonneId(List<Personne> list, Personne p) {
		for(Personne personne : list) {
			if(personne.getPersonneId() == p.getPersonneId()) {
				return 1;
			}
		}
		// Dans ce cas il faut commencer les id à 1
		return 0;
	}

	@Override
	public void affichePersonnes() {
		for(Personne p : base) {
			System.out.println(p.toString());
		}
	}

	@Override
	public void afficheAnnoncesPersonne(Personne p) {
		for(Annonce a : p.getAnnonces()) {
			System.out.println(a.toString());
		}
	}

	@Override
	public int creerAnnonce(Personne personne, Annonce a) {
		personne.getAnnonces().add(a);
		return 1;
	}

	@Override
	public Annonce getAnnonce(Personne personne, int idAnnonce) {
		for(Annonce a : personne.getAnnonces()) {
			if(a.getIdAnnonce() == idAnnonce) {
				return a;
			}
		}
		return null;
	}

	@Override
	public void deleteAnnonce(Personne personne, int idAnnonce) {
		for(Annonce a : personne.getAnnonces()) {
			if(a.getIdAnnonce() == idAnnonce) {
				personne.getAnnonces().remove(a);
				break;
			}
		}
	}

	@Override
	public void updateAnnonce(Personne personne, Annonce a, String intitule, String detail, float prix) {
		for(Annonce annonce : personne.getAnnonces()) {
			if(annonce.getIdAnnonce() == a.getIdAnnonce()) {
				annonce.setIntitule(intitule);
				annonce.setDetail(detail);
				annonce.setPrix(prix);
				break;
			}
		}
		
	}

	@Override
	public List<Annonce> findAllAnnonce(Personne personne) {
		return personne.getAnnonces();
	}
}
