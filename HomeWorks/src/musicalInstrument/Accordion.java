package musicalInstrument;

public class Accordion extends Harmonics {

	@Override
	protected void checkSound() {
		checkFur();
		super.checkSound();
	}

	private void checkFur() {
		System.out.println("Check fur " + this);
	}

	@Override
	protected void clean() {
		waxFur();
		super.clean();
	}

	private void waxFur() {
		System.out.println("Wax fur " + this);
	}

	@Override
	public void service() {
		checkSound();
		colibrateReeds();
		clean();
	}

}
