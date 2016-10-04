package pkgBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class Utente {
	
	protected String nome;
	protected String cognome;
	List<Libro> libriInPrestito;
	
	
	
	public Utente(String nome, String cognome) {
		
		this.nome = nome;
		this.cognome = cognome;
		libriInPrestito = new ArrayList<Libro>();
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public boolean aggiungiLibroInPrestito(Libro libro) {
		return libriInPrestito.add(libro);
	}
	
	public boolean rimuoviLibroInPrestito(Libro libro){
		return libriInPrestito.remove(libro);
	}
	
	// La funzione restituisce true se il libro 
	// è nella lista dei libri dell'utente
	public boolean cercaLibroInPrestito(Libro libro){
		return libriInPrestito.contains(libro);
	}
	
	// Restituisce il numero di libri in prestito all'utente
	public int numeroLibriInPrestito(){
		return libriInPrestito.size();
	}
}
