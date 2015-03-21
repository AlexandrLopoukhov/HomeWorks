package musicalInstrument;

public abstract class ReedWoodwind extends Wind {
	@Override
	protected void checkSound() {
		checkReed();
		super.checkSound();
	}

	private void checkReed() {
		System.out.println("Check reed " + this);
	}

	protected void configureReed() {
		System.out.println("Configure reed " + this);
	}
}
