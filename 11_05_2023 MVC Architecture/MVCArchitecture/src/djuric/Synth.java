package djuric;

	// MVC (Model-view-controller) arhitektura je dizajn patern koji sluzi najcesce za razvoj korisnickih interfejsa.
	// U pitanju je obrazac gde input kontroler prima zahtev od korisnika, salje odgovarajuce podatke objektu modela,
	// uzima odgovor od njega i prosledjuje ga u view (prikaz), gde ga je moguce prikazati korisniku.
	// Razdvajanjem koda u tri medjusobno povezane celine omogucava se brza izmena podataka, bolja citljivost koda, itd.

	// MODEL - centralna komponenta paterna, nezavisna od korisnickog interfejsa. Direktno radi sa podacima, odredjuje
	// logiku i pravila aplikacije.

public class Synth {
	
	private String manufacturer, model;
	
	Synth(String manufacturer, String model){
		this.manufacturer = manufacturer;
		this.model = model;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufactrer() {
		return manufacturer;
	}
	
	public String getModel() {
		return model;
	}
}
