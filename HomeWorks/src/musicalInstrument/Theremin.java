package musicalInstrument;

public class Theremin extends Electromusical {

	public void colibrateEMField() {
		System.out.println("Colibrate EM field " + this);
	}

	public void service() {
		checkSound();
		colibrateEMField();
		clean();
	}

}
