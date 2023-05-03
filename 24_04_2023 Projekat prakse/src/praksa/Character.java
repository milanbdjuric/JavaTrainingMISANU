package praksa;

import java.util.Objects;

public class Character implements StringExtractor<Character>{
	
	private String firstName, lastName;
	
	@Override
	public Character extractFromString(String entity, String fieldSeparator) {
		
			// delimo string na polja fieldseparatorom (" ")
		
		String[] fields = entity.split(fieldSeparator);
		
		this.firstName = fields[0].trim();
		
			// pojedini karakteri imaju samo ime. ako imaju i prezime - onda:
		
		if(fields.length > 1)
			this.lastName = fields[1].trim();
		return this;
	}
	
		// metoda koja vraca celobrojnih hash vrednost za ime i prezime; koristicemo je za poredjenje u GoT klasi
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	@Override
	public String toString() {
		if(lastName != null)
			return firstName + " " + lastName;
		else
			return firstName;
	}
}
