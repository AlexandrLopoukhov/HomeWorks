package musicalInstrument;

public abstract class Membrane extends UndefinedTone {
	@Override
	protected void checkSound() {
		checkMembrane();
		super.checkSound();
	}

	private void checkMembrane() {
		System.out.println("Check membrane " + this);
	}

	protected void pullMembrane() {
		System.out.println("Pull membrane " + this);
	}
}
