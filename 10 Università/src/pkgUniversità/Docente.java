package pkgUniversità;
import pkgBiblioteca.Utente;

public class Docente extends Utente implements IsValid{
	
	private String codiceFiscale;
	private Università università;

	public Docente(Università università, String nome, String cognome, String codiceFiscale) {
		
		super(nome, cognome);
		this.codiceFiscale = codiceFiscale;
		this.università = università;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public String getUniversità(){
		
		return università.getNomeUniversità();
	}

	public boolean isValid() {
		
		if ((nome == null) && (nome.isEmpty()) &&
				(cognome == null) && (cognome.isEmpty()) ){
				return false;
		}
			
		return true;
	}
}
