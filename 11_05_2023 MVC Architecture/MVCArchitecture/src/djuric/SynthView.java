package djuric;

	// VIEW ili prikaz podataka obezbedjuje nacine za prezentaciju podataka dobijenih preko kontrolera od strane modela

public class SynthView {
	
	public void printSynthDetails(String manufacturer, String model) {
		System.out.println("Synth details:\nMade By " + manufacturer + "\nModel: " + model + "\n");
	}
}
