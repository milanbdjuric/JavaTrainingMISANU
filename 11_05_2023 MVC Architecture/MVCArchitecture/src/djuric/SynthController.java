package djuric;

	// CONTROLLER ili kontroler - posrednik izmedju MODEL-a i VIEW-a. Tu su glavni mehanizmi za kontrolu toka podataka.
	// On prihvata i interpretira ulazne podatke korisnika i prosledjuje ih modelu ili ih prikazuje korisniku.

public class SynthController {
	
	private Synth synth;
	private SynthView synthView;
	
	SynthController(Synth synth, SynthView synthView){
		this.synth = synth;
		this.synthView = synthView;
	}
	
	public String getSynthManufacturer() {
		return synth.getManufactrer();
	}

	public void setSynthManufacturer(String manufacturer) {
		synth.setManufacturer(manufacturer);
	}
	
	public String getSynthModel() {
		return synth.getModel();
	}

	public void setSynthModel(String model) {
		synth.setModel(model);
	}
	
	// metoda kontrolera koja azurira prikaz najnovijim podacima iz modela
	// koje prosledjuje ih objektu klase SynthView, sto predstavlja prikaz
	// objekat SynthView zatim dalje prikazuje podatke korisniku
	
	public void updateView() {
		synthView.printSynthDetails(synth.getManufactrer(), synth.getModel());
	}
}
