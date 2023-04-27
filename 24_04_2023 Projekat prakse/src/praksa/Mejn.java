package praksa;

import java.util.*;

public class Mejn {

	public static void main(String[] args) {
		
		List<Character> characters = CharacterHelper.importCharacters();
		
		Character daenerys = CharacterHelper.getCharacterByName("Daenerys");		
		
		Messages daenerysMessages = new Messages(daenerys);
		
		daenerysMessages.printMessages();
				
		System.out.println();
				
		Character happiest = null;
		int maxHappy = Integer.MIN_VALUE;
		
		Character saddest = null;
		int maxSad = Integer.MAX_VALUE;
		
		for(Character character : characters) { 
			
			Messages messages = new Messages(character);
			
			int count = messages.countMessages();		
			int happy = messages.countEmojis("happy");
			int sad = messages.countEmojis("sad");
			
			int disposition = messages.happinessIndex();
			String dispositionString = messages.disposition();
			
			System.out.println(character.getName() + " had " + count + " messages. " 
			+ happy + " happy and " + sad + " sad emojis - " + dispositionString);
			
			if(disposition > maxHappy) {
				happiest = character;
				maxHappy = disposition;
			}
			
			if(disposition < maxSad) {
				saddest = character;
				maxSad = disposition;
			}	
		}
		
		System.out.println("\nThe happiest character is " + happiest.getName() 
		+ " of " + happiest.getAllegiance() + ".");
		
		System.out.println("The saddest character is " + saddest.getName() 
		+ " of " + saddest.getAllegiance() + ".");
			
		
		Character jon = CharacterHelper.getCharacterByName("Jon");
					
		CharacterHelper.whoSentMoreEmojisToEachOther(daenerys, jon, "love");
				
	}
}
