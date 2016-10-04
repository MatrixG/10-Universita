package pkgUniversità;

import java.util.ArrayList;
import java.util.List;

public class Corso implements IsValid {
	
	private String nomeCorso;
	private int nOre;
	private List<Docente> docenti;
	private List<Studente> studentiIscritti;
	private Università università;
	
	public Corso(Università uni, String nomeCorso, int nOre, Docente docente) {
		
		this.nomeCorso = nomeCorso;
		this.nOre = nOre;
		università = uni;
		docenti = new ArrayList <Docente>();
		docenti.add(docente);
		studentiIscritti = new ArrayList<Studente>();
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public int getnOre() {
		return nOre;
	}
	
	public String getUniversità(){
		
		return università.getNomeUniversità();
	}
	
	public boolean aggiungiDocente(Docente docente){
		
		if (!docenti.contains(docente))
			return docenti.add(docente);
		return false;
	}
	
	public boolean aggiungiStudente(Studente studente){
		
		if (!studentiIscritti.contains(studente)){
			studentiIscritti.add(studente);
			return true;
		}
		return false;
	}

	public boolean cercaDocente(Docente docente) {
		
		for (Docente d : docenti){
			
			if (d.getNome() == docente.getNome() &&
					d.getCognome() == docente.getCognome()){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isValid() {
		if ((nomeCorso == null) && (nomeCorso.isEmpty())){
				return false;
			}
			
			return true;
	}

	public boolean studentePresente(Studente studente) {

		
		return studentiIscritti.contains(studente);
	}

	public String getDocenti() {
		String tmp = "";
		
		for (Docente d : docenti){
			tmp += d.getNome() + " ";
			tmp += d.getCognome() + " ";
		}
		return tmp;
	}

	public String stampaStudenti() {
		
		String tmp = "";
		for (Studente s : studentiIscritti){
			tmp += s.getCognome() + " ";
			tmp += s.getNome() + " ";
		}
		return tmp;
	}
}
