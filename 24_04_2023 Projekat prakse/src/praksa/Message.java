package praksa;

public class Message implements StringExtractor<Message>{
	
	private Character sender;
    private Character receiver;
    private String content;
    
    @Override
    public Message extractFromString(String entity, String fieldSeparator) {

    		// trazimo indeks prvog zareza, jer se ime posiljaoca nalazi do tog mesta
    	
    	int firstCommaIndex = entity.indexOf(fieldSeparator);
    	
    		// pravimo string sa imenom i prezimenom posiljaoca
              
        String recipientString = entity.substring(0, firstCommaIndex).trim();
        
        	// pravimo string sa imenom i prezimenom posiljaoca
        
        this.receiver = new Character().extractFromString(recipientString.trim(), SPACE);
        
        	// pravimo string same poruke, ne ukljucujuci zarez

        this.content = entity.substring(firstCommaIndex + 1).trim();
        
        	// uklanjamo navodnike jer nisu deo poruke kao takve
        
        this.content = this.content.substring(1, this.content.length()-1);
        
        return this;
    }

    public Character getReceiver() {	
    	return receiver;
	}
    
    public Character getSender() {
    	return sender;
    }
    
	public String getContent() {
		return content;
	}

	public void setReceiver(Character receiver) {
		this.receiver = receiver;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
    public String toString() {
        return "\nRecipient: " + receiver + "\nMessage: " + content;
    }
}
