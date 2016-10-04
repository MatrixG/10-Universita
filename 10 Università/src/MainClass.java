import pkgBiblioteca.Biblioteca;
import pkgGestione.Gestione;
import pkgUniversità.*;

public class MainClass {

	public static void main(String[] args) {
		
		Università università = new Università("Bau Bau");
		Segreteria segreteria = new Segreteria(università);
		Biblioteca myBiblioteca = new Biblioteca("Alessandria");
		Gestione segreteriaBiblio = new Gestione();
		
		Studente myStud = segreteria.registraStudente(università, "Franco", "Ciccio");
		System.out.println(myStud.getNome() + " " + myStud.getCognome() + " " + "Matricola: " + myStud.getMatricola());
		Studente myStud2 = segreteria.registraStudente(università, "Diego", "Maradona");
		System.out.println(myStud2.getNome() + " " + myStud2.getCognome() + " " + "Matricola: " + myStud2.getMatricola());
		Studente myStud3 = segreteria.registraStudente(università, "Freddie", "Mercury");
		System.out.println(myStud3.getNome() + " " + myStud3.getCognome() + " " + "Matricola: " + myStud3.getMatricola());
		Studente myStud4 = segreteria.registraStudente(università, "Luciano", "Pavarotti");
		System.out.println(myStud4.getNome() + " " + myStud4.getCognome() + " " + "Matricola: " + myStud4.getMatricola());
		Studente myStud5 = segreteria.registraStudente(università, "Bat", "Man");
		System.out.println(myStud5.getNome() + " " + myStud5.getCognome() + " " + "Matricola: " + myStud5.getMatricola());

		
		Docente myDoc = segreteria.registraDocente(università, "Mister", "Gandalf", "MSTGND99N10L101X");
		System.out.println(myDoc.getNome() + " " + myDoc.getCognome() + " " + myDoc.getCodiceFiscale());
		Docente myDoc2 = segreteria.registraDocente(università, "Jack", "The Ripper", "JKKTRP20A15797Q");
		System.out.println(myDoc2.getNome() + " " + myDoc2.getCognome() + " " + myDoc2.getCodiceFiscale());
		Docente myDoc3 = segreteria.registraDocente(università, "Jack", "Sparrow", "JKASPR44S29X123R");
		System.out.println(myDoc3.getNome() + " " + myDoc3.getCognome() + " " + myDoc3.getCodiceFiscale());
	
		
		Corso corso1 = segreteria.registraCorso(università, "Analisi I", 800, myDoc);
		System.out.println(corso1.getNomeCorso() + " " + corso1.getnOre() + " " + corso1.getDocenti());
		Corso corso2 = segreteria.registraCorso(università, "Geometria", 640, myDoc2);
		System.out.println(corso2.getNomeCorso() + " " + corso2.getnOre() + " " + corso2.getDocenti());
		Corso corso3 = segreteria.registraCorso(università, "Fisica", 500, myDoc3);
		System.out.println(corso3.getNomeCorso() + " " + corso3.getnOre() + " " + corso3.getDocenti());
		
		//aggiungi docente
		corso1.aggiungiDocente(myDoc3);
		System.out.println("Docenti corso di " + corso1.getNomeCorso() + ": " + corso1.getDocenti());
		
		if (segreteria.aggiungiStudenteAlCorso(myStud, corso1))
			System.out.println("Studente " + myStud.getCognome() + " aggiunto al corso " + corso1.getNomeCorso());
		if (segreteria.aggiungiStudenteAlCorso(myStud2, corso1))
			System.out.println("Studente " + myStud2.getCognome() + " aggiunto al corso " + corso1.getNomeCorso());
		if (segreteria.aggiungiStudenteAlCorso(myStud3, corso2))
			System.out.println("Studente " + myStud3.getCognome() + " aggiunto al corso " + corso2.getNomeCorso());
		if (segreteria.aggiungiStudenteAlCorso(myStud4, corso3))
			System.out.println("Studente " + myStud4.getCognome() + " aggiunto al corso " + corso3.getNomeCorso());
		if (segreteria.aggiungiStudenteAlCorso(myStud5, corso1))
			System.out.println("Studente " + myStud5.getCognome() + " aggiunto al corso " + corso1.getNomeCorso());

		//Stampa lista studenti
		System.out.println("Studenti iscritti al corso " + corso1.getNomeCorso() + ": " + corso1.stampaStudenti());
	
		//Aggiungi docente al corso;
		if (segreteria.aggiungiDocenteAlCorso(myDoc3, corso1))
			System.out.println("Docente " + myDoc3.getCognome() + " aggiunto al corso " + corso1.getNomeCorso());
	
		segreteriaBiblio.registraLibro(myBiblioteca, "Sahara", "Cussler", "0001", 1);
		segreteriaBiblio.registraLibro(myBiblioteca, "Inferno", "Dan Brown", "0002", 3);
		segreteriaBiblio.registraLibro(myBiblioteca, "Nel Bianco", "Follet", "0003", 2);
		segreteriaBiblio.registraLibro(myBiblioteca, "Il Barone Rampante", "Italo Calvino", "0004", 1);
		segreteriaBiblio.registraLibro(myBiblioteca, "Sahara", "Cussler", "0001", 1);
		
	}
}
