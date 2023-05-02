package praksa;

public enum EmojiType {
	
	HAPPY("happy", "(😄|🙂|😊|😍)"),
	SAD("sad", "(😢|😭|😞|👿)"),
	LOVING("loving", "(😍|😘)");
	
	private String mood, regex;

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
