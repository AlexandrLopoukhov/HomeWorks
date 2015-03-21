package musicalInstrument;

public abstract class Plucked extends Strings {
	@Override
	protected void checkSound() {
		checkFreats();
		super.checkSound();
	}

	private void checkFreats() {
		System.out.println("Check freats " + this);
	}

	protected void configureFreats() {
		System.out.println("Configure freats " + this);
	}
}
