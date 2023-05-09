package djuric;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciSearch {

	private static int fibonacciSearch(int[] sortiraniNiz, int ciljanaVrednost) {
		
		// formula za fibonacijev niz kaze da je svaki element niza jednak zbiru prethodna dva elementa
		// dakle: F(n) = F(n-1) + F(n-2) // pri cemu je n>1
									
		int fib2 = 0;			// iniciramo fib2 i dodeljujemo vrednost 0 			// F(n-2)
		int fib1 = 1;			// iniciramo fib1 i dodeljujemo vrednost 1 			// F(n-1)
		int fib = fib1 + fib2;	// iniciramo fib i dodeljujemo vrednost po formuli 	// F(n)
		
		// smestamo duzinu niza u promenljivu
		int duzinaNiza = sortiraniNiz.length;
		
		// petlja se izvrsava sve dok je duzina niza veca od vrednosti trenutnog elementa fib. niza
		// dakle svaka naredna iteracija izracunava sledeci broj fib.niza - dok ne dodje do kraja
		while(fib < duzinaNiza) {
			
			// vrednost fib1 dodeljujemo fib2 kako bismo zapamtili prethodnu vrednost fib1
			fib2 = fib1;
			
			// vrednost fib dodeljujemo fib2 
			fib1 = fib;
			
			// izracunavamo vrednost fib po formuli fibonacijevog niza
			fib = fib2 + fib1;
		}
		
		// uvodimo promenljivu ofset koja sluzi za pracenje pozicije u nizu
		int ofset = -1;
		
		// petlja se vrti sve dok je vrednost fib veca od 1
		// znaci pretraga se zaustavlja kad dodje do prvog elementa niza ili dok ne nadje ciljanu vrednost
		while (fib > 1){
			
			// svaki put kada se uslov petlje ispuni, izracunava se nova vrednost promenljive i
			// a je minimum izmedju zbira promenljive ofset i promenljive fib2, i duzine niza
			// na ovaj nacin indeks i se nece kretati van granica niza
			int i = Math.min(ofset + fib2, duzinaNiza - 1);
			
			// proveravamo vrednost elementa na poziciji i
			// ako je manja od ciljane vrednosti...
			if(sortiraniNiz[i] < ciljanaVrednost) {
				
				//...pretragu nastavljano u desnom podnizu (u odnosu na i)
				// vrednosti se azuriraju (fib na F(n-1), fib1 na F(n-2) i fib2 na F(n-3) - prelazi se na sledeci segment, ofset se pomera na i
				fib = fib1;
				fib1 = fib2;
				fib2 = fib - fib1;
				ofset = i;
				
			// a ako je veci...	
			} else if(sortiraniNiz[i] > ciljanaVrednost) {
				
				// onda u levom.
				fib = fib2;
				fib1 = fib1 - fib2;
				fib2 = fib - fib1;
				
			// a ako smo uboli - onda je to to	
			} else
				return i;
		}
	
		// proveravamo da li je promenljiva fib1 jednaka 1 - ako jeste znaci da se prethodna iteracija zavrsila sa fib = 1
		// i da se pretraga nalazi na susednom elementu na poziciji ofset+1. ako je tamo ciljana vrednost - eto ga...
		if (fib1 == 1 && sortiraniNiz[ofset + 1] == ciljanaVrednost)
			return ofset + 1;
		
		// ...a ako nije - onda vrednosti nije ni bilo u nizu
		return -1;		
	}
	
	public static void main(String[] args) {
		
		int niz[] = {5, 77, 54, 24, 44, 100, 1, 2, 55, 123, 72, 3, 201, 187};

		Arrays.sort(niz);  // mora prvo da se sortira niz da bi se trazilo fibonacijevom pretragom
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Unesite element da vidimo da li je u nizu: ");

		int ciljanaVrednost = sc.nextInt();

		int indeks = fibonacciSearch(niz, ciljanaVrednost);

		if(indeks == -1)
			System.out.println("Trazeni element nije ovde u nizu. ");
		else
			System.out.println("Element " + ciljanaVrednost + " je pronadjen!\nNjegov indeks je: " + indeks);
		
		System.out.println("Izgled niza: " + Arrays.toString(niz));

		sc.close();
		
		

	}

}
