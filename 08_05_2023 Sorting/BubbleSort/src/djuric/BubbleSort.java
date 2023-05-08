package djuric;

import java.util.Arrays;

public class BubbleSort {
	
	// metoda koja prolazi kroz niz vise puta i poredi susedne elemente usput ih rasporedjujuci po velicini
	private static void bubbleSort(int[] niz) {	
		
		// iniciramo spoljnju for petlju koja iterira kroz ceo niz		
		for(int i = 0; i < niz.length - 1; i++) {
			
			// iniciramo unutrasnju for petlju kroz niz. gornja granica un. petlje se smanjuje (za vrednost i) jer se u svakom prolazu spoljne petlje
			// poslednja dva elementa u nizu već nalaze na svojim pravim pozicijama, tj. sortirani su			
			for(int j = 0; j < niz.length - i - 1; j++) {
				
				// proveravamo da li je element na indeksu j u nizu veći od prvog narednog elementa				
				if(niz[j] > niz[j+1]) { 
					
					// ako jeste stvaramo pomocnu promenljivu i dodeljujemo joj vrednost elementa na indeksu j
					int pomocni = niz[j];
					
					// dodeljujemo elementu na indeksu j vrednost prvog sledeceg elementa
					niz[j] = niz[j+1];
					
					// postavljamo vrednost elementa na indeksu j+1 na vrednost pomocne promenljive
					niz[j+1] = pomocni;	
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] nizCifara = {3, 8, 7, 1, 9, 5, 4, 6, 2};
		
		System.out.println("PRE:   " + Arrays.toString(nizCifara));
		
		bubbleSort(nizCifara);
		
		System.out.println("POSLE: " + Arrays.toString(nizCifara));		
	}

}
