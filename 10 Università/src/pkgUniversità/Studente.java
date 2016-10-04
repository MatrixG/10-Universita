package pkgUniversit�;
import java.util.ArrayList;
import java.util.List;

import pkgBiblioteca.Utente;;

public class Studente extends Utente implements IsValid {
	
	private String matricola;
	private double media;
	private Universit� universit�;
	private List<Corso> corsi;
	
	public Studente(Universit� universit�, String nome, String cognome, String matricola) {
		
		super(nome, cognome);
		this.universit� = universit�;
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
	
	public String getUniversit� (){
		
		return universit�.getNomeUniversit�();
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
