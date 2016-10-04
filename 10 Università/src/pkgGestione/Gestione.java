package pkgGestione;

import pkgBiblioteca.Biblioteca;
import pkgBiblioteca.Libro;
import pkgBiblioteca.Utente;


public class Gestione {
	
	// Numero massimo di libri in prestito
	final static int maxLibriinPrestito = 3;
	
	
	public Gestione(){
		
	}
	
	
	// Cerco se il libro non è già presente.
	// Se è presente aggiorno la quantità.
	// Altrimenti lo aggiungo
	public int registraLibro(Biblioteca biblioteca,
								 String titolo,
								 String autore,
								 String serialN,
								 int copieTot){
		
		Libro l = biblioteca.cercaLibro(titolo, autore);
		if (l != null){
			return l.aggiornaNCopie(1);
		}else{
			return biblioteca.aggiungiLibro(titolo, 
												autore,
												serialN,
												copieTot);
		}
	}
	
	
	
	public boolean registraUtente(Biblioteca biblioteca,
								  String nome, String cognome){
		
		
		Utente u = biblioteca.cercaUtente(nome, cognome);
		
		//Controllo che l'utente non sia già registrato
		if (u == null){
			return biblioteca.aggiungiUtente(nome, cognome);
		}
		return false;
	}
	
	// Cerco il libro e l'utente.
	// Poi se esistono, se il libro è disponibile,
	// se l'utente non ha raggiunto il massimo di libri in prestito
	// lo do in prestito
	public boolean prestaLibro(Biblioteca biblioteca,
							   String titolo,
							   String autore,
							   String nome,
							   String cognome){
		
		Libro l = biblioteca.cercaLibro(titolo, autore);
		Utente u = biblioteca.cercaUtente(nome, cognome);
		
		// Controllo che esista l'utente,
		// che esista il libro
		// e che ci siano copie disponibili
		if ((l != null) && 
			(u != null) &&
			(l.getnCopieDisponibili() > 0) &&
			(!u.cercaLibroInPrestito(l)) &&
			(u.numeroLibriInPrestito() <= maxLibriinPrestito) &&
			 biblioteca.prestitoLecito(u)){
			
			biblioteca.aggiungiPrestito(l, u);
			l.aggiornaCopieDisponibili(-1);
			return u.aggiungiLibroInPrestito(l);
		}
		
		return false;
	}
	
	// Cerco il libro e l'utente.
	// Controllo che il libro in oggetto sia in prestito
	// all'utente.
	// Se le condizioni sono verificate rimuovo il prestito 
	// dalla lista dell'utente e aggiorno la quantità in biblioteca
	public boolean restituzioneLibro(Biblioteca biblioteca,
								     String titolo,
								     String autore,
								     String nome,
								     String cognome){
		
		Libro l = biblioteca.cercaLibro(titolo, autore);
		Utente u = biblioteca.cercaUtente(nome, cognome);
		
		// Controllo che esista il libro,
		// che esista l'utente 
		// e che lui abbia preso in prestito quel libro
		if ((l != null) && 
			(u != null) &&
			(u.cercaLibroInPrestito(l))){
				
				biblioteca.rimuoviPrestito(l, u);
				l.aggiornaCopieDisponibili(1);
				return u.rimuoviLibroInPrestito(l);
		}
		
		return false;
	}

}
