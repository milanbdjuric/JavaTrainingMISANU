package djuric;

	// USER - pokretacka klasa u ovom primeru glumi korisnika

public class Mejn {

	public static void main(String[] args) {
		
		// pravimo objekat klase Synth (modela)
		
		Synth synth = new Synth("Moog", "Typhon");
		
		// pravimo view za ispisivanje detalja objekta klase Synth na konzoli
		
		SynthView synthView = new SynthView();
		
		SynthController synthController = new SynthController(synth, synthView);

		synthController.updateView();
		
		// azuriramo podatak
		
		synthController.setSynthManufacturer("Dreadbox");
		
		System.out.println("Posle azuriranja: \n");
		
		synthController.updateView();
		
		
		

		
	}
}
