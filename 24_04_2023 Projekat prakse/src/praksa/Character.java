package praksa;

import java.util.Objects;

public class Character implements StringExtractor<Character>{
	
	private String firstName, lastName;
	
	@Override
	public Character extractFromString(String entity, String fieldSeparator) {
		
		String[] fields = entity.split(fieldSeparator);
		this.firstName = fields[0].trim();
		
		if(fields.length > 1)
			this.lastName = fields[1].trim();
		return this;
	}
	
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
