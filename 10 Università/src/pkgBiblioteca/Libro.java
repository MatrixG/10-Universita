package pkgBiblioteca;

public class Libro {
	
	private String titolo;
	private String autore;
	private String serialN;
	private int nCopie;
	private int nCopieDisponibili;
	
	
	public Libro(String titolo, String autore, String serialN, int nCopie) {
		
		this.titolo = titolo;
		this.autore = autore;
		this.nCopie = nCopie;
		this.nCopieDisponibili = nCopie;
		this.serialN = serialN;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getAutore() {
		return autore;
	}
	
	public String getSerialN() {
		return serialN;
	}

	public int getnCopie() {
		return nCopie;
	}

	// Aggiorna il numero di copie totali
	public int aggiornaNCopie(int nCopie) {
		nCopieDisponibili += nCopie;
		return this.nCopie += nCopie;
	}

	public int getnCopieDisponibili() {
		return nCopieDisponibili;
	}
	
	// Aggiorna il numero di copie disponibili
	public void aggiornaCopieDisponibili(int nCopieDisponibili) {
		this.nCopieDisponibili += nCopieDisponibili;
	}
	
	
	
	
	

}
