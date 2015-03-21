package musicalInstrument;

public class Guitar extends Plucked {

	@Override
	public void service() {
		checkSound();
		clean();
		configureFreats();
		colibrateStrings();
	}

}
