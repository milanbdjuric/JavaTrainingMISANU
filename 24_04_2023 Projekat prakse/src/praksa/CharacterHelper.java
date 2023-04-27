package praksa;

import java.util.*;

public interface CharacterHelper {
		
	public static List<Character> importCharacters(){
			
			List<Character> characters = new ArrayList<>();
			
			String metadata = FileHelper.loadMetaData();
			String[] lines = metadata.split(System.lineSeparator());
			
			for(int i = 1; i < lines.length; i++) {
				
				String[] string = lines[i].split(",");

				String name = string[0].trim();
				String allegiance = string[1].trim();
				String messagesFile = string[2].trim();
				
				Character character = new Character(name, allegiance, messagesFile);
				
				characters.add(character);
			}
			return characters;
		}
		
		public static Character getCharacterByName(String name) {
			Character x = null;
			
			for(Character character : importCharacters()) {
				if(character.getName().contains(name))
					x = character;
			}
			return x;		
		}
		
		public static void whoSentMoreEmojisToEachOther(Character characterA, Character characterB, String mood) {
			
			Messages characterMessagesA = new Messages(characterA);
			Messages characterMessagesB = new Messages(characterB);
			
			int aLovesB = characterMessagesA.countEmojisSentTo(characterB, mood);	
			int bLovesA = characterMessagesB.countEmojisSentTo(characterA, mood);
			
			String nameA = characterA.getName();
			String nameB = characterB.getName();
			
			System.out.println("\n" + nameA + " sent " + aLovesB + " " + mood + " emojis to " + nameB
			+ ", while " + nameB + " sent " + bLovesA + " to " + nameA + ".");
			
			if(aLovesB > bLovesA)
				System.out.println(characterA.getName() + " loves " + characterB.getName() + " more than vice versa.");
			
			else if(aLovesB < bLovesA)
				System.out.println(characterB.getName() + " loves " + characterA.getName() + " more than vice versa.");
			
			else
				System.out.println(characterA.getName() + " and " + characterB.getName() + " love each other equally.");	
		}
}

