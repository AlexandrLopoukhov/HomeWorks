package musicalInstrument;

public abstract class Keyboards extends MusicalInstruments {
	@Override
	protected void checkSound() {
		checkKeyboards();
		checkPedal();
		super.checkSound();
	}

	private void checkPedal() {
		System.out.println("Check pedal " + this);
	}

	private void checkKeyboards() {
		System.out.println("Check keyboards " + this);
	}

}
