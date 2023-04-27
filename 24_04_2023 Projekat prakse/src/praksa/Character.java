package praksa;

public class Character {
	
	private String name, allegiance, messagesFile;
	
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
}
