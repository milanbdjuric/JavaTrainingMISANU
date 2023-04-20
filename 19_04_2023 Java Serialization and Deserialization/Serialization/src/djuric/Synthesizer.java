package djuric;

/* 
 * Serijalizacija objekata u Javi je proces konverzije stanja objekta u strim bajtova.
 * Vrsi se da bi se objekat sacuvao u fajlu lokalne memorije ili da bi se preneo preko mreze.
 * 
 * Deserijalizacija objekata je obrnuti proces - to je konverzija objekta iz bajtova u njihovo izvorno stanje u memoriji.
 * 
 * Serijalizaciju i deserijalizaciju objekata omogucavaju klase koje implementiraju interfejs Serializable.
 * 
 * Interfejs Serializable nema metode (sto se naziva MARKER interfejs).
 * Njegovom implementacijom u odredjenu klasu nju oznacavamo da u njoj mozemo serijalizovati njene objekte.
 * 
 * U Javi, serialVersionUID je jedinstveni identifikator koji se koristi za serijalizaciju/deserijalizaciju objekata.
 * Koristi se kako bi se proverilo da li je deserijalizovani objekat kompatibilan sa klasom koja se koristi pri serijalizaciji.
 * Ako se identifikatori ne podudaraju - baca se InvalidClassException. 
 */

import java.io.Serializable;

public class Synthesizer implements Serializable{

	private static final long serialVersionUID = 20042023L;
	
	private String ime;
	private int model;
	
	Synthesizer(String name, int model){
		this.ime = name;
		this.model = model;
	}
	
	public String getIme() {
		return ime;
	}
	
	public int getModel(){
		return model;
	}
}
