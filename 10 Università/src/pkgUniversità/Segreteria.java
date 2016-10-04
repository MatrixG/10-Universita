package pkgUniversità;

import java.util.ArrayList;
import java.util.List;

public class Segreteria {
	
	private final int nCaratteriMatricola = 6;
	private int nMatricola;
	private Università università;
	
	private List <Studente> studenti;
	private List <Docente> docenti;
	private List <Corso> corsi;
	
	
	public Segreteria(Università uni) {
		
		nMatricola = 1;
		studenti = new ArrayList<Studente>();
		docenti = new ArrayList<Docente>();
		corsi = new ArrayList<Corso>();
		università = uni;
	}

	public Studente registraStudente (Università uni,
										String nome, String cognome){
		
		String tmp = "s";
		for (int i = 0; i < nCaratteriMatricola - 
					Integer.toString(nMatricola).length(); i++){
			tmp += "0";
		}
		tmp += Integer.toString(nMatricola);
		
		Studente myStud = new Studente(uni, nome, cognome, tmp);
		if ((myStud.isValid()) && (!studenti.contains(myStud))){
			studenti.add(myStud);
			nMatricola++;
			return myStud;
		}
		
		return null;
	}
	
	public Docente registraDocente (Università uni, 
								String nome, String cognome, String CF){
		
		Docente myDoc = new Docente(uni, nome, cognome, CF);
		if (myDoc.isValid() && (!docenti.contains(myDoc))){
			docenti.add(myDoc);
			return myDoc;
		}
		
		return null;
	}
	
	public Corso registraCorso (Università uni, String nome, int ore, Docente docente){
		
		Corso myCorso = new Corso(uni, nome, ore, docente);
		if (myCorso.isValid() && (!corsi.contains(myCorso))){
			corsi.add(myCorso);
			return myCorso;
		}
		return null;
	}
	
	public boolean aggiungiStudenteAlCorso (Studente studente, Corso corso){
		
		if (studenti.contains(studente) && corsi.contains(corso) && 
				!corsi.get(corsi.indexOf(corso)).studentePresente(studente)){
			
			studente.aggiungiCorsoSeguito(corso);
			return corsi.get(corsi.indexOf(corso)).aggiungiStudente(studente);
		}
		return false;
	}
	
	public boolean aggiungiDocenteAlCorso (Docente docente, Corso corso){
		
		if (docenti.contains(docente) && corsi.contains(corso) &&
				!corsi.get(corsi.indexOf(corso)).cercaDocente(docente)){
			
			return corsi.get(corsi.indexOf(corso)).aggiungiDocente(docente);
		}
		
		return false;
	}
	
	public String getUniversità (){
		
		return università.getNomeUniversità();
	}

}
