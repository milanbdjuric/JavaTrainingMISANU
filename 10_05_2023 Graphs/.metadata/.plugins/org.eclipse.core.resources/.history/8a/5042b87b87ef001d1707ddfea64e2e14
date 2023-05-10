package djuric;

import java.util.*;

public class Graph {
	
	// primer neusmerenog grafa predstavljen pomocu mape u kojoj je kljuc string, a vrednost lista stringova
	
	private Map<String, List<String>> listaSuseda;
	
	// konstruktor koji pozivanje pravi novi hashmap za listu suseda
	
	Graph(){
		listaSuseda = new HashMap<>();
	}
	
	// metoda koja smesta cvor kao kljuc mape
	
	public void dodajCvor(String cvor) {
		listaSuseda.put(cvor, new LinkedList<>());
	}
	
	// metoda koja dodaje vezu izmedju cvorova tj. pravi grane;
	
	public void dodajVezu(String odakle, String dokle) {
		
		// ako vec ne sadrzi cvor odakle polazi grana - dodajemo ga
		
		if(!listaSuseda.containsKey(odakle)) {
			dodajCvor(odakle);
		}
		
		// ako vec ne sadrzi cvor dokle ide grana - dodajemo ga
		
		if(!listaSuseda.containsKey(dokle)) {
			dodajCvor(dokle);
		}
		
		// smestamo ih u listu stringova (vrednost mape)
		
		listaSuseda.get(odakle).add(dokle);
		listaSuseda.get(dokle).add(odakle);	
	}
	
	// metoda koja vraca listu suseda  (adjacent list)
	
	public List<String> getListaSuseda(String cvor){
		return listaSuseda.get(cvor);
	}
	
	// metoda koja stampa listu suseda
	
	public void printListaSuseda(String cvor) {
		System.out.println(cvor + ": " + getListaSuseda(cvor));
	}
	
	// metoda koja broji cvorove u grafu pozivanjem metode liste size()
	
	public int getBrojCvorova() {
		return listaSuseda.size();
	}
	
	// metoda koja broji grane iterirajuci kroz mapu i sabirajuci
	
	public int getBrojGrana() {
		int brojGrana = 0;
		for(String cvor : listaSuseda.keySet()) {
			brojGrana += listaSuseda.get(cvor).size();
		}
		return brojGrana;
		
	}
}
