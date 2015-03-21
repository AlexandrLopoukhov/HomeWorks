package musicalInstrument;

public abstract class DefinedTone extends Shock {
	@Override
	protected void checkSound() {
		checkAbsoluteTone();
		super.checkSound();
	}

	private void checkAbsoluteTone() {
		System.out.println("Check absolute tone for " + this);
	}
}
