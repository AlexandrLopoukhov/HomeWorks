package musicalInstrument;

public abstract class MusicalInstruments {

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

	protected void checkSound() {
		System.out.println(this + " check sound");
	}

	protected void clean() {
		System.out.println("Clean " + this);
	}

	public abstract void service();

}
