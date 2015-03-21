package musicalInstrument;

public abstract class Shock extends MusicalInstruments {
	@Override
	protected void checkSound() {
		checkPunchInstrument();
		super.checkSound();
	}

	protected void checkPunchInstrument() {
		System.out.println("Check punck instrument for " + this);
	}
}
