package musicalInstrument;

public class Drums extends Membrane {
	@Override
	protected void checkSound() {
		checkCroinstein();
		super.checkSound();
	}

	@Override
	protected void clean() {
		waxDrumsBody();
		super.clean();
	}

	private void waxDrumsBody() {
		System.out.println("Wax drums body " + this);
	}

	private void checkCroinstein() {
		System.out.println("Check croinstein " + this);
	}

	@Override
	public void service() {
		checkSound();
		clean();
		pullMembrane();
	}

}
