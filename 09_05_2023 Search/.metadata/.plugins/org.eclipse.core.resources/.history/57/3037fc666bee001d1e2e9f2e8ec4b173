package djuric;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	private static int binarySearch(int[] sortiraniNiz, int ciljanaVrednost) {
		
		// skroz levi indeks niza je 0, na pocetku
		int leviIndeks = 0;
		
		//skroz desni je razlika duzine niza i 1 (jer je indeksiranje od 0)
		int desniIndeks = sortiraniNiz.length - 1;
		
		// dok je levi indeks manji ili jednak sa desnim...
		while(leviIndeks <= desniIndeks) {
			
			// ...izracunavamo srednji indeks u nizu...
			int srednjiIndeks = leviIndeks + ((desniIndeks - leviIndeks) / 2);
			
			// ...zatim proveravamo da li nam je ciljana vrednost na srednjem indeksu...
			if(sortiraniNiz[srednjiIndeks] == ciljanaVrednost)
				
				// ...i ako jeste - vracamo srednji indeks.
				return srednjiIndeks;
			
			// ako je ciljana vrednost veca od vrednosti elementa na sr. indeksu...
			else if (sortiraniNiz[srednjiIndeks] < ciljanaVrednost)
				
				// ...onda nastavljamo da je trazimo u desnoj polovini niza...
				leviIndeks = srednjiIndeks + 1;
			else
				// ...a ako je manja - onda u levoj
				desniIndeks = srednjiIndeks - 1;
		}
		
		// ako nema ciljane vrednosti - algoritam vraca -1
		return -1;
	}
	
	public static void main(String[] args) {
		
		int niz[] = {5, 77, 54, 24, 44, 100, 1, 2, 55, 123, 72, 3, 201, 187};

		Arrays.sort(niz);  // mora prvo da se sortira niz da bi se trazilo binarnom pretragom
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Unesite element da vidimo da li je u nizu: ");

		int ciljanaVrednost = sc.nextInt();

		int indeks = binarySearch(niz, ciljanaVrednost);

		if(indeks == -1)
			System.out.println("Trazeni element nije ovde u nizu. ");
		else
			System.out.println("Element " + ciljanaVrednost + " je pronadjen!\nNjegov indeks je: " + indeks);
		
		System.out.println("Izgled niza: " + Arrays.toString(niz));

		sc.close();
	}
}
