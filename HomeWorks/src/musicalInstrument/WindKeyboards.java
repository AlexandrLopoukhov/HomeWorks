package musicalInstrument;

public abstract class WindKeyboards extends Keyboards {
	@Override
	protected void checkSound() {
		checkTubes();
		super.checkSound();
	}

	private void checkTubes() {
		System.out.println("Check tubes " + this);
	}

	@Override
	protected void clean() {
		waxTubes();
		super.clean();
	}

	private void waxTubes() {
		System.out.println("Wax tubes " + this);
	}
}
