package musicalInstrument;

public abstract class Bow extends Strings {

	@Override
	protected void checkSound() {
		checkBow();
		checkSoundPiccicato();
		checkSoundBow();
		super.checkSound();
	}

	private void checkBow() {
		System.out.println("Check bow " + this);
	}

	private void checkSoundBow() {
		System.out.println("Check sound bow " + this);
	}

	private void checkSoundPiccicato() {
		System.out.println("Check sound piccicato " + this);
	}

}
