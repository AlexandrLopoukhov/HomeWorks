package musicalInstrument;

public class Сontrabass extends Bow implements WoodBody {
	@Override
	protected void clean() {
		wax();
		super.clean();
		dry();
	}

	@Override
	public void service() {
		checkSound();
		clean();
		colibrateStrings();
	}

	@Override
	public void dry() {
		System.out.println("Dry " + this);
	}

	@Override
	public void wax() {
		System.out.println("Wax " + this);
	}

}
