package musicalInstrument;

public class Clavecin extends StringKeyboards implements WoodBody {
	@Override
	protected void clean() {
		wax();
		super.clean();
		dry();
	}

	public void wax() {
		System.out.println("Wax " + this);
	}

	public void service() {
		checkSound();
		colibrateStrings();
		clean();
	}

	@Override
	public void dry() {
		System.out.println("Dry " + this);
	}

}
