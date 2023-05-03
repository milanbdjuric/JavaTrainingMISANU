package praksa;

		//opsti interfejs za izdvajanje podataka iz stringa pomocu separatora

public interface StringExtractor<T> {
	
		// javne staticke konstante koje ce biti separatori polja
	
	public static final String COMMA = ",";
	public static final String SPACE = " ";
	
		// javna metoda koja vraca objekat (genericke klase T, pri implementaciji navodimo stvarnu klasu), na osnovu unetih stringa i separatora
	
	public T extractFromString(String string, String fieldSeparator);
}
