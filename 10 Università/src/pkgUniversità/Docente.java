package pkgUniversitÓ;
import pkgBiblioteca.Utente;

public class Docente extends Utente implements IsValid{
	
	private String codiceFiscale;
	private UniversitÓ universitÓ;

	public Docente(UniversitÓ universitÓ, String nome, String cognome, String codiceFiscale) {
		
		super(nome, cognome);
		this.codiceFiscale = codiceFiscale;
		this.universitÓ = universitÓ;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public String getUniversitÓ(){
		
		return universitÓ.getNomeUniversitÓ();
	}

	public boolean isValid() {
		
		if ((nome == null) && (nome.isEmpty()) &&
				(cognome == null) && (cognome.isEmpty()) ){
				return false;
		}
			
		return true;
	}
}
