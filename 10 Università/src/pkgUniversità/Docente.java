package pkgUniversit�;
import pkgBiblioteca.Utente;

public class Docente extends Utente implements IsValid{
	
	private String codiceFiscale;
	private Universit� universit�;

	public Docente(Universit� universit�, String nome, String cognome, String codiceFiscale) {
		
		super(nome, cognome);
		this.codiceFiscale = codiceFiscale;
		this.universit� = universit�;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public String getUniversit�(){
		
		return universit�.getNomeUniversit�();
	}

	public boolean isValid() {
		
		if ((nome == null) && (nome.isEmpty()) &&
				(cognome == null) && (cognome.isEmpty()) ){
				return false;
		}
			
		return true;
	}
}
