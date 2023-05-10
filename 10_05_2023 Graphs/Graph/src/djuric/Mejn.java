package djuric;

public class Mejn {

	public static void main(String[] args) {
		
		// kreiramo objekat klase graf
		
		Graph graf = new Graph();
		
		// dodajemo cvorove
		
		graf.dodajCvor("Mika");
		graf.dodajCvor("Zika");
		graf.dodajCvor("Pera");
		graf.dodajCvor("Laza");
		
		// dodajemo veze, tj. pravimo grane
		
		graf.dodajVezu("Mika", "Zika");
		graf.dodajVezu("Mika", "Pera");
		graf.dodajVezu("Mika", "Laza");
		graf.dodajVezu("Pera", "Laza");
		graf.dodajVezu("Pera", "Zika");
		
		// stampamo liste suseda za svaki cvor grafa
		
		graf.printListaSuseda("Mika");
		graf.printListaSuseda("Zika");
		graf.printListaSuseda("Pera");
		graf.printListaSuseda("Laza");
		
		// stampamo koliko cvorova i grana ima graf
		
		System.out.println("Broj cvorova: " + graf.getBrojCvorova());
		System.out.println("Broj grana: " + graf.getBrojGrana());
		

	}
}
