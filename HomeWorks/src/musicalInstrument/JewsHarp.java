package musicalInstrument;

public class JewsHarp extends ReedSelfsounding {

	@Override
	public void service() {
		checkSound();
		clean();
		desinsect();
	}

	public void desinsect() {
		System.out.println("Desinsect " + this);
	}

}
