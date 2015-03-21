package musicalInstrument;

public abstract class LabialWoodwind extends Wind implements WoodBody {

	@Override
	protected void checkSound() {
		checkLebial();
		super.checkSound();
	}

	@Override
	protected void clean() {
		wax();
		super.clean();
		dry();
	}

	private void checkLebial() {
		System.out.println("Check lebial " + this);
	}

	protected void configureLebial() {
		System.out.println("Configure lebial " + this);
	}

	public void dry() {
		System.out.println("Dry " + this);
	}

	public void wax() {
		System.out.println("Wax " + this);
	}
}
