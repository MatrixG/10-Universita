package pkgUniversità;
import java.util.ArrayList;
import java.util.List;

import pkgBiblioteca.Utente;;

public class Studente extends Utente implements IsValid {
	
	private String matricola;
	private double media;
	private Università università;
	private List<Corso> corsi;
	
	public Studente(Università università, String nome, String cognome, String matricola) {
		
		super(nome, cognome);
		this.università = università;
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
	
	public String getUniversità (){
		
		return università.getNomeUniversità();
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
