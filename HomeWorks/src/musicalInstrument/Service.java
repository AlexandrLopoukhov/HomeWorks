package musicalInstrument;

public class Service {

	public static void serving(final MusicalInstruments mu) {
		mu.service();
	}

	public static void main(final String[] args) {

		Theremin t = new Theremin();
		t.service();
		System.out.println();
		serving(t);
		System.out.println();

		/*
		 * Keyboards k1 = new Organ(); k1.service(); System.out.println();
		 * 
		 * Keyboards k2 = new Clavecin(); k2.service(); System.out.println();
		 * 
		 * Flute f = new Flute(); f.service(); System.out.println();
		 */
	}
}
