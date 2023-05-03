package praksa;

public class Mejn {

	public static void main(String[] args) throws Exception {
		
			// pravimo objekat za "ovu epizodu"
		
		GoT gameOfThrones = new GoT();
		
			// ucitavamo podatke iz fajlova, pravimo objekte, liste, mapu...
		
		gameOfThrones.load();
		
			// izvlacimo karaktere daenerys i jon sa kojima cemo raditi
		
		Character daenerys = new Character();
		Character jon = new Character();
		
		for(Character character : gameOfThrones.getCharacters()) {
			if(character.toString().contains("Daenerys")) {
				daenerys = character;
			}
			if(character.toString().contains("Jon")) {
				jon = character;
			}
		}
		
			// stampamo sve poruke kataktera posiljaoca
		
		gameOfThrones.printCharacterMessages(daenerys);
		
		System.out.println();
		
			// stampamo koliko je koji karakter poslao poruka
		
		gameOfThrones.printNumberOfMessagesByCharacter();
		
		System.out.println();
		
			// stampamo analizu svakog karaktera
		
		for(Character character : gameOfThrones.getCharacters()) {
			gameOfThrones.printCharacterHappiness(character);
		}
		
		System.out.println();
		
			// stampamo ko je najsrecniji i najtuzniji karakter
		
		gameOfThrones.printCharacterWithMostDisposition(EmojiType.HAPPY);
		
		gameOfThrones.printCharacterWithMostDisposition(EmojiType.SAD);
		
		System.out.println();
		
			// i na kraju ko koga vise voli.

		gameOfThrones.printCharacterToCharacterDisposition(daenerys, jon, EmojiType.LOVING);
		
	}
}
