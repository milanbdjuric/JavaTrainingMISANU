package djuric;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {

	// metoda za pretragu u nizu (celih brojeva) koja pretrazuje svaki element,
	// uporedjuje ga sa trazenim elementom i vraca njegov indeks u nizu
	
	private static int linearSearch(int[] niz, int ciljanaVrednost) {
		
		// iteriramo kroz ceo niz
		for(int i = 0; i < niz.length; i++) {
			
			// pretrazuje svaki element niza, do kraja
			if (niz[i] == ciljanaVrednost) {
				
				// ako ga pronadje - vraca njegov indeks u nizu
				return i;
			}
		}
		// ako ga ne pronadje vraca vrednost -1
		return -1;	
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int niz[] = {5, 77, 54, 24, 44, 100, 1, 2, 55, 123, 72, 3, 201, 187};
		
		// nije potrebno sortirati niz prilikom linearne pretrage
		
		System.out.println("Unesite element da vidimo da li je u nizu: ");
		
		int ciljanaVrednost = sc.nextInt();
		
		int indeks = linearSearch(niz, ciljanaVrednost);
		
		if(indeks == -1)
			System.out.println("Trazeni element nije ovde u nizu. ");
		else
			System.out.println("Element " + ciljanaVrednost + " je pronadjen!\nNjegov indeks je: " + indeks);
		
		System.out.println("Izgled niza: " + Arrays.toString(niz));
		
		sc.close();
	}
}