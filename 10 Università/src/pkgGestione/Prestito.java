package pkgGestione;
import pkgBiblioteca.*;

import java.util.Date;

public class Prestito {
	
	Utente utente;
	Libro libro;
	Date dataPrestito;
	
	public Prestito(Utente utente, Libro libro) {
		super();
		this.utente = utente;
		this.libro = libro;
		dataPrestito = new Date();
	}

	public Utente getUtente() {
		return utente;
	}

	public Libro getLibro() {
		return libro;
	}

	public Date getDataPrestito() {
		return dataPrestito;
	}
}
