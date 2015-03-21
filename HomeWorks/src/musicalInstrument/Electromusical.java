package musicalInstrument;

public abstract class Electromusical extends MusicalInstruments {

	@Override
	protected void checkSound() {
		checkCurrent();
		turnOn();
		super.checkSound();
		turnOff();
	}

	private void turnOff() {
		System.out.println("turnOff " + this);
	}

	private void turnOn() {
		System.out.println("turnOn " + this);
	}

	private void checkCurrent() {
		checkCable();
		checkVoltage();
	}

	private void checkVoltage() {
		System.out.println("Check normal voltage to " + this);
	}

	private void checkCable() {
		System.out.println("Check cable " + this);
	}

}
