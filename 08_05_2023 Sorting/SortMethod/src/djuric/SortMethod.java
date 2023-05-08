package djuric;

import java.util.Arrays;

public class SortMethod {

	public static void main(String[] args) {
		
		int[] nizCifara = {3, 8, 7, 1, 9, 5, 4, 6, 2};
		
		System.out.println("PRE:   " + Arrays.toString(nizCifara));
		
		// (brzo) sortiranje je moguce vrsiti i pozivanjem ugradjene staticke metode sort() klase Array
		Arrays.sort(nizCifara);
		
		System.out.println("POSLE: " + Arrays.toString(nizCifara));
	}
}
