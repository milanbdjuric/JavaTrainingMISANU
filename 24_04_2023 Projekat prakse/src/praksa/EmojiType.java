package praksa;

public enum EmojiType {
	
		// konstante - tipovi emotikona;
	
	HAPPY("happy", "(😄|🙂|😊|😍)"), // "|" je "ili" u regexu
	SAD("sad", "(😢|😭|😞|👿)"),
	LOVING("loving", "(😍|😘)");
	
	private String mood, regex;
	
		// enum konstruktor sa 2 stringa - za raspolozenje i regex

	EmojiType(String mood, String regex) {
		this.mood = mood;
		this.regex = regex;
	}

	public String getMood() {
		return mood;
	}

	public String getRegex() {
		return regex;
	}
}
