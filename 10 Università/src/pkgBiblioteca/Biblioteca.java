package pkgBiblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pkgGestione.Prestito;

public class Biblioteca {
	
	private static final int maxTempoPrestito = 3;
	private String nome;
	private List<Libro> elencoLibri;
	private List<Utente> elencoUtenti;
	private List<Prestito> elencoPrestiti;
	
	
		
	public Biblioteca(String nome) {
		
		this.nome = nome;
		elencoLibri = new ArrayList<Libro>();
		elencoUtenti = new ArrayList<Utente>();
		elencoPrestiti = new ArrayList<Prestito>();
	}

	public String getNome() {
		return nome;
	}
	
	public Libro cercaLibro(String titolo, String autore){
		
		for (Libro l : elencoLibri){
			
			if (l.getTitolo().equals(titolo) &&
				l.getAutore().equals(autore)){
				return l;
			}
		}
		return null;
	}

	public int aggiungiLibro(String titolo, String autore, String serialN, int copie) {
		
		elencoLibri.add(new Libro(titolo, autore, serialN, copie));
		
		return copie;
	}
	
	public Utente cercaUtente(String nome, String cognome){
		
		for (Utente u : elencoUtenti){
			if (u.getNome().equals(nome) &&
				u.getCognome().equals(cognome)){
				return u;
			}
		}
		
		return null;
	}

	public boolean aggiungiUtente(String nome, String cognome) {
		
		return elencoUtenti.add(new Utente(nome, cognome));
	}

	public boolean aggiungiPrestito(Libro libro, Utente utente){
		
		return elencoPrestiti.add(new Prestito(utente, libro));
	}
	public boolean eliminaPrestito(Libro libro, Utente utente){
		
		for (Prestito p : elencoPrestiti){
			if ((p.getUtente() == utente) && (p.getLibro() == libro))
				return elencoPrestiti.remove(p);
		}
		return false;
	}

	public boolean prestitoLecito(Utente u) {
		
		for (Prestito p : elencoPrestiti){
			
			if (p.getUtente() == u){
				Date now = new Date();
				if (now.getTime() - p.getDataPrestito().getTime() < maxTempoPrestito){
					return true;
				}
				else{
					System.out.println("L'utente " + u.getNome() + " " + u.getCognome() + " deve ancora restituire " + p.getLibro().getTitolo());
					return false;
				}
			}
		}
		
		return true;
	}

	public void rimuoviPrestito(Libro l, Utente u) {
		
		for (Prestito p : elencoPrestiti){
			
			if ((p.getLibro() == l) && (p.getUtente() == u)){
				elencoPrestiti.remove(p);
				return;
			}
		}
	}
	
	
}
