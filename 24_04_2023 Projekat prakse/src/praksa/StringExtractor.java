package praksa;

public interface StringExtractor<T> {
	
	public static final String COMMA = ",";
	public static final String SPACE = " ";
	
	public T extractFromString(String string, String fieldSeparator);
}
