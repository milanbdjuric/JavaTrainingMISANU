package djuric;

import java.util.*;

	// primer ponderisanog grafa, predstavljen pomocu mape

public class WeightedGraph {
	
	// ugnjezdena staticka klasa grane; povezana je sa svojom spoljnjom klasom ali nema pristup instancama i metodama spoljne klase
	
	public static class Grana {
		
		// ima destinaciju i tezinu veze

		private String dokle;		
		private int tezina;
	        
		Grana(String dokle, int tezina) {
			this.dokle = dokle;
			this.tezina = tezina;
		}
		
		public String getDokle() {
			return dokle;
		}

		public int getTezina() {
			return tezina;
		}
	}

	private Map<String, List<Grana>> listaSuseda;
	
	// konstruktor koji pozivanje pravi novi hashmap za listu suseda
	
	WeightedGraph(){
		listaSuseda = new HashMap<>();
	}
	
	// metoda koja smesta cvor kao kljuc mape
	
	public void dodajCvor(String cvor) {
		listaSuseda.put(cvor, new LinkedList<>());
	}
	
	// metoda koja dodaje vezu izmedju cvorova tj. pravi grane;
	
	public void dodajVezu(String odakle, String dokle, int tezina) {
		
		// ako vec ne sadrzi cvor odakle polazi grana - dodajemo ga
		
        if (!listaSuseda.containsKey(odakle)) {
            dodajCvor(odakle);
        }
        
		// ako vec ne sadrzi cvor dokle ide grana - dodajemo ga

        if (!listaSuseda.containsKey(dokle)) {
            dodajCvor(dokle);
        }
        
		// smestamo ih u listu stringova (vrednost mape), zajedno sa tezinom

        listaSuseda.get(odakle).add(new Grana(dokle, tezina));
        listaSuseda.get(dokle).add(new Grana(odakle, tezina));
    }
	
	// metoda koja vraca listu suseda  (adjacent list)
	
    public List<Grana> getListaSuseda(String cvor) {
        return listaSuseda.get(cvor);
    }
    
	// metoda koja stampa listu suseda

    public void printListaSuseda(String cvor) {
        
    	List<Grana> listaGrana = listaSuseda.get(cvor);
        
        System.out.print(cvor + ":  ");
        
        for (Grana grana : listaGrana) {
            System.out.print(grana.getDokle() + "(" + grana.getTezina() + ")  ");
        }
        System.out.println();
    }
    

}
