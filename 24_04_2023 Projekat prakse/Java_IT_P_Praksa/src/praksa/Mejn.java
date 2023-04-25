package praksa;

import java.util.*;
import java.util.regex.*;

public class Mejn {

	public static void main(String[] args) {
	
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
		
		System.out.println("All Daenerys` meggases:\n");
		
		for(Character character : characters) {
			if(character.getName().contains("Daenerys")) {
				for(int i = 1; i < character.getMessageLines().size(); i++)
					System.out.print(character.getMessageLines().get(i) + "\n");
			}
		}
		
		System.out.println();

		for(Character character : characters) {
			int msgCounter = 0;
			for(int i = 1; i < character.getMessageLines().size(); i++) {
				if(character.getMessageLines().get(i).isBlank() || character.getMessageLines().get(i).isEmpty())
					continue;
				else
					msgCounter++;
			}
			
			System.out.println(character.getName() + " had " + msgCounter + " messages.");
		}
		
		System.out.println();
		
		for(Character character : characters) {			
			int happyCounter = 0;
			int sadCounter = 0;
			
			for(String message : character.getMessageLines()) {

				if(message.matches(".*[😄😊🙂😍].*"))
					happyCounter++;				
				
				if(message.matches(".*[😢😭👿😞].*"))
					sadCounter++;				
			}
			
			character.setHappySmileys(happyCounter);
			character.setSadSmileys(sadCounter);
			
			if (character.disposition() > 0) 
				System.out.println(character.getName() + " is more happy than sad.");
			
			else if (character.disposition() < 0)
				System.out.println(character.getName() + " is more sad than happy.");
			
			else
				System.out.println(character.getName() + " is equally sad and happy.");	
		}
		
		Character happiest = new Character();		
		Character saddest = new Character();
		
		int max = happiest.disposition();
		int min = saddest.disposition();
		
		for(Character c : characters) {
			if (c.disposition() > max) {
				max = c.disposition();
				happiest = c;
			}
			
			if (c.disposition() < min) {
				min = c.disposition();
				saddest = c;
			}
		}
		
		System.out.println("\nThe happiest character is: " + happiest.getName() + " of " + happiest.getAllegiance() + ".");
		
		System.out.println("The saddest character is: " + saddest.getName() + " of " + saddest.getAllegiance() + ".");
		
		int jonLovesDanyCount = 0;
		int danyLovesJonCount = 0;
		
		for(Character character : characters) {
			
			Pattern pattern = Pattern.compile("^Jon.*|^Daenerys.*");
			
			for(String message : character.getMessageLines()) {
				
				Matcher matcher = pattern.matcher(message);
				
				if(message.matches(".*[😍😘].*") && matcher.matches()) {				
					if(character.getName().contains("Daenerys"))
						danyLovesJonCount++;
					if(character.getName().contains("Jon"))
							jonLovesDanyCount++;	
				}
			}
		}
		
		if(jonLovesDanyCount > danyLovesJonCount)
			System.out.println("\nJon loves Daenerys more than Daenerys loves Jon.");
		
		else if(jonLovesDanyCount < danyLovesJonCount)
			System.out.println("\nDaenerys loves Jon more than Jon loves Daenerys.");
		
		else
			System.out.println("\nDaenerys and Jon love each other equally.");
	}
}
