package musicalInstrument;

public class Bassoon extends ReedWoodwind {

	@Override
	public void service() {
		checkSound();
		clean();
		configureReed();
	}

}
