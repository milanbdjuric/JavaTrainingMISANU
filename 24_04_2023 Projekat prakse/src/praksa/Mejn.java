package praksa;

import java.util.*;

public class Mejn {

	public static void main(String[] args) throws Exception {
		
		GoT gameOfThrones = new GoT();
		
		gameOfThrones.load();
		
		List<Character> characters = gameOfThrones.getCharacters();
		
		Character daenerys = new Character();
		Character jon = new Character();
		
		for(Character character : characters) {
			if(character.toString().contains("Daenerys")) {
				daenerys = character;
			}
			if(character.toString().contains("Jon")) {
				jon = character;
			}
		}
		
		gameOfThrones.printCharacterMessages(daenerys);
		
		System.out.println();
		
		gameOfThrones.printNumberOfMessagesByCharacter();
		
		System.out.println();
		
		for(Character character : characters) {
			gameOfThrones.printCharacterHappiness(character);
		}
		
		System.out.println();
		
		gameOfThrones.printCharacterWithMostDisposition(EmojiType.HAPPY);
		gameOfThrones.printCharacterWithMostDisposition(EmojiType.SAD);
		
		System.out.println();

		gameOfThrones.printCharacterToCharacterDisposition(daenerys, jon, EmojiType.LOVING);
		
	}
}
