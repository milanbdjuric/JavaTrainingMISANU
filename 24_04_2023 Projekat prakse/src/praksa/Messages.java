package praksa;

import java.util.*;

public class Messages {
	
	private List<String> messages;
	
	Character sender;
	
	Messages(Character sender){
		this.sender = sender;
		this.messages = FileHelper.loadMessages(sender.getMessagesFile());
	}
	
	public Character getSender() {
		return sender;
	}

	public List<String> getMessages() {
		return messages;
	}
		
	public void printMessages() {
		System.out.println(sender.getName() + "`s messages:\n");
		for(int i = 1; i < messages.size(); i++) {
			System.out.println(messages.get(i));
		}
	}
	
	public int countMessages() {
		int msgCounter = 0;
		for(int i = 1; i < messages.size(); i++) {
			if(messages.get(i).isBlank() || messages.get(i).isEmpty())
				continue;
			else
				msgCounter++;
		}
		return msgCounter;
	}
	
	public int countEmojis(String mood) {
		int counter = 0;
		Emoji[] emojis = Emoji.values();
		
		for(Emoji emoji : emojis) {
			if(emoji.getMoods().contains(mood)) {
				String pattern = ".*" + emoji.getEmoji() + ".*";
				for(String message : messages) {
					if (message.matches(pattern))
						counter++;
				}
			}
		}
		return counter;	
	}	
	
	public int countEmojisSentTo(Character recipient, String mood) {	
		Messages messages = new Messages(sender);
		int inLove = 0;
		
		for(String message : getMessages()) {
			if(message.contains(recipient.getName()))
				inLove = messages.countEmojis(mood);
			}
		return inLove;		
		}
	
	public int happinessIndex() {
		return countEmojis("happy") - countEmojis("sad");
	}
	
	public String disposition() {
		if(happinessIndex() > 0)
			return "more happy than sad. ";
		else if(happinessIndex() < 0)
			return "more sad than happy. ";
		else
			return "equally happy and sad.";	
	}
}
