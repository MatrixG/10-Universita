package pkgUniversitÓ;
import java.util.ArrayList;
import java.util.List;

import pkgBiblioteca.Utente;;

public class Studente extends Utente implements IsValid {
	
	private String matricola;
	private double media;
	private UniversitÓ universitÓ;
	private List<Corso> corsi;
	
	public Studente(UniversitÓ universitÓ, String nome, String cognome, String matricola) {
		
		super(nome, cognome);
		this.universitÓ = universitÓ;
		this.matricola = matricola;
		this.media = 0;
		corsi = new ArrayList<Corso>();
		
	}

	public String getMatricola() {
		return matricola;
	}

	public double getMedia() {
		return media;
	}
	
	public String getUniversitÓ (){
		
		return universitÓ.getNomeUniversitÓ();
	}
	
	public boolean aggiungiCorsoSeguito(Corso corso){
		if (!corsi.contains(corso))
			return corsi.add(corso);
		return false;
	}

	@Override
	public boolean isValid() {
		
		if ((nome == null) && (nome.isEmpty()) &&
			(cognome == null) && (cognome.isEmpty()) ){
			return false;
		}
		
		return true;
	}
}
