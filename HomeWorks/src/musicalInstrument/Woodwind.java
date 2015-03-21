package musicalInstrument;

public abstract class Woodwind extends Wind implements WoodBody {
	public void dry() {
		System.out.println("Dry " + this);
	}

	public void wax() {
		System.out.println("Wax " + this);
	}

	@Override
	protected void clean() {
		wax();
		super.clean();
		dry();
	}

}
