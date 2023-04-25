package praksa;

import java.util.*;

public class Character {
	
	private int happySmileys, sadSmileys;
	
	private String name, allegiance, messagesFile;
	
	Character(){}
	
	Character(String name, String allegiance, String messagesFile){
		this.name = name;
		this.allegiance = allegiance;
		this.messagesFile = messagesFile;
 	}

	public String getName() {
		return name;
	}

	public String getAllegiance() {
		return allegiance;
	}

	public String getMessagesFile() {
		return messagesFile;
	}

	public void setHappySmileys(int happySmileys) {
		this.happySmileys = happySmileys;
	}

	public void setSadSmileys(int sadSmileys) {
		this.sadSmileys = sadSmileys;
	}
	
	public int disposition() {
		return happySmileys - sadSmileys;
	}
	
	public List<String> getMessageLines(){
		return FileHelper.loadMessages(messagesFile);
	}
}