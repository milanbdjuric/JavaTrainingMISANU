package djuric;

import java.util.Arrays;

public class SelectionSort {
	
	private static void selectionSort(int[] niz) {
		
		// iniciramo spoljasnju for petlju koja iterira kroz ceo niz
		for(int i = 0; i < niz.length - 1; i++) {
			
			// postavljamo minimalni indeks na trenutnu poziciju (i)
			int minIndex = i;
			
			// iniciramo unutrasnju for petlju koja se koristi za pronalazenje najmanjeg elementa i prolazi kroz niz pocevsi od i + 1
			for(int j = i + 1; j < niz.length; j++) {
				
				// proveravamo da li je element na indeksu j manji od trenutnog minimuma niz[minIndex]; ako jeste - minimalni index je j
				if(niz[j] < niz[minIndex]) {
					minIndex = j;
				}	
			}
			
			// zamenjujemo trenutni element sa najmanjim elementom u nizu
			int pomocni = niz[i];
			niz[i] = niz[minIndex];
			niz[minIndex] = pomocni;
			
			// i se posle svake iteracije povećava za 1 - novi minimum se trazi u preostalom delu niza, i tako dok ne prodje i sortira sve
		}
	}

	public static void main(String[] args) {
		
		int[] nizCifara = {3, 8, 7, 1, 9, 5, 4, 6, 2};
		
		System.out.println("PRE:   " + Arrays.toString(nizCifara));
		
		selectionSort(nizCifara);
		
		System.out.println("POSLE: " + Arrays.toString(nizCifara));
	}
}
