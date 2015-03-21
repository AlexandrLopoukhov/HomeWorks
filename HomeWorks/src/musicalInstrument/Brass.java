package musicalInstrument;

public abstract class Brass extends Wind {
	@Override
	protected void clean() {
		polysh();
		super.clean();
	}

	private void polysh() {
		System.out.println("Polysh " + this);
	}
}
