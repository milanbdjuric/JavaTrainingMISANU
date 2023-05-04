package praksa;

public class CharacterData implements StringExtractor<CharacterData>{
	
    private Character character;
    private String allegiance;
    private String messageFileName;
    
    @Override
    public CharacterData extractFromString(String string, String fieldSeparator) {
    	
    		// delimo string na polja fieldseparatorom (",")
    	
    	String[] fields = string.split(fieldSeparator);
    	
    		// prvo polje je string sa imenom i prezimenom karaktera posiljaoca, njega delimo i pravimo objekat
        
    	this.character = new Character().extractFromString(fields[0], fieldSeparator);
        this.allegiance = fields[1].trim();
        this.messageFileName = fields[2].trim();
        
        return this;
    }
    
    public Character getCharacter() {
        return this.character;
    }

	public String getAllegiance() {
        return this.allegiance;
    }
    
    public String getMessageFileName() {
        return this.messageFileName;
    }
    
    public void setCharacter(Character character) {
		this.character = character;
	}

	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}

	public void setMessageFileName(String messageFileName) {
		this.messageFileName = messageFileName;
	}
}