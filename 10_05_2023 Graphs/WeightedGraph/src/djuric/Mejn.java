package djuric;

public class Mejn {

	public static void main(String[] args) {
		
		// kreiramo objekat klase WeightedGraph
		
		WeightedGraph graf = new WeightedGraph();
		
		// dodajemo cvorove
		
		graf.dodajCvor("Mika");
		graf.dodajCvor("Zika");
		graf.dodajCvor("Pera");
		graf.dodajCvor("Laza");
		
		// dodajemo veze, tj. pravimo grane
		
		graf.dodajVezu("Mika", "Zika", 1);
		graf.dodajVezu("Mika", "Pera", 2);
		graf.dodajVezu("Mika", "Laza", 3);
		graf.dodajVezu("Pera", "Laza", 4);
		graf.dodajVezu("Pera", "Zika", 5);
		
		// stampamo liste suseda sa tezinama
		
		graf.printListaSuseda("Mika");
		graf.printListaSuseda("Zika");
		graf.printListaSuseda("Pera");
		graf.printListaSuseda("Laza");

	}

}
